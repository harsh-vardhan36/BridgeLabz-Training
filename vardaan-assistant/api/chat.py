from http.server import BaseHTTPRequestHandler
import json
import os
import requests


# NOTE: Vercel's Python runtime requires the entrypoint class to be named exactly
# 'handler' (lowercase). This is a platform requirement, not a style choice.
class handler(BaseHTTPRequestHandler):  # noqa: N801
    """Vercel Python serverless function for the Vardaan Assistant chat endpoint."""

    def do_OPTIONS(self):
        self.send_response(200)
        self._set_cors_headers()
        self.end_headers()

    def do_POST(self):
        content_length = int(self.headers.get("Content-Length", 0))
        try:
            body = json.loads(self.rfile.read(content_length))
        except (json.JSONDecodeError, ValueError):
            self._send_json(400, {"error": "Invalid JSON in request body."})
            return

        api_key = os.environ.get("GROQ_API_KEY")
        if not api_key:
            self._send_json(
                500,
                {"error": "GROQ_API_KEY is not configured on the server. "
                          "Please set it in your Vercel environment variables."},
            )
            return

        messages = body.get("messages")
        if not messages:
            user_message = body.get("message", "").strip()
            if not user_message:
                self._send_json(400, {"error": "No message provided."})
                return
            messages = [{"role": "user", "content": user_message}]

        try:
            resp = requests.post(
                "https://api.groq.com/openai/v1/chat/completions",
                headers={
                    "Authorization": f"Bearer {api_key}",
                    "Content-Type": "application/json",
                },
                json={
                    "model": "mixtral-8x7b-32768",
                    "messages": messages,
                    "max_tokens": 1024,
                },
                timeout=30,
            )
            resp.raise_for_status()
            data = resp.json()
            reply = data["choices"][0]["message"]["content"]
            self._send_json(200, {"reply": reply})
        except requests.exceptions.Timeout:
            self._send_json(504, {"error": "Request to Groq API timed out. Please try again."})
        except requests.exceptions.HTTPError as exc:
            status = exc.response.status_code if exc.response is not None else 502
            self._send_json(status, {"error": "Groq API returned an error. Check your API key."})
        except requests.exceptions.RequestException:
            self._send_json(502, {"error": "Failed to reach Groq API. Please check your connection."})

    def _set_cors_headers(self):
        self.send_header("Access-Control-Allow-Origin", "*")
        self.send_header("Access-Control-Allow-Methods", "POST, OPTIONS")
        self.send_header("Access-Control-Allow-Headers", "Content-Type")

    def _send_json(self, status, data):
        self.send_response(status)
        self.send_header("Content-Type", "application/json")
        self._set_cors_headers()
        self.end_headers()
        self.wfile.write(json.dumps(data).encode("utf-8"))

    def log_message(self, format, *args):
        pass  # Suppress default request logs

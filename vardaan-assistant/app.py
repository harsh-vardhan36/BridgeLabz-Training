"""
Local development server for Vardaan Assistant.
Run this file to test the app locally before deploying to Vercel.

Usage:
    pip install -r requirements.txt
    cp .env.example .env   # then fill in GROQ_API_KEY
    python app.py
"""

import os

import requests
from dotenv import load_dotenv
from flask import Flask, jsonify, request, send_from_directory

load_dotenv()

app = Flask(__name__, static_folder="public", static_url_path="")


@app.route("/")
def index():
    return send_from_directory("public", "index.html")


@app.route("/api/chat", methods=["POST"])
def chat():
    body = request.get_json(silent=True) or {}

    api_key = os.environ.get("GROQ_API_KEY")
    if not api_key:
        return jsonify(
            {"error": "GROQ_API_KEY is not set. Copy .env.example to .env and add your key."}
        ), 500

    messages = body.get("messages")
    if not messages:
        user_message = body.get("message", "").strip()
        if not user_message:
            return jsonify({"error": "No message provided."}), 400
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
        return jsonify({"reply": reply})
    except requests.exceptions.Timeout:
        return jsonify({"error": "Request to Groq API timed out. Please try again."}), 504
    except requests.exceptions.HTTPError as exc:
        status = exc.response.status_code if exc.response is not None else 502
        return jsonify({"error": "Groq API returned an error. Check your API key."}), status
    except requests.exceptions.RequestException:
        return jsonify({"error": "Failed to reach Groq API. Check your connection."}), 502


if __name__ == "__main__":
    port = int(os.environ.get("PORT", 5000))
    debug = os.environ.get("FLASK_DEBUG", "1") == "1"
    app.run(debug=debug, port=port)

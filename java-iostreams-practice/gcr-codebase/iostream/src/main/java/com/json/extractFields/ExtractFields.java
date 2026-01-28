package com.json.extractFields;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ExtractFields {
	public static void main(String[] args) {
		String jsonInput = "{\"name\":\"Harsh\", \"email\":\"harsh@example.com\", \"city\":\"Bhopal\", \"zip\":\"462022\"}";

		try {
			ObjectMapper mapper = new ObjectMapper();
			JsonNode root = mapper.readTree(jsonInput);

			String name = root.path("name").asText();
			String email = root.path("email").asText();

			System.out.println("Extracted Name: " + name);
			System.out.println("Extracted Email: " + email);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
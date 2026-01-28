package com.json.validateUsingJackson;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ValidateJson {
	public static void main(String[] args) {
		String validJson = "{\"key\": \"value\"}";
		String invalidJson = "{key: value}"; // Missing quotes

		System.out.println("Is validJson valid? " + isValid(validJson));
		System.out.println("Is invalidJson valid? " + isValid(invalidJson));
	}

	public static boolean isValid(String jsonString) {
		try {
			new ObjectMapper().readTree(jsonString);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
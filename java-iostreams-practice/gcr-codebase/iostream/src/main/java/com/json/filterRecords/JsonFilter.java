package com.json.filterRecords;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonFilter {
	public static void main(String[] args) throws Exception {
		String jsonInput = "[{\"name\":\"A\", \"age\":20}, {\"name\":\"B\", \"age\":30}, {\"name\":\"C\", \"age\":28}]";
		ObjectMapper mapper = new ObjectMapper();
		JsonNode root = mapper.readTree(jsonInput);

		System.out.println("Users older than 25:");
		for (JsonNode node : root) {
			if (node.get("age").asInt() > 25) {
				System.out.println(node.get("name").asText() + " (" + node.get("age") + ")");
			}
		}
	}
}
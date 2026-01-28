package com.json.filterRecords;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class FilterJsonRecords {
	public static void main(String[] args) {
		String jsonArray = "[" + "{\"name\":\"Harsh\", \"age\":22}," + 
						"{\"name\":\"Soya\", \"age\":26},"
						+ "{\"name\":\"Sita\", \"age\":28}," + 
						"{\"name\":\"saral\", \"age\":24}]";

		try {
			ObjectMapper mapper = new ObjectMapper();
			JsonNode root = mapper.readTree(jsonArray);

			System.out.println("Records where age > 25:");
			for (JsonNode node : root) {
				if (node.path("age").asInt() > 25) {
					System.out.println("- " + node.path("name").asText() + " (" + node.path("age").asInt() + ")");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
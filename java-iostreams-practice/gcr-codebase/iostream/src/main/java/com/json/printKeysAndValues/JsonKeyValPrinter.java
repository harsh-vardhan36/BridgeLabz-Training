package com.json.printKeysAndValues;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.util.Iterator;
import java.util.Map;

public class JsonKeyValPrinter {
	public static void main(String[] args) {
		try {
			ObjectMapper mapper = new ObjectMapper();
			// Path to your json file
			JsonNode root = mapper.readTree(new File("src/main/java/jsonData/resources/data.json"));

			Iterator<Map.Entry<String, JsonNode>> fields = root.fields();
			while (fields.hasNext()) {
				Map.Entry<String, JsonNode> field = fields.next();
				System.out.println("Key: " + field.getKey() + " | Value: " + field.getValue());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
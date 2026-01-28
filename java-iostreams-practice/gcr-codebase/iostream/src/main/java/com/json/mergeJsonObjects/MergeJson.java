package com.json.mergeJsonObjects;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class MergeJson {
	public static void main(String[] args) {
		try {
			ObjectMapper mapper = new ObjectMapper();

			ObjectNode info = mapper.createObjectNode().put("name", "Harsh").put("id", 101);
			ObjectNode status = mapper.createObjectNode().put("active", true).put("role", "Developer");

			// Merge status into info
			info.setAll(status);

			System.out.println("Merged Result: " + info.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
package com.json.jsonObject;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.ArrayNode;

public class StudentJson {
	public static void main(String[] args) throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		ObjectNode student = mapper.createObjectNode();

		student.put("name", "Harsh Vardhan");
		student.put("age", 22);

		ArrayNode subjects = student.putArray("subjects");
		subjects.add("Java").add("Python").add("Spring Boot");

		System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(student));
	}
}
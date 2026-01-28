package com.json.jsonArray;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.*;

class User {
	public int id;
	public String name;

	public User(int id, String name) {
		this.id = id;
		this.name = name;
	}
}

public class ListToJsonArray2 {
	public static void main(String[] args) throws Exception {
		List<User> users = Arrays.asList(new User(1, "Harsh"), new User(2, "Raj"));

		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(users);
		System.out.println(json);
	}
}
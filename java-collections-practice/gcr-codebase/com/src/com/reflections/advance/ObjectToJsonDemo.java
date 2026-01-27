package com.reflections.advance;

import java.lang.reflect.Field;

public class ObjectToJsonDemo {

	// 🔹 Convert Object to JSON-like String
	public static String toJson(Object obj) {

		if (obj == null)
			return "null";

		Class<?> cls = obj.getClass();
		Field[] fields = cls.getDeclaredFields();

		StringBuilder json = new StringBuilder();
		json.append("{");

		try {
			for (int i = 0; i < fields.length; i++) {
				Field field = fields[i];
				field.setAccessible(true);

				json.append("\"").append(field.getName()).append("\":");

				Object value = field.get(obj);

				if (value instanceof String) {
					json.append("\"").append(value).append("\"");
				} else {
					json.append(value);
				}

				if (i < fields.length - 1) {
					json.append(", ");
				}
			}
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}

		json.append("}");
		return json.toString();
	}

	// 🔹 Sample class
	static class Student {
		private int id;
		private String name;
		private boolean active;

		Student(int id, String name, boolean active) {
			this.id = id;
			this.name = name;
			this.active = active;
		}
	}

	public static void main(String[] args) {

		Student student = new Student(101, "Anuj", true);

		String json = toJson(student);
		System.out.println(json);
	}
}
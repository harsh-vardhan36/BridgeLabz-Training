package com.reflections.advance;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class CustomObjectMapperDemo {

	//  Generic Object Mapper Method
	public static <T> T toObject(Class<T> clazz, Map<String, Object> properties) {

		try {
			// Create object dynamically
			T obj = clazz.getDeclaredConstructor().newInstance();

			// Set fields using map
			for (Map.Entry<String, Object> entry : properties.entrySet()) {
				try {
					Field field = clazz.getDeclaredField(entry.getKey());
					field.setAccessible(true);
					field.set(obj, entry.getValue());
				} catch (NoSuchFieldException e) {
					// Ignore unknown fields
				}
			}
			return obj;

		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	//  Sample class
	static class Student {
		private int id;
		private String name;
		private int age;

		public Student() {
		}

		void display() {
			System.out.println("ID: " + id + ", Name: " + name + ", Age: " + age);
		}
	}

	public static void main(String[] args) {

		Map<String, Object> data = new HashMap<>();
		data.put("id", 101);
		data.put("name", "Anuj");
		data.put("age", 22);

		Student student = toObject(Student.class, data);
		student.display();
	}
}
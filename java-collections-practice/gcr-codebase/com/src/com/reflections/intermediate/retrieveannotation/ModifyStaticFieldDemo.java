package com.reflections.intermediate.retrieveannotation;

public class ModifyStaticFieldDemo {

	// Inner Configuration class
	static class Configuration {
		private static String API_KEY = "OLD_KEY";
	}

	public static void main(String[] args) {

		try {
			// Get Class object
			Class<?> cls = Configuration.class;

			// Access private static field
			Field field = cls.getDeclaredField("API_KEY");
			field.setAccessible(true);

			// Get original value (null for static fields)
			System.out.println("Original API_KEY: " + field.get(null));

			// Modify static field value
			field.set(null, "NEW_API_KEY_123");

			// Get updated value
			System.out.println("Updated API_KEY: " + field.get(null));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
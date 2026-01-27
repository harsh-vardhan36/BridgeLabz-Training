package com.reflections.intermediate;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import java.lang.annotation.Annotation;

public class RetrieveAnnotationDemo {

	// 🔹 Custom Annotation
	@Retention(RetentionPolicy.RUNTIME)
	@Target(ElementType.TYPE)
	@interface Author {
		String name();
	}

	// 🔹 Apply Annotation to Class
	@Author(name = "Author Name")
	static class Book {
	}

	public static void main(String[] args) {

		// Get Class object
		Class<Book> cls = Book.class;

		// Check and retrieve annotation
		if (cls.isAnnotationPresent(Author.class)) {
			Author author = cls.getAnnotation(Author.class);
			System.out.println("Author Name: " + author.name());
		} else {
			System.out.println("Author annotation not found");
		}
	}
}
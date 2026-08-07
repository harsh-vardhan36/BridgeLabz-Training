package com.library_management_javaBased;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.library_management_javaBased.config.JavaConfig;
import com.library_management_javaBased.service.LibraryService;

public class App {
	public static void main(String[] args) {

		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(JavaConfig.class);

		LibraryService libraryService = context.getBean(LibraryService.class);
		libraryService.displayBook();

		context.close();
	}
}

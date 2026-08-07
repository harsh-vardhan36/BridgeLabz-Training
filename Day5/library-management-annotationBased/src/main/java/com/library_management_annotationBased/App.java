package com.library_management_annotationBased;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.library_management_annotationBased.config.AppConfig;
import com.library_management_annotationBased.service.LibraryService;


public class App {
	public static void main(String[] args) {

		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(AppConfig.class);

		LibraryService libraryService = context.getBean(LibraryService.class);
		libraryService.displayBook();

		context.close();
	}
}

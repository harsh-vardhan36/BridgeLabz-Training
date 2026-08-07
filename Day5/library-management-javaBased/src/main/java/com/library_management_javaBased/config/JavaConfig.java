package com.library_management_javaBased.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.library_management_javaBased.model.Author;
import com.library_management_javaBased.model.Book;
import com.library_management_javaBased.model.Publisher;
import com.library_management_javaBased.service.LibraryService;

/**
 * Pure Java-based configuration.
 * Unlike the annotation-based version, there is NO @ComponentScan here.
 * Every bean is declared explicitly with a @Bean method, and dependencies
 * are wired by simply calling the other @Bean methods - full control,
 * no scanning, no magic.
 */
@Configuration
public class JavaConfig {

	@Bean
	public Author author() {
		return new Author("R.K. Narayan");
	}

	@Bean
	public Publisher publisher() {
		return new Publisher("Penguin India");
	}

	@Bean
	public Book book() {
		return new Book("Malgudi Days", 299.0, author(), publisher());
	}

	@Bean
	public LibraryService libraryService() {
		return new LibraryService(book());
	}
}

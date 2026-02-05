package com.librarymanagement;
import com.librarymanagement.builder.Book;
import com.librarymanagement.factory.User;
import com.librarymanagement.factory.UserFactory;
import com.librarymanagement.singelton.LibraryCatalog;

public class LibraryApp {

	public static void main(String[] args) {

		// SINGLETON
		LibraryCatalog catalog = LibraryCatalog.getInstance();

		// FACTORY
		User student = UserFactory.createUser("student", "Harsh");
		User faculty = UserFactory.createUser("faculty", "Er. Ram ");

		// SHOW ROLES
		student.showRole();
		faculty.showRole();

		// OBSERVER REGISTRATION
		catalog.addObserver(student);
		catalog.addObserver(faculty);

		// BUILDER
		Book book = new Book.BookBuilder("Design Patterns").author("GoF").edition("2nd Edition")
				.genre("Software Engineering").build();

		// ADD BOOK → NOTIFY USERS
		catalog.addBook(book);
	} 
}
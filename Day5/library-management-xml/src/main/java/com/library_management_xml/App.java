package com.library_management_xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.library_management_xml.model.Author;
import com.library_management_xml.model.Book;
import com.library_management_xml.model.LibraryService;
import com.library_management_xml.model.Publisher;

public class App {

    public static void main(String[] args) {

    	ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
    	
    	
    	LibraryService library = context.getBean("library",LibraryService.class);
    	library.displayBook();
    }
}
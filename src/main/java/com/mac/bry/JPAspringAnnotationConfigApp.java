package com.mac.bry;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.mac.bry.dao.BookDAO;
import com.mac.bry.model.Book;

@Configuration
@ComponentScan
public class JPAspringAnnotationConfigApp {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(JPAspringAnnotationConfigApp.class);
		BookDAO bookDAO = context.getBean(BookDAO.class);
		Book book = new Book("1", "TOLKIEN", "Hobbit");
		bookDAO.addBook(book);
		Book getBook = bookDAO.getBook(1L);
		
		System.out.println(getBook);
		context.close();
	}

}

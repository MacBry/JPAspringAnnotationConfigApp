package com.mac.bry.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;

import org.springframework.stereotype.Repository;

import com.mac.bry.model.Book;

@Repository
public class BookDAOimpl implements BookDAO{
	
	@PersistenceUnit
	private EntityManagerFactory entityManagerFactory;

	public BookDAOimpl() {
		super();
	}
	@Override
	public void addBook(Book book) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.persist(book);
		transaction.commit();
		entityManager.close();
	}
	
	@Override
	public Book getBook(Long id) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		Book book = entityManager.find(Book.class, id);
		entityManager.close();
		return book;
	}

	 
}

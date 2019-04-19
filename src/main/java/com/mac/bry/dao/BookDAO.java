package com.mac.bry.dao;

import com.mac.bry.model.Book;

public interface BookDAO {
	void addBook(Book book);
	Book getBook(Long id);
}

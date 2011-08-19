package com.soat.dao;

import java.util.List;

import com.soat.beans.Book;


public interface BookDao {
	
	public List<Book> getAllBooks();
	public List<Book> getBooksByCategory(String categoryId);
	public Book getBookById(String id);
	public List<Book> getBooksByKeyWord(String id);

}

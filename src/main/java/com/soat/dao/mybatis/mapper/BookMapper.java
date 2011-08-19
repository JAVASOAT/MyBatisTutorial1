package com.soat.dao.mybatis.mapper;

import java.util.List;

import com.soat.beans.Book;

public interface BookMapper {

	public Book selectBookById(Integer id);
	
	public List<Book> selectAllBooks();
	
	public List<Book> selectBookByCategory(Integer id_category);
	
	public List<Book> selectBookByKeyWord(String word);
	
	public void insertBook(Book book);
	
	public void updateBook(Book book);
	
	public void deleteBook(Book book);
	
}
package com.soat.dao;

import com.soat.dao.mybatis.BookDaoMybatis;


public class BookDaoFactory {

	private static final BookDao dao = new BookDaoMybatis();
	
	private BookDaoFactory(){};
	
	public static BookDao getInstance(){
		return dao;
	}
	
}

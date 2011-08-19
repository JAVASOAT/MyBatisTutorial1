package com.soat.dao.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.soat.beans.Book;
import com.soat.dao.BookDao;
import com.soat.dao.mybatis.mapper.BookMapper;
import com.soat.dao.mybatis.util.MybatisUtil;

public class BookDaoMybatis implements BookDao{

	protected SqlSession session;
	
	private BookMapper mapper;
	
	protected void startOperation() {
		session = MybatisUtil.getSession();
		mapper = session.getMapper(BookMapper.class);
	}
	
	@Override
	public List<Book> getAllBooks() {
		try{
			startOperation();
			return mapper.selectAllBooks();
		}finally{
			session.close();
		}
	}

	@Override
	public Book getBookById(String id) {
		try{
			startOperation();
			Integer intId = Integer.valueOf(id);
			return mapper.selectBookById(intId);
		}finally{
			session.close();
		}
	}

	@Override
	public List<Book> getBooksByCategory(String categoryId) {
		try{
			startOperation();
			Integer id = Integer.valueOf(categoryId);
			return mapper.selectBookByCategory(id);
		}finally{
			session.close();
		}
	}

	@Override
	public List<Book> getBooksByKeyWord(String word){
		try{
			startOperation();
			return mapper.selectBookByKeyWord(word);
		}finally{
			session.close();
		}
	}

}

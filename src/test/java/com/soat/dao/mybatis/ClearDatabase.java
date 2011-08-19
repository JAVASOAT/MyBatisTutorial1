package com.soat.dao.mybatis;

import org.apache.ibatis.session.SqlSession;

import com.soat.dao.mybatis.util.MybatisUtil;


public class ClearDatabase {

	public static void main(String[] args)throws Exception {
		
		SqlSession session = MybatisUtil.getSession();
		
		session.delete("deleteBookCategories", null);
		session.delete("deleteCategory", null);
		session.delete("deleteBook", null);
		session.delete("deleteAuthor", null);
		session.commit();
		session.close();
		
	}
	
}

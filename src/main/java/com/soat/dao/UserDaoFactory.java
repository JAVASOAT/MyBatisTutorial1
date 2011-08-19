package com.soat.dao;

import com.soat.dao.mybatis.UserDaoMybatis;


public class UserDaoFactory {

	private static final UserDao dao = new UserDaoMybatis();
	
	private UserDaoFactory(){};
	
	public static UserDao getInstance(){
		return dao;
	}
	
}

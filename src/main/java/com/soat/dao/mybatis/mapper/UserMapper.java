package com.soat.dao.mybatis.mapper;

import java.util.List;

import com.soat.beans.User;

public interface UserMapper {

	public User selectUser(Integer id);
	
	public List<User> selectAllUsers();
	
	public void insertUser(User user);
	
}

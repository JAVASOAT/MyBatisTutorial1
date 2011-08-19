package com.soat.dao;

import com.soat.beans.User;

public interface UserDao {
	
	public User getUserById(String mail);
	
	public void insertUser(String mail, String nom, String prenom, String password);

}

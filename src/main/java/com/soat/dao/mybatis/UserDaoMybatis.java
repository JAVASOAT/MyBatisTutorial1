package com.soat.dao.mybatis;

import org.apache.ibatis.session.SqlSession;

import com.soat.beans.User;
import com.soat.dao.UserDao;
import com.soat.dao.mybatis.mapper.UserMapper;
import com.soat.dao.mybatis.util.MybatisUtil;

public class UserDaoMybatis implements UserDao {

	protected SqlSession session;
	
	private UserMapper mapper;
	
	protected void startOperation() {
		session = MybatisUtil.getSession();
		mapper = session.getMapper(UserMapper.class);
	}
	
	
	@Override
	public User getUserById(String mail) {
		try{
			startOperation();
			Integer id =1;
			return mapper.selectUser(id);
		}finally{
			session.close();
		}
	}

	@Override
	public void insertUser(String mail, String nom, String prenom,String password) {
		try{
			startOperation();
			mapper.insertUser(null);
			session.commit();
		}finally{
			session.close();
		}

	}

}

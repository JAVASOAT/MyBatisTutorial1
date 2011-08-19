package com.soat.dao.mybatis.util;

import java.io.IOException;
import java.io.Reader;

import org.apache.commons.io.IOUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;

public class MybatisUtil {

	private static final Logger logger = Logger.getLogger(MybatisUtil.class);
	private static final String resource = "mybatis-config.xml";
	private static SqlSessionFactory sqlSessionFactory;
	
	static{
		Reader reader=null;
		try{						
			reader = Resources.getResourceAsReader(resource);			
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		} catch (IOException e) {
			logger.error(e);
		}finally{
			IOUtils.closeQuietly(reader);
		}
	}
	
	public static SqlSession getSession() {
		return sqlSessionFactory.openSession();			
	}
	
	public static SqlSession getBatchSession() {
		return sqlSessionFactory.openSession(ExecutorType.BATCH);			
	}
}
package com.db.conn;

import java.io.*;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisConnect {
	
	private SqlSession sess;
	
	public MybatisConnect() {
		this.connect();
	}
	
	private void connect() {
		//마이바티스 구성을 사용하여 열결객체(SqlSession)을 만들기위한 코드 작성
		String resource = "resources/mybatis-config.xml";
		InputStream inputStream;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			this.sess = sqlSessionFactory.openSession(false);
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public SqlSession getSession() {
		if(this.sess == null) {
			this.connect();
		}
		return this.sess;
	}
	
	public void commit() {
		this.sess.commit();
	}
	public void rollback() {
		this.sess.rollback();
	}
	public void close() {
		this.sess.close();
	}

}

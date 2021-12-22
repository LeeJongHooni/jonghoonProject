package com.menu.model;

import java.sql.*;
import java.util.*;

import org.apache.ibatis.session.SqlSession;

import com.db.conn.MybatisConnect;

public class MenuDAO {
	private MybatisConnect mc;
	private SqlSession sess;
	
	public MenuDAO() {
		this.mc = new MybatisConnect();
		this.sess=this.mc.getSession();
	}
	
	public List<MenuDTO> select(){
		List<MenuDTO> data = this.sess.selectList("MainMapper.selectMenus");
		return data;
	}
	public void commit() {
		this.mc.commit();
	}
	public void rollback() {
		this.mc.rollback();
	}
	public void close() {
		this.mc.close();
	}
}

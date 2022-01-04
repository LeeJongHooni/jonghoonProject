package com.sign.model;

import java.sql.*;
import java.util.*;

import org.apache.ibatis.session.SqlSession;

import com.db.conn.MybatisConnect;
import com.sign.model.*;

public class SignDAO {
	
	private MybatisConnect mc;
	private SqlSession sess;
	String query;
	
	public SignDAO() {
		this.mc = new MybatisConnect();
		this.sess = this.mc.getSession();
	}
	
	public boolean insert(SignDTO dto) {
		int res = this.sess.insert("AccountMapper.insertSign",dto);
		
		if(res == 1) {
			return true;
		}else {
			return false;
		}
	}
	public SignDTO selectLogin(SignDTO dto) {
		SignDTO data = this.sess.selectOne("AccountMapper.selectLogin",dto);
		return data;
	}
	public List<SignDTO> selectSign(String userid) {
		List<SignDTO> data = this.sess.selectList("AccountMapper.selectSign",userid);
		return data;
	}
	public SignDTO select_pkid(String userid) {
		
		SignDTO data = this.sess.selectOne("AccountMapper.selectPkid",userid);
		
		return data;
	}
	public List<SignDTO> select_userid(int id) {
		List<SignDTO> data = this.sess.selectList("AccountMapper.selectUserid",id);

		return data;
	}
	public boolean updateProfile(SignDTO dto) {
		int res = this.sess.update("AccountMapper.updateProfile", dto);
		System.out.println("updateProfile dao : " + res);
		if(res == 1) {
			return true;
		}else {
			return false;
		}
	}
	public boolean deleteAccount(int id) {
		int res = this.sess.delete("AccountMapper.deleteAccount",id);
		if(res == 1) {
			return true;
		}else {
			return false;
		}
	}
	public void commit() {
		mc.commit();
	}
	public void rollback() {
		mc.rollback();
	}
	public void close() {
		mc.close();
	}

}

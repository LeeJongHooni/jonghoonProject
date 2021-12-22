package com.sign.model;

import java.sql.*;
import java.util.*;

import org.apache.ibatis.session.SqlSession;

import com.db.conn.MybatisConnect;
import com.db.conn.OracleConnect;
import com.sign.model.*;

public class SignDAO {
	
	private OracleConnect oc;
	private MybatisConnect mc;
	private SqlSession sess;
	String query;
	
	public SignDAO() {
		this.oc = new OracleConnect();
		this.mc = new MybatisConnect();
		this.sess = this.mc.getSession();
	}
	
	public boolean insert(SignDTO dto) {
		this.query = "INSERT INTO SIGN VALUES(SIGN_SEQ.NEXTVAL,'"
				+ dto.getUserid() + "', '"
				+ dto.getPassword() + "','"
				+ dto.getEmail() + "','"
				+ dto.getName() + "','"
				+ dto.getBirthday() + "',sysdate +9/24)";
		int res = oc.insert(query);
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
	public int select_pkid(String userid) {
		this.query = "SELECT id FROM SIGN WHERE USERID = '" + userid + "'";
		
		ResultSet rs = oc.select(query);
		int res = 0;
		try {
			if(rs.next()) {
				SignDTO dto = new SignDTO();
				dto.setPkid(rs.getInt("id"));
				res = dto.getId();
				
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}
	public String select_userid(String pkid) {
		this.query = "SELECT userid FROM SIGN WHERE ID = '" + pkid + "'";
		
		ResultSet rs = oc.select(query);
		String id = "";
		try {
			if(rs.next()) {
				SignDTO dto = new SignDTO();
				dto.setUserid(rs.getString("userid"));
				id = dto.getUserid();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return id;
	}
	public void commit() {
		oc.commit();
		mc.commit();
	}
	public void rollback() {
		oc.rollback();
		mc.rollback();
	}
	public void close() {
		oc.close();
		mc.close();
	}

}

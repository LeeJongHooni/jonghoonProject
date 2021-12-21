package com.sign.model;

import java.sql.*;
import java.util.*;

import com.db.conn.OracleConnect;
import com.sign.model.*;

public class SignDAO {
	
	OracleConnect oc = null;
	String query;
	
	public SignDAO() {
		this.oc = new OracleConnect();
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
	public List<SignDTO> select(String userid) {
		this.query = "SELECT * FROM SIGN WHERE USERID = '" + userid + "'";
		
		ResultSet rs = oc.select(query);
		List<SignDTO> data = new ArrayList<SignDTO>();
		try {
			if(rs.next()) {
				SignDTO dto = new SignDTO();
				dto.setPkid(rs.getInt("id"));
				dto.setUserid(rs.getString("userid"));
				dto.setPassword(rs.getString("password"));
				dto.setEmail(rs.getString("email"));
				dto.setName(rs.getString("username"));
				dto.setBirthday(rs.getDate("birthday"));
				data.add(dto);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
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
				res = dto.getPkid();
				
				
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
	}
	public void rollback() {
		oc.rollback();
	}
	public void close() {
		oc.close();
	}

}

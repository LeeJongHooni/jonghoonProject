package com.sign.model;

import java.util.*;

public class SignService {

	public boolean insert(SignDTO dto) {
		SignDAO dao = new SignDAO();
		boolean res = dao.insert(dto);
		if(res) {
			dao.commit();
		}else {
			dao.rollback();
		}
		dao.close();
		return res;
	}
	public boolean isValid(String userid) {
		SignDAO dao = new SignDAO();
		List<SignDTO> data = dao.selectSign(userid);
		dao.close();	
		if(data.size() == 0) {
			System.out.println("true");
			return true;
		}else {
			System.out.println("false");
			return false;
		}
		
	}
	public int select_pkid(String userid){
		SignDAO dao = new SignDAO();
		int data = dao.select_pkid(userid);
		if(data != 0) {
			dao.close();
			return data;
		}else {
			dao.close();
			return data;
		}
	}
	public String select_userid(String pkid){
		SignDAO dao = new SignDAO();
		String data = dao.select_userid(pkid);
		if(data != null) {
			dao.close();
			return data;
		}else {
			dao.close();
			return data;
		}
	}
	
	public boolean login(SignDTO dto) {
		SignDAO dao = new SignDAO();
		SignDTO data = dao.selectLogin(dto);
		dao.close();
		if(data != null) {
			dto.setPkid(data.getId());
			dto.setUserid(data.getUserid());
			dto.setPassword("");
			dto.setEmail(data.getEmail());
			dto.setName(data.getName());
			dto.setBirthday(data.getBirthday());
			return true;
		}else {
			return false;
		}
	}
}

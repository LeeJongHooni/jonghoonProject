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
	public SignDTO select_pkid(String userid){
		SignDAO dao = new SignDAO();
		SignDTO data = dao.select_pkid(userid);
		if(data.getId() != 0) {
			dao.close();
			return data;
		}else {
			dao.close();
			return data;
		}
	}
	public List<SignDTO> select_userid(int pkid){
		SignDAO dao = new SignDAO();
		List<SignDTO> data = dao.select_userid(pkid);
		if(data.size() != 0) {
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
			dto.setId(data.getId());
			dto.setUserid(data.getUserid());
			dto.setPassword("");
			dto.setEmail(data.getEmail());
			dto.setUserName(data.getUserName());
			dto.setBirthday(data.getBirthday());
			dto.setSignDate(data.getSignDate());
			return true;
		}else {
			return false;
		}
	}
}

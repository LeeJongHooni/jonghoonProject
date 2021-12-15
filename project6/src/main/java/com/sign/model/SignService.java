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
		int res = dao.select(userid).size();
		if(res == 0) {
			dao.close();
			return true;
		}else {
			dao.close();
			return false;
		}
	}
	public boolean login(SignDTO dto) {
		SignDAO dao = new SignDAO();
		List<SignDTO> data = dao.select(dto.getUserid());
		if(data.size() == 1) {
			dao.close();
			return true;
		}else {
			dao.close();
			return false;
		}
	}
}

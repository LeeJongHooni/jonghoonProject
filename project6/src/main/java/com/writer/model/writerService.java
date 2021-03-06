package com.writer.model;

import java.util.*;

public class writerService {
	
	public boolean insert(writerDTO dto) {
		writerDAO dao = new writerDAO();
		boolean res = dao.insert(dto);
		if(res) {
			dao.commit();
			dao.close();
			return true;
		}else {
			dao.rollback();
			dao.close();
			return false;
		}
	}
	public List<writerDTO> select_detail(int wnum){
		writerDAO dao = new writerDAO();
		List<writerDTO> datas = dao.select_detail(wnum);
		
		if(datas.size() != 0) {
			dao.close();
			return datas;
		}else {
			dao.close();
			return datas;
		}
	}
	public List<writerDTO> selectAll(){
		writerDAO dao = new writerDAO();
		List<writerDTO> datas = dao.selectAll();
		
		if(datas.size() != 0) {
			dao.close();
			return datas;
		}else {
			dao.close();
			return datas;
		}
	}
	
	public int select_signId(String userId) {
		writerDAO dao = new writerDAO();
		int signId = dao.select_signId(userId);
		
		if(signId != 0) {
			dao.close();
			return signId;			
		}else {
			dao.close();
			return 0;
		}
	}
	public int select_viewCnt(int wnum) {
		writerDAO dao = new writerDAO();
		int viewCnt = dao.select_viewCnt(wnum);
		
		if(viewCnt != 0) {
			dao.close();
			return viewCnt;			
		}else {
			dao.close();
			return 0;
		}
	}
	public boolean viewCnt_update(int wnum) {
		writerDAO dao = new writerDAO();
		boolean res = dao.viewCnt_update(wnum);
		if(res) {
			dao.commit();
			dao.close();
		}else {
			dao.rollback();
			dao.close();
		}
		return res;
	}
	public boolean update(writerDTO dto) {
		writerDAO dao = new writerDAO();
		boolean res = dao.update(dto);
		if(res) {
			dao.commit();
		}else {
			dao.rollback();
		}
		dao.close();
		return res;
	}
	public boolean delete(int wnum) {
		writerDAO dao = new writerDAO();
		
		boolean res = dao.delete(wnum);
		if(res) {
			dao.commit();
		}else {
			dao.rollback();
		}
		dao.close();
		return res;
	}
	public boolean deleteAccount(int signId) {
		writerDAO dao = new writerDAO();
		
		boolean res = dao.deleteAccount(signId);
		System.out.println("writerService delete res = " + res);
		if(res) {
			dao.commit();
		}else {
			dao.rollback();
		}
		dao.close();
		return res;
	}
	public List<writerDTO> photoComment(){
		writerDAO dao = new writerDAO();
		List<writerDTO> datas = dao.photoComment();
		dao.close();
		if(datas.size() != 0) {
			return datas;
		}else {
			return datas;
		}
	}
}

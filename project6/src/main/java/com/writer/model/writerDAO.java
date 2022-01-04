package com.writer.model;

import java.sql.*;
import java.util.*;

import org.apache.ibatis.session.SqlSession;

import com.db.conn.MybatisConnect;
import com.db.conn.OracleConnect;
import com.sign.model.SignDTO;

public class writerDAO {
	private MybatisConnect mc;
	private SqlSession sess;
	
	public writerDAO() {
		this.mc = new MybatisConnect();
		this.sess = this.mc.getSession();
	}
	
	public boolean insert(writerDTO dto) {
		int res = this.sess.insert("WriterMapper.insertWriter",dto);
		if(res == 1) {
			return true;
		}else {
			return false;
		}
	}
	public List<writerDTO> select_detail(int wnum){
		
		List<writerDTO> datas = this.sess.selectList("WriterMapper.selectDetail",wnum);
		
		return datas;
	}
	public List<writerDTO> selectAll(){
		
		List<writerDTO> datas = this.sess.selectList("WriterMapper.selectAll");
		
		return datas;
	}
	
	public int select_signId(String userId) {
		
		
		SignDTO signId = this.sess.selectOne("WriterMapper.selectSignId",userId);
		
		return signId.getId();
	}
	public int select_viewCnt(int wnum) {
	
		int viewCnt = this.sess.selectOne("WriterMapper.selectViewCnt",wnum);
		
		return viewCnt;
	}
	public boolean viewCnt_update(int wnum) {
		writerDTO dto = new writerDTO();
		
		dto = this.sess.selectOne("WriterMapper.selectViewCnt",wnum);
		dto.setViewCnt(dto.getViewCnt() + 1);
		dto.setwNum(wnum);
		int res = this.sess.update("WriterMapper.updateViewCnt",dto);
		if(res == 1) {
			return true;
		}else {
			return false;
		}
		
	}
	public boolean update(writerDTO dto) {
		
		int res = this.sess.update("WriterMapper.updateWriter",dto);
		
		if(res == 1) {
			return true;
		}else {
			return false;
		}
	}
	public boolean delete(int wnum) {
		
		int res = this.sess.delete("WriterMapper.deleteWriter",wnum);
		
		if(res > 0) {
			return true;
		}else {
			return false;
		}
	}
	public boolean deleteAccount(int signId) {
		
		int res = this.sess.delete("WriterMapper.deleteAccount",signId);
		System.out.println("writerDAO delete res = " + res);
		if(res != 0) {
			return true;
		}else {
			return false;
		}
	}
	public List<writerDTO> photoComment(){
		List<writerDTO> datas = this.sess.selectList("WriterMapper.SelectPhoto");
		return datas;
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

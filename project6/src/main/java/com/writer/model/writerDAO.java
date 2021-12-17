package com.writer.model;

import java.sql.*;
import java.util.*;

import com.db.conn.OracleConnect;

public class writerDAO {
	
	OracleConnect oc = null;
	String query;
	
	public writerDAO() {
		this.oc = new OracleConnect();
	}
	
	public boolean insert(writerDTO dto) {
		this.query = "INSERT INTO WRITER VALUES(writer_seq.NEXTVAL,"
				+ "'" + dto.getSignId() +"', "
				+ "'" + dto.getwTitle() +"', "
				+ "'" + dto.getwContent() +"', "
				+ "'" + dto.getDownloadpath() + "', "
				+ " sysdate + 9/24 , "
				+ "0 )";
		int res = oc.insert(query);
		if(res == 1) {
			return true;
		}else {
			return false;
		}
	}
	public List<writerDTO> select_detail(String wnum){
		this.query = "SELECT * FROM WRITER WHERE wnum = "+ wnum;
		
		ResultSet rs = oc.select(query);
		List<writerDTO> datas = new ArrayList<writerDTO>();
		
		try {
			while(rs.next()) {
				writerDTO dto = new writerDTO();
				dto.setwNum(rs.getInt("wnum"));
				dto.setSignId(rs.getInt("signid"));
				dto.setwTitle(rs.getString("wtitle"));
				dto.setwContent(rs.getString("wcontent"));
				dto.setDownloadpath(rs.getString("downloadpath"));
				dto.setwDate(rs.getDate("wdate"));
				dto.setViewCnt(rs.getInt("viewcnt"));
				datas.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return datas;
	}
	public List<writerDTO> selectAll(){
		this.query = "SELECT * FROM WRITER ORDER BY wnum";
		
		ResultSet rs = oc.select(query);
		List<writerDTO> datas = new ArrayList<writerDTO>();
		
		try {
			while(rs.next()) {
				writerDTO dto = new writerDTO();
				dto.setwNum(rs.getInt("wnum"));
				dto.setSignId(rs.getInt("signid"));
				dto.setwTitle(rs.getString("wtitle"));
				dto.setwContent(rs.getString("wcontent"));
				dto.setDownloadpath(rs.getString("downloadpath"));
				dto.setwDate(rs.getDate("wdate"));
				dto.setViewCnt(rs.getInt("viewcnt"));
				datas.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return datas;
	}
	
	public int select_signId(String userId) {
		this.query = "SELECT id FROM SIGN WHERE userid = '" + userId+"'";
		
		ResultSet rs = oc.select(query);
		int signId = 0;
		try {
			if(rs.next()) {
				writerDTO dto = new writerDTO();
				dto.setSignId(rs.getInt("id"));
				signId = dto.getSignId();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return signId;
	}
	public int select_viewCnt(String wnum) {
		this.query = "SELECT viewcnt FROM WRITER WHERE wnum = '" + wnum + "'";
		
		ResultSet rs = oc.select(query);
		int viewCnt = 0;
		try {
			if(rs.next()) {
				writerDTO dto = new writerDTO();
				dto.setViewCnt(rs.getInt("viewcnt"));
				viewCnt = dto.getViewCnt();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return viewCnt;
	}
	public boolean viewCnt_update(String wnum) {
		writerDTO dto = new writerDTO();
		writerService service = new writerService();
		int cnt = service.select_viewCnt(wnum);
		this.query = "UPDATE WRITER SET viewcnt = " +( cnt + 1 )+ "WHERE wnum = '" + wnum + "'";
		
		int res = oc.update(this.query);
		if(res == 1) {
			return true;
		}else {
			return false;
		}
		
	}
	public boolean update(writerDTO dto) {
		
		this.query = "UPDATE WRITER SET wtitle = '" +dto.getwTitle()+
					"',wContent = '" + dto.getwContent() +
					"', downloadpath = '"+dto.getDownloadpath() +
					"' WHERE wnum = '" + dto.getwNum() + "'";
		
		int res = oc.update(query);
		
		if(res == 1) {
			return true;
		}else {
			return false;
		}
	}
	public boolean delete(String wnum) {
		this.query = "DELETE FROM WRITER WHERE wnum = " + wnum;
		
		int res = oc.delete(this.query);
		
		if(res == 1) {
			return true;
		}else {
			return false;
		}
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

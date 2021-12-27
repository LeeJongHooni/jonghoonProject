package com.comment.model;

import java.sql.*;
import java.util.*;

import com.db.conn.OracleConnect;
import com.sign.model.*;

public class CommentDAO {
	
	OracleConnect oc;
	String query;
	
	public CommentDAO() {
		this.oc = new OracleConnect();
	}
	
	public boolean commentInsert(CommentDTO dto) {
		this.query = "INSERT INTO USERCOMMENT"
					+ " VALUES('"+ dto.getComment_id()+"', '"
					+ dto.getUserpkid() + "', '"
					+ dto.getUsercomment() + "', "
					+ "SYSDATE + 9/24 , 0, 0)";
		
		int res = oc.insert(this.query);
		if(res == 1) {
			return true;
		}else {
			return false;
		}
	}
	
	public List<CommentDTO> commentSelect(){
		this.query = "SELECT comment_id,SIGN.userid,usercomment,commentdate,good_count,hate_count FROM  usercomment JOIN SIGN"
				+ " ON usercomment.userpkid = SIGN.id ORDER BY 1";
		
		List<CommentDTO> datas = new ArrayList<CommentDTO>();
		
		ResultSet rs = oc.select(this.query);
		try {
			while(rs.next()) {
				CommentDTO dto = new CommentDTO();
				dto.setComment_id(rs.getInt("comment_id"));
				dto.setUserid(rs.getString("userid"));
				dto.setUsercomment(rs.getString("usercomment"));
				dto.setCommentdate(rs.getDate("commentdate"));
				dto.setGood_count(rs.getInt("good_count"));
				dto.setHate_count(rs.getInt("hate_count"));
				datas.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return datas;
	}
	public List<SignDTO> commentUserid(){
		this.query = "SELECT SIGN.userid FROM usercomment JOIN SIGN"
				+ " ON usercomment.userpkid = SIGN.id";
		
		List<SignDTO> datas = new ArrayList<SignDTO>();
		
		ResultSet rs = oc.select(this.query);
		try {
			while(rs.next()) {
				SignDTO dto = new SignDTO();
				SignService svc = new SignService();
				dto.setUserid(rs.getString("userid"));
				datas.add(dto);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return datas;
	}
	public void close() {
		this.oc.close();
	}
	public void commit() {
		this.oc.commit();
	}
	public void rollback() {
		this.oc.rollback();
	}
}

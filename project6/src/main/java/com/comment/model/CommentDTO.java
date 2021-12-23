package com.comment.model;

import java.sql.*;

public class CommentDTO {
	private int comment_id;
	private int userpkid;
	private String usercomment;
	private Date commentdate;
	private int good_count;
	private int hate_count;
	private String Userid;
	
	
	
	
	public String getUserid() {
		return Userid;
	}
	public void setUserid(String userid) {
		Userid = userid;
	}
	public int getComment_id() {
		return comment_id;
	}
	public void setComment_id(int comment_id) {
		this.comment_id = comment_id;
	}
	public int getUserpkid() {
		return userpkid;
	}
	public void setUserpkid(int userpkid) {
		this.userpkid = userpkid;
	}
	public String getUsercomment() {
		return usercomment;
	}
	public void setUsercomment(String usercomment) {
		this.usercomment = usercomment;
	}
	public Date getCommentdate() {
		return commentdate;
	}
	public void setCommentdate(Date commentdate) {
		this.commentdate = commentdate;
	}
	public int getGood_count() {
		return good_count;
	}
	public void setGood_count(int good_count) {
		this.good_count = good_count;
	}
	public int getHate_count() {
		return hate_count;
	}
	public void setHate_count(int hate_count) {
		this.hate_count = hate_count;
	}
	
	
}

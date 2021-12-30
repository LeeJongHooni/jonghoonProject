package com.sign.model;

import java.sql.*;

public class SignDTO {
	private int id;
	private String userid;
	private String password;
	private String email;
	private String username;
	private Date birthday;
	private Date signDate;
	private String profilephotopath;
	
	public SignDTO() {}
	
	public SignDTO(int id, String username, String email, Date birthday, String profilephotopath) {
		this.id = id;
		this.username = username;
		this.email = email;
		this.birthday = birthday;
		this.profilephotopath = profilephotopath;
	}
	
	
	public String getProfilephotopath() {
		return profilephotopath;
	}


	public void setProfilephotopath(String profilephotopath) {
		this.profilephotopath = profilephotopath;
	}


	public Date getSignDate() {
		return signDate;
	}
	public void setSignDate(Date signDate) {
		this.signDate = signDate;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUserName() {
		return username;
	}
	public void setUserName(String name) {
		this.username = name;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	
	

}

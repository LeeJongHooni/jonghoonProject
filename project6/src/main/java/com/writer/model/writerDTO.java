package com.writer.model;

import java.sql.*;

public class writerDTO {
	private int wNum;
	private int signId;
	private String wTitle;
	private String wContent;
	private Date wDate;
	private int viewCnt;
	
	
	public int getwNum() {
		return wNum;
	}
	public void setwNum(int wNum) {
		this.wNum = wNum;
	}
	public int getSignId() {
		return signId;
	}
	public void setSignId(int signId) {
		this.signId = signId;
	}
	public String getwTitle() {
		return wTitle;
	}
	public void setwTitle(String wTitle) {
		this.wTitle = wTitle;
	}
	public String getwContent() {
		return wContent;
	}
	public void setwContent(String wContent) {
		this.wContent = wContent;
	}
	public Date getwDate() {
		return wDate;
	}
	public void setwDate(Date wDate) {
		this.wDate = wDate;
	}
	public int getViewCnt() {
		return viewCnt;
	}
	public void setViewCnt(int viewCnt) {
		this.viewCnt = viewCnt;
	}
	
	
	
}

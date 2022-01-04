package com.db.conn;

import java.io.*;
import java.sql.*;
import java.util.*;
import oracle.jdbc.pool.OracleDataSource;
public class OracleConnect {
	private Properties info = new Properties();
	private Connection conn = null;
	private Statement stat = null;
	
	
	
	{
		String userHome = System.getProperty("user.home");
		try {
			this.info.load(new FileReader(userHome + "/oracle_connect.prop"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public OracleConnect() {
		this.walletConnect();
	}
	
	public void walletConnect() {
		OracleDataSource ods;
		try {
			ods = new OracleDataSource();
			ods.setURL(this.info.getProperty("cloud-url"));
			ods.setUser(this.info.getProperty("user1"));
			ods.setPassword(this.info.getProperty("password"));
			ods.setConnectionProperties(this.info);
			this.conn = ods.getConnection();
			this.conn.setAutoCommit(false);
			this.stat = this.conn.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	public ResultSet select(String query) {
		ResultSet rs = null;
		try {
			rs = this.stat.executeQuery(query);
			System.out.println("rs = " + rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	public int insert(String query) {
		int rs = 0;
		try {
			rs = this.stat.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	public int update(String query) {
		return insert(query);
	}
	
	public int delete(String query) {
		return insert(query);
	}
	
	public void commit() {
		try {
			this.conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void rollback() {
		try {
			this.conn.rollback();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void close() {
		try {
			this.stat.close();
			this.conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}

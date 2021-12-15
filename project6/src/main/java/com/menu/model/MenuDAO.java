package com.menu.model;

import java.sql.*;
import java.util.*;

import com.db.conn.OracleConnect;

public class MenuDAO {
	OracleConnect oc = null;
	String query;
	public MenuDAO() {
		oc = new OracleConnect();
	}
	
	public List<MenuDTO> select(){
		this.query = "SELECT * FROM NAV_MENUS ORDER BY ODR";
		
		ResultSet rs = oc.select(query);
		List<MenuDTO> data = new ArrayList<MenuDTO>();
		
		try {
			while(rs.next()) {
				MenuDTO dto = new MenuDTO();
				dto.setMenuId(rs.getInt("ID"));
				dto.setMenuName(rs.getString("NAME"));
				dto.setMenuURL(rs.getString("URL"));
				dto.setMenuODR(rs.getInt("ODR"));
				data.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return data;
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

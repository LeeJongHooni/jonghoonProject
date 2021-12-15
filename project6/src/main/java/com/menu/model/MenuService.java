package com.menu.model;

import java.util.*;

public class MenuService {
	
	public List<MenuDTO> select() {
		MenuDAO dao = new MenuDAO();
		List<MenuDTO> data = dao.select();
		
		if(data.size() == 1) {
			dao.close();
		}else {
			dao.close();
		}
		return data;
	}

}

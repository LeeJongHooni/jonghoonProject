package com.web.ajax;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import oracle.jdbc.proxy.annotation.Post;

/**
 * Servlet implementation class ajaxController
 */
@WebServlet("/ajax/sample")
public class ajaxController extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String Key = String.valueOf(request.getParameter("key"));
		int x = Integer.parseInt(request.getParameter("x"));
		int y = Integer.parseInt(request.getParameter("y"));
		
		//json 형태로 로직의 결과를 반환
		JSONObject json = new JSONObject();
		
		json.put("xy", x+y);
		json.put("msg", Key);
		response.getWriter().println(json.toJSONString());
		response.getWriter().flush();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String Key = String.valueOf(request.getParameter("key"));
		int x = Integer.parseInt(request.getParameter("x"));
		int y = Integer.parseInt(request.getParameter("y"));
		
		//json 형태로 로직의 결과를 반환
		JSONObject json = new JSONObject();
		
		json.put("xy", x+y);
		json.put("msg", Key);
		response.getWriter().println(json.toJSONString());
		response.getWriter().flush();
		
	}
}

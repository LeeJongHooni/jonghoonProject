package com.web.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.sign.model.SignDTO;
import com.sign.model.SignService;


@WebServlet("/sameid")
public class SameIdController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String view = "/WEB-INF/jsp/account/sameid.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(view);
		rd.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sameid = String.valueOf(request.getParameter("sameid"));
		
		SignDTO dto = new SignDTO();
		SignService service = new SignService();
		
		
		dto.setUserid(sameid);
		
		if(service.isValid(dto.getUserid())) {
			getServletContext().setAttribute("noSameId", true);
		}else {
			getServletContext().setAttribute("nosameId", false);
		}
		
		JSONObject json = new JSONObject();
		json.put("sameid", sameid);
		response.getWriter().println(json.toJSONString());
		response.getWriter().flush();
		
	}

}

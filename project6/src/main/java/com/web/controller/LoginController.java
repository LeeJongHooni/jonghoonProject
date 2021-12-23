package com.web.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sign.model.*;


@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String view = "/WEB-INF/jsp/account/login.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(view);
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userid = request.getParameter("userid");
		String password = request.getParameter("user-password");
		
		SignDTO dto = new SignDTO();
		SignService service = new SignService();
		HttpSession session = request.getSession();
		
		dto.setUserid(userid);
		dto.setPassword(password);
		
		SignDTO pkId = service.select_pkid(userid);
		if(service.login(dto)) {
			session.setAttribute("logined", true);
			session.setAttribute("account", dto);
			session.setAttribute("userPkId", pkId.getId());
			session.setAttribute("loginUserid", dto.getUserid());
			response.sendRedirect("/");
		}else {
			request.setAttribute("login-error", "로그인을 하지 않았습니다.");
			String view = "/WEB-INF/jsp/account/login.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(view);
			rd.forward(request, response);
		}
		
				
	}

}

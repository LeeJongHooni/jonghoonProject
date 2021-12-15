package com.web.controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sign.model.*;


@WebServlet("/sign")
public class SignController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String view = "/WEB-INF/jsp/account/sign.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(view);
		rd.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String userid = request.getParameter("userid");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String name = request.getParameter("name");
		String bd = request.getParameter("birthday");
		
		SignDTO dto = new SignDTO();
		SignService service = new SignService();
		
		dto.setUserid(userid);
		dto.setPassword(password);
		dto.setEmail(email);
		dto.setName(name);
		dto.setBirthday(Date.valueOf(bd));
		System.out.println(userid);
		System.out.println(password);
		System.out.println(email);
		System.out.println(name);
		System.out.println(bd);
		if(service.isValid(dto.getUserid())) {
			if(service.insert(dto)) {
				response.sendRedirect("/");
			}else {
				request.setAttribute("sign-error", "회원가입 실패!");
				String view = "/WEB-INF/jsp/account/sign.jsp";
				RequestDispatcher rd = request.getRequestDispatcher(view);
				rd.forward(request, response);
			}
		}else {
			System.out.println("오류");
		}
		
		
	}

}

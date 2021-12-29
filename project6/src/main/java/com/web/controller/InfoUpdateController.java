package com.web.controller;

import java.io.File;
import java.io.IOException;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.oreilly.servlet.multipart.FileRenamePolicy;
import com.sign.model.*;


@WebServlet("/infoupdate")
public class InfoUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String view = "/WEB-INF/jsp/info/infoupdate.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(view);
		rd.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		MultipartRequest multi = new MultipartRequest(
				request,
				request.getServletContext().getRealPath("/upload"),
				1024 * 1024 * 10,
				"utf-8",
				new DefaultFileRenamePolicy()
				);
		int id = (int)session.getAttribute("userPkId");
		String myPhoto = "/upload/" + multi.getFilesystemName("profile_upload");
		String userName = multi.getParameter("info_username");
		String userEmail = multi.getParameter("info_email");
		Date userBirthday = Date.valueOf(multi.getParameter("info_birthday"));
		
		SignDTO sdto = new SignDTO(id,userName,userEmail,userBirthday,myPhoto);
		SignService sService = new SignService();
		
		
		if(sService.updateProfile(sdto)) {
			System.out.println("----수정완료!!----");
			response.sendRedirect("/info");
		}else {
			System.out.println("----수정실패ㅜㅜ----");
			request.setAttribute("updateProfile_error", "개인정보 수정에 실패하셨습니다.");
			String view = "/WEB-INF/jsp/info/infoupdate.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(view);
			rd.forward(request, response);
		}
		
	}

}

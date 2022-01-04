package com.web.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.comment.model.CommentService;
import com.sign.model.*;
import com.writer.model.writerService;



@WebServlet("/accountdelete")
public class AccountDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String view = "/WEB-INF/jsp/info/accountdelete.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(view);
		rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String deleteCheck = request.getParameter("deleteCheck");
		
		SignService sService = new SignService();
		CommentService cService = new CommentService();
		writerService wService = new writerService();
		HttpSession session = request.getSession();
		
		SignDTO sDTO = (SignDTO)session.getAttribute("account");
		System.out.println("sDTO.getId() = " + sDTO.getId());
		if(deleteCheck.equals("on")) {
			if(cService.deleteComment(sDTO.getId())) {
				System.out.println("comment delete success!!");
			}else {
				System.out.println("comment delete fail!!");
			}
			if(wService.deleteAccount(sDTO.getId())) {
				System.out.println("writer delete success!!");
			}else {
				System.out.println("writer delete fail!!");
			}
			if(sService.deleteAccount(sDTO.getId())) {
				response.sendRedirect("/");
			}else {
				request.setAttribute("deleteAccount_error", "삭제에 실패 하였습니다.");
				String view = "/WEB-INF/jsp/info/accountdelete.jsp";
				RequestDispatcher rd = request.getRequestDispatcher(view);
				rd.forward(request, response);
			}
		}else {
			request.setAttribute("deleteCheck_error", "회원탈퇴 동의체크에 문제가 생겼습니다. 확인 해주세요.");
			String view = "/WEB-INF/jsp/info/accountdelete.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(view);
			rd.forward(request, response);
		}

	}

}

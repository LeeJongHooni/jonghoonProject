package com.web.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.comment.model.*;
import com.sign.model.SignDTO;
import com.sign.model.SignService;

@WebServlet("/comment")
public class CommentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String comment = request.getParameter("userComment");
		String userPkId = request.getParameter("userPkId");
		
		CommentDTO dto = new CommentDTO();
		CommentService service = new CommentService();
		
	
		dto.setUserpkid(Integer.parseInt(userPkId));
		dto.setUsercomment(comment);
		
		if(service.commentInsert(dto)){
			System.out.println("저장 성공 !!");
			response.sendRedirect("/detail?wnum="+request.getParameter("wnumPara"));	
		}else {
			System.out.println("저장 실패!!");
		}

	}
}

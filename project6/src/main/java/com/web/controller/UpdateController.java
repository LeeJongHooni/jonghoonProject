package com.web.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.writer.model.*;


@WebServlet("/update")
public class UpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String updateTitle = request.getParameter("title");
		String updateContent = request.getParameter("content");
		String wnum = request.getParameter("wnum");
		
		writerDTO dto = new writerDTO();
		writerService service = new writerService();
		
		dto.setwTitle(updateTitle);
		dto.setwContent(updateContent);
		dto.setwNum(Integer.parseInt(wnum));
		
		if(service.update(dto)) {
			response.sendRedirect("/board");
		}else {
			request.setAttribute("update-error", "수정 실패 !!");
			String view = "/WEB-INF/jsp/board/writer.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(view);
			rd.forward(request, response);
		}
	}

}

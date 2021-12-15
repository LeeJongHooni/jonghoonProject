package com.web.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.writer.model.*;


@WebServlet("/writer")
public class WriterController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String view = "/WEB-INF/jsp/board/writer.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(view);
		rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		request.setCharacterEncoding("utf-8");
		
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String userId = (String)session.getAttribute("userid");
		writerDTO dto = new writerDTO();
		writerService service = new writerService();
		
		dto.setSignId(service.select_signId(userId));
		dto.setwTitle(title);
		dto.setwContent(content);
		
		System.out.println(dto.getwTitle());
		System.out.println(dto.getwContent());
		System.out.println(dto.getSignId());
		
		if(service.insert(dto)) {
			response.sendRedirect("/board");
		}else {
			request.setAttribute("write-error", "글쓰기에 실패했습니다.");
			String view = "/WEB-INF/jsp/board/writer.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(view);
			rd.forward(request, response);
		}
		
	}

}

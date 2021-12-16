package com.web.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.writer.model.*;


@WebServlet("/delete")
public class DeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String wnum = request.getParameter("wnum");
		String delete = request.getParameter("hiddenval");
		writerService service = new writerService();
		
		System.out.println("delete:" + delete);
		
		if(service.delete(wnum)) {
			response.sendRedirect("/board");
		}else {
			request.setAttribute("delete-cancel", "게시글 삭제를 취소하셨습니다.");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}

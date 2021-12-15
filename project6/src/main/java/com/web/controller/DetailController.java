package com.web.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.writer.model.*;


@WebServlet("/detail")
public class DetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String wnum = request.getParameter("wnum");
		String viewCnt = request.getParameter("viewCnt");
		System.out.println("wnum : " + wnum);
		System.out.println("viewcnt : " + viewCnt);
		writerService service = new writerService();
		List<writerDTO> details = service.select_detail(wnum);
		
		request.setAttribute("details", details);
		
		if(service.viewCnt_update(wnum)){
			
		}
		String view = "/WEB-INF/jsp/board/detail.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(view);
		rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}

package com.web.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.comment.model.CommentDTO;
import com.comment.model.CommentService;
import com.sign.model.SignDTO;
import com.sign.model.SignService;
import com.writer.model.*;


@WebServlet("/detail")
public class DetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String wnum = request.getParameter("wnum");
		String viewCnt = request.getParameter("viewCnt");
		int userpkid = 0;
		List<SignDTO> userid = null;
		
		writerService service = new writerService();
		List<writerDTO> details = service.select_detail(wnum);
		CommentService cservice = new CommentService();
		SignService sService = new SignService();
		
		
		List<CommentDTO> datas = cservice.commentSelect();
		userid = cservice.commentUserid();
		getServletContext().setAttribute("details", details);
		
		for(writerDTO wdata: details) {
			userpkid = wdata.getSignId();
		};
		if(service.viewCnt_update(wnum)){
			request.setAttribute("detail_num", Integer.parseInt(wnum));
			getServletContext().setAttribute("userComment", datas);
			getServletContext().setAttribute("userCommentId", userid);
			String view = "/WEB-INF/jsp/board/detail.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(view);
			rd.forward(request, response);
		}
		
		if(datas.size() == 0 ) {
			request.setAttribute("comment-error", "댓글달기에 실패하셨습니다.");
			String view = "/WEB-INF/jsp/board/detail.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(view);
			rd.forward(request, response);
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


	}
}

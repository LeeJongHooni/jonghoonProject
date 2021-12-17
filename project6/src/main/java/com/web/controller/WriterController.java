package com.web.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
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
		
		MultipartRequest multi = new MultipartRequest(
				request
				, request.getServletContext().getRealPath("/upload")
				, 1024 * 1024 * 10
				, "utf-8"
				, new DefaultFileRenamePolicy()
				);
		
		String title = multi.getParameter("title");
		String content = multi.getParameter("content");
		String downloadPath = "/upload/" + multi.getFilesystemName("download");
		String userId = (String)session.getAttribute("userid");
		writerDTO dto = new writerDTO();
		writerService service = new writerService();
		
		
		dto.setSignId(service.select_signId(userId));
		dto.setwTitle(title);
		dto.setwContent(content);
		dto.setDownloadpath(downloadPath);
		
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

package com.web.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.writer.model.*;


@WebServlet("/update")
public class UpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MultipartRequest multi = new MultipartRequest(
				request
				, request.getServletContext().getRealPath("/upload")
				, 1024 * 1024 * 10
				, "utf-8"
				, new DefaultFileRenamePolicy()
				);
		
		String updateTitle = multi.getParameter("title");
		String updateContent = multi.getParameter("content");
		String updateFile = "/upload/" + multi.getFilesystemName("download");
		int wnum = Integer.parseInt(request.getParameter("wnum"));
		
		writerDTO dto = new writerDTO();
		writerService service = new writerService();
		
		dto.setwTitle(updateTitle);
		dto.setwContent(updateContent);
		if(!updateFile.contains("null")) {
			dto.setDownloadpath(updateFile);
		}else {
			List<writerDTO> datas = service.select_detail(wnum);
			for(writerDTO data: datas) {
				dto.setDownloadpath(data.getDownloadpath());
			}
		}
		
		dto.setwNum(wnum);
		
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

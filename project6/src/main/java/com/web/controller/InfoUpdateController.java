package com.web.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.oreilly.servlet.multipart.FileRenamePolicy;


@WebServlet("/infoupdate")
public class InfoUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String view = "/WEB-INF/jsp/info/infoupdate.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(view);
		rd.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		MultipartRequest multi = new MultipartRequest(
				request,
				request.getServletContext().getRealPath("/upload"),
				1024 * 1024 * 10,
				"utf-8",
				new DefaultFileRenamePolicy()
				);
		String myPhoto = "/upload/" + multi.getFilesystemName("profile_photo");
		System.out.println(myPhoto);
		JSONObject json = new JSONObject();
		json.put("profile_upload", myPhoto);
		
		response.getWriter().print(json.toJSONString());
		response.getWriter().flush();
	}

}

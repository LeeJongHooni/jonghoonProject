package com.web.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;


@WebFilter("/*")
public class EncodingFilter implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("----EncodingFilter----");
		//요청 필터 작성 영역
		request.setCharacterEncoding("utf-8");
		chain.doFilter(request, response);
		//응답 필터 작성 영역
		response.setContentType("text/html; charset=utf-8");
	}
}


package com.web.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebFilter({"/writer","/detail","/logout","/info"})
public class LoginFilter implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
	// 로그인 관련 세션이 활성화 되어있는지만 확인 
		System.out.println("----loginFilter----");
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse resp = (HttpServletResponse)response;
		HttpSession session = req.getSession();
		if(session.getAttribute("logined") != null) {
			boolean logined = (boolean) session.getAttribute("logined");
			if(logined) {				
				//활성화 되어있으면 다음필터로 전환
				chain.doFilter(request, response);
			}else {
			//활성화 안되어있으면 로그인 페이지로 리다이렉트 시켜주면됨.
			resp.sendRedirect(req.getContextPath() + "/login");
		
			}	
		}else {
			resp.sendRedirect(req.getContextPath() + "/login");
		}
	}


}

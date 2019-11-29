package com.sp.bdi.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.sp.bdi.user.UserVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SessionFilter implements Filter {

	public SessionFilter() {
		// TODO Auto-generated constructor stub
	}

	public void destroy() {
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest hsr = (HttpServletRequest) request;
		HttpSession hs = hsr.getSession();
		String uri = hsr.getRequestURI();
		UserVO user = null;
		if (hs.getAttribute("user") != null) {
			user = (UserVO) hs.getAttribute("user");
			log.debug("user:{}", user);
		}
		if (user == null && uri.indexOf("login") == -1) {
			if (uri.indexOf("/views") == 0) {
				hsr.setAttribute("msg", "로그인 해주세용");
				hsr.setAttribute("url", "/views/user/login");
				RequestDispatcher rd = request.getRequestDispatcher("/views/msg");
				rd.forward(request, response);
				return;
			}

		}
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}

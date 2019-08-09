package com.yc.fresh.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

public class BackInterceptor  implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)throws Exception {
		String path = request.getServletPath();
		
		path = path.substring(path.lastIndexOf("/") + 1);
		System.out.println("ce" + path);
		request.getRequestDispatcher("/WEB-INF/manager/" + path).forward(request, response);
		return false;
	}
}

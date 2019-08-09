package com.yc.fresh.interceptor;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;

import com.yc.fresh.entiry.MenberInfo;

public class FrontInterceptor  implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)throws Exception {
		
		//如果没有登录，则要提示登录，同时将此地址保存，待登入后转入哪个地方
		HttpSession session = request.getSession();
		MenberInfo men = (MenberInfo) session.getAttribute("currentUser");	
		if(men == null){ //如果没有登录
			
			PrintWriter out = response.getWriter();
			response.setContentType("text/html;charset=utf-8");
			String str = "<script>alert('请先登录'); localStorage.setItem('currentLocation', 'front/cart.html'); location.href='../login.html'</script>";
			out.print(str);
			out.flush();
			out.close();
			return false;
		}
		
		String path = request.getServletPath();
		path = path.substring(path.lastIndexOf("/") + 1);
		System.out.println("ce" + path);
		request.getRequestDispatcher("/WEB-INF/front/" + path).forward(request, response);
		return false;
	}
	
	
}

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
		
		//���û�е�¼����Ҫ��ʾ��¼��ͬʱ���˵�ַ���棬�������ת���ĸ��ط�
		HttpSession session = request.getSession();
		MenberInfo men = (MenberInfo) session.getAttribute("currentUser");	
		if(men == null){ //���û�е�¼
			
			PrintWriter out = response.getWriter();
			response.setContentType("text/html;charset=utf-8");
			String str = "<script>alert('���ȵ�¼'); localStorage.setItem('currentLocation', 'front/cart.html'); location.href='../login.html'</script>";
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

package cn.itcast.bookstore.user.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import cn.itcast.bookstore.user.domain.User;


public class LoginFilter implements Filter {


	public void destroy() {
		
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		/*
		 * 1.从session中获取用户信息
		 * 2.判断session中是否存在用户信息,有就放行
		 * 3.否则,保存错误信息转发到login.jsp中显示
		 */
		HttpServletRequest httpRequest = (HttpServletRequest)request;
		User user = (User) httpRequest.getSession().getAttribute("session_user");
		
		if(user!=null){
		chain.doFilter(request, response);
		}else{
			httpRequest.setAttribute("msg","你还没登录");
			httpRequest.getRequestDispatcher("jsps/user/login.jsp").forward(httpRequest, response);
			
		}
		
	}

	
	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}

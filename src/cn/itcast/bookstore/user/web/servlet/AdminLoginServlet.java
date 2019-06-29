package cn.itcast.bookstore.user.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.itcast.servlet.BaseServlet;

public class AdminLoginServlet extends BaseServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
	}
	
	public String adminLogin(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String admin = request.getParameter("admin");
		System.out.println(admin);
		String password = request.getParameter("password");
		HttpSession session = request.getSession();
		session.setAttribute("admin", admin);
		
		if(admin.equals("admin")&&password.equals("admin")){
			return "f:/adminjsps/admin/index.jsp";
		}else{
			return "f:/adminjsps/wrong.jsp";
		}
		
	}

}

package cn.zhku.bookstore.user.web.servlet;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.mail.MessagingException;
import javax.mail.Session;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.commons.CommonUtils;
import cn.itcast.mail.Mail;
import cn.itcast.mail.MailUtils;
import cn.itcast.servlet.BaseServlet;
import cn.zhku.bookstore.cart.domain.Cart;
import cn.zhku.bookstore.user.domain.User;
import cn.zhku.bookstore.user.service.UserException;
import cn.zhku.bookstore.user.service.UserService;

/**
 * User表述层
 * 
 * @author cpy
 * 
 */

public class UserServlet extends BaseServlet {
	private UserService userService = new UserService();
	
/**
 * 用户退出
 * @param request
 * @param response
 * @return
 * @throws ServletException
 * @throws IOException
 */
	public String quit(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		request.getSession().invalidate();
		return "r:/index.jsp";
		
	}
	
	/**
	 * 用户登录
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	
	public String login(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		//一键封装表单
		User form = CommonUtils.toBean(request.getParameterMap(), User.class);
		Map<String,String> errors = new HashMap<String ,String>();
		String username = form.getUsername();
		if (username == null || username.trim().isEmpty()) {
			errors.put("username", "用户名不能为空");
		} /*else if (username.length() < 3 || username.length() > 10) {
			errors.put("username", "用户名长度只能在3-10之间");
		}*/

		String password = form.getPassword();
		if (password == null || password.trim().isEmpty()) {
			errors.put("password", "密码不能为空");
		} /*else if (password.length() < 6 || password.length() > 15) {
			errors.put("password", "密码长度只能在6-15之间");
		}*/
		if(errors.size()>0){
			request.setAttribute("errors", errors);
			request.setAttribute("form", form);
			return "f:/jsps/user/login.jsp";
		}
		
		try {
			User user = userService.login(form);
			request.getSession().setAttribute("session_user", user);
			request.getSession().setAttribute("cart", new Cart());
			return "r:/index.jsp";
		} catch (UserException e) {
			request.setAttribute("msg", e.getMessage());
			request.setAttribute("form", form);
			return "f:/jsps/user/login.jsp";
		}
	
	}

		

	/**
	 * 激活功能
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String active(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String code = request.getParameter("code");
		try {
			userService.active(code);
			request.setAttribute("msg", "你已成功激活了,请马上登录");
		} catch (UserException e) {
			request.setAttribute("msg", e.getMessage());
		}
		return "f:/jsps/msg.jsp";
	}
	/**
	 * 用户注册
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String regist(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		User form = CommonUtils.toBean(request.getParameterMap(), User.class);
		form.setUid(CommonUtils.uuid());
		form.setCode(CommonUtils.uuid() + CommonUtils.uuid());
		Map<String, String> errors = new HashMap<String, String>();
		/*
		 * 输入校验 创建一个map用来封装错误信息,key为表单字段,value是错误信息
		 */
		String username = form.getUsername();
		if (username == null || username.trim().isEmpty()) {
			errors.put("username", "用户名不能为空");
		} else if (username.length() < 3 || username.length() > 10) {
			errors.put("username", "用户名长度只能在3-10之间");
		}

		String password = form.getPassword();
		if (password == null || password.trim().isEmpty()) {
			errors.put("password", "密码不能为空");
		} else if (password.length() < 6 || password.length() > 15) {
			errors.put("password", "密码长度只能在6-15之间");
		}

		String email = form.getEmail();
		if (email == null || email.trim().isEmpty()) {
			errors.put("email", "邮箱不能为空");
		} else if (!email.matches("\\w+@\\w+\\.\\w+")) {
			errors.put("email", "邮箱格式有误");

		}

		if (errors.size() > 0) {
			request.setAttribute("errors", errors);
			request.setAttribute("form", form);
			return "f:/jsps/user/regist.jsp";
		}

		try {

			userService.regist(form);

		} catch (UserException e) {
			request.setAttribute("msg", e.getMessage());
			request.setAttribute("form", form);
			request.setAttribute("code", form.getCode());
			return "f:/jsps/user/regist.jsp";
			
		}
		/*
		 * 发邮件 准备配置文件 获取配置文件内容
		 */
		Properties props = new Properties();
		props.load(this.getClass().getClassLoader()
				.getResourceAsStream("email_template.properties"));
		String host = props.getProperty("host");
		String uname = props.getProperty("uname");
		String pwd = props.getProperty("pwd");
		String from = props.getProperty("from");
		String to = form.getEmail();
		String subject = props.getProperty("subject");
		String content = props.getProperty("content");
		content = MessageFormat.format(content, form.getCode());
		Session session = MailUtils.createSession(host, uname, pwd);
		Mail mail = new Mail(from, to, subject, content);
		try {
			MailUtils.send(session, mail);
		} catch (MessagingException e) {
			e.printStackTrace();
		}

		request.setAttribute("msg", "恭喜,注册成功,请马上到邮箱中激活");
		return "f:/jsps/msg.jsp";

	}
}

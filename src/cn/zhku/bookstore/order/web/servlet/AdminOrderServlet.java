package cn.zhku.bookstore.order.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.servlet.BaseServlet;
import cn.zhku.bookstore.order.domain.Order;
import cn.zhku.bookstore.order.domain.OrderException;
import cn.zhku.bookstore.order.service.OrderService;

public class AdminOrderServlet extends BaseServlet {

	
	private OrderService orderService = new OrderService();
	
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
	}
	
	/**
	 * 后台找到所有的订单
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String allOrders(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		List<Order> orderList = orderService.findAllOrders();
		
		request.setAttribute("orderList", orderList);
		
		return "f:/adminjsps/admin/order/list.jsp";
	}
	public String findSomeOrders(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String state = request.getParameter("state");
		List<Order> orderList = orderService.findSomeOrders(state);
		
		request.setAttribute("orderList", orderList);
		
		return "f:/adminjsps/admin/order/list.jsp";
	}
	
	/**
	 * 后台的发货按钮，直接更新一下订单的状态就好了
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String sendOrders(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String oid = request.getParameter("oid");
		try{
			orderService.send(oid);
			request.setAttribute("msg", "正在打包发货！");
		}catch(OrderException e ){
			request.setAttribute("msg", e.getMessage());
		}
		return "f:/jsps/msg.jsp";
	}

}

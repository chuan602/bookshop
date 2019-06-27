package cn.zhku.bookstore.order.web.servlet;



import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

import cn.itcast.commons.CommonUtils;
import cn.itcast.servlet.BaseServlet;
import cn.zhku.bookstore.book.domain.Book;
import cn.zhku.bookstore.cart.domain.Cart;
import cn.zhku.bookstore.cart.domain.CartItem;
import cn.zhku.bookstore.order.domain.Order;
import cn.zhku.bookstore.order.domain.OrderException;
import cn.zhku.bookstore.order.domain.OrderItem;
import cn.zhku.bookstore.order.domain.Report;
import cn.zhku.bookstore.order.service.OrderService;
import cn.zhku.bookstore.user.domain.User;

public class OrderServlet extends BaseServlet {
	private OrderService orderService = new OrderService();
	
	/**
	 * 这个是支付宝支付
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	 public String payOrder(HttpServletRequest request, HttpServletResponse response) throws Exception {
		 String oid = request.getParameter("oid");
		 System.out.println(oid);
		 //String name = request.getParameter("name");
	    // String tele = request.getParameter("tele");
		// String address = request.getParameter("address");
//		 request.setAttribute("username", name);
//		 request.setAttribute("tele", tele);
//		 request.setAttribute("address", address);
		 Order order = orderService.findById(oid);
		 System.out.println(order);
		 request.setAttribute("order", order);
		 request.setAttribute("oid", oid);
		 orderService.zhiFu(oid);
		 return "f:/jsps/pay/openAliPay.jsp";
		 
		
		
	  }
	/**
	 * 这个是假支付，实在不行就用这个
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String pay(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String oid = request.getParameter("oid");
		orderService.zhiFu(oid);
		return "f:/jsps/order/final.jsp";

	}

	
	 /**
	  * 确认收货
	  * @param request
	  * @param response
	  * @return
	  * @throws ServletException
	  * @throws IOException
	  */
		public String confirm(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			String oid = request.getParameter("oid");
			try{
				orderService.confirm(oid);
				request.setAttribute("msg", "确认成功");
			}catch(OrderException e ){
				request.setAttribute("msg", e.getMessage());
			}
			return "f:/jsps/msg.jsp";
			
		}
	
	 /**
	  * 点击付款,加载订单
	  * @param request
	  * @param response
	  * @return
	  * @throws ServletException
	  * @throws IOException
	  */
	public String load(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
		
		request.setAttribute("order", orderService.load(request.getParameter("oid")));
		
		return "f:/jsps/order/desc.jsp";
	}
	 /**
	  * 我的订单
	  * @param request
	  * @param response
	  * @return
	  * @throws ServletException
	  * @throws IOException
	  */
	public String myOrders(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			
		User user = (User) request.getSession().getAttribute("session_user");
		String uid = user.getUid();
		List<Order> orderList = orderService.myOrders(uid);
		
		request.setAttribute("orderList", orderList);
		


		return "f:/jsps/order/list.jsp" ;
		 
	 }
	
	
	/**
	 * 添加订单
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String add(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Cart cart = (Cart) request.getSession().getAttribute("cart");
		Order order = new Order();
		order.setOid(CommonUtils.uuid());
		order.setOrdertime(new Date());
		order.setTotal(cart.getTotal());
		order.setState(1);
		User user = (User)request.getSession().getAttribute("session_user");
		order.setOwner(user);
		
		/*
		 * 创建订单条目集合
		 * 
		 */
		
		List<OrderItem> orderItemList = new ArrayList<OrderItem>();
		//循环遍历Cart中所有的CartItem,使用每一个CartItem对象创建orderItem对象,并添加到集合中
		
		for(CartItem cartItem:cart.getCartItems()){
			OrderItem oi = new OrderItem();
			oi.setIid(CommonUtils.uuid());
			oi.setCount(cartItem.getCount());
			oi.setBook(cartItem.getBook());
			oi.setSubtotal(cartItem.getSubtotal());
			oi.setOrder(order);
			
			
			orderItemList.add(oi);
		}
		order.setOrderItemList(orderItemList);
		
		//清空购物车
		cart.clear();
		//调用orderService添加订单
		orderService.add(order);
		request.setAttribute("order",order);
		request.getSession().setAttribute("ORDER", order);
		return "f:/jsps/order/desc.jsp";
	}
	
	public String deleteOrders(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		String oid = req.getParameter("oid");
		try{
			orderService.deleteOrders(oid);
		}catch(Exception e){
			req.setAttribute("msg", e.getMessage());
		}
		return "/OrderServlet?method=myOrders";
	}
	
	/**
	 * 销量情况
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String sellSituation(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		List<Report> list = orderService.report();
		request.setAttribute("bookList", list);
		System.out.println(orderService.report());

		String result = JSON.toJSONString(list);
		response.getWriter().print(result);
		System.out.println(result);
		return null;
	}
	
}

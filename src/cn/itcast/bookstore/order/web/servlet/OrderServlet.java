package cn.itcast.bookstore.order.web.servlet;



import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.bookstore.cart.domain.Cart;
import cn.itcast.bookstore.cart.domain.CartItem;
import cn.itcast.bookstore.order.domain.Order;
import cn.itcast.bookstore.order.domain.OrderException;
import cn.itcast.bookstore.order.domain.OrderItem;
import cn.itcast.bookstore.order.service.OrderService;
import cn.itcast.bookstore.user.domain.User;
import cn.itcast.commons.CommonUtils;
import cn.itcast.servlet.BaseServlet;

public class OrderServlet extends BaseServlet {
	private OrderService orderService = new OrderService();
	
	public String pay(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String oid = request.getParameter("oid");
		orderService.zhiFu(oid);
		return "f:/jsps/order/final.jsp";

	}
	/**
	 * 支付去银行
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String zhiFu(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Properties props = new Properties();
		InputStream in = this.getClass().getClassLoader().getResourceAsStream("merchantInfo.properties");
		props.load(in);
		/*
		 * 准备13参数
		 */
		String p0_Cmd ="Buy";
		String p1_MerId = props.getProperty("p1_MerId");
		String p2_Order = request.getParameter("oid");
		String p3_Amt = "0.01";
		String p4_Cur = "CNY";
		String p5_Pid = "";
		String p6_Pcat = ""; 
		String p7_Pdesc = "";
		String p8_Url = props.getProperty("p8_Url");
		String p9_SAF = "";
		String pa_MP ="";
		String pd_FrpId = request.getParameter("pd_FrpId");
		String pr_NeedResponse = "1";
		System.out.println(pd_FrpId);
		
		/*
		 * 计算hmac
		 */
		String keyValue = props.getProperty("keyValue");
		String hmac = PaymentUtil.buildHmac(p0_Cmd, p1_MerId, p2_Order, p3_Amt, 
				p4_Cur, p5_Pid, p6_Pcat, p7_Pdesc, p8_Url, p9_SAF, pa_MP,
				pd_FrpId, pr_NeedResponse, keyValue);
		/*
		 * 连接易宝的网址和13+1个参数
		 */
		StringBuilder url = new StringBuilder(props.getProperty("url"));
		url.append("?p0_Cmd=").append(p0_Cmd);
		url.append("&p1_MerId=").append(p1_MerId);
		url.append("&p2_Order=").append(p2_Order);
		url.append("&p3_Amt=").append(p3_Amt);
		url.append("&p4_Cur=").append(p4_Cur);
		url.append("&p5_Pid=").append(p5_Pid);
		url.append("&p6_Pcat=").append(p6_Pcat);
		url.append("&p7_Pdesc=").append(p7_Pdesc);
		url.append("&p8_Url=").append(p8_Url);
		url.append("&p9_SAF=").append(p9_SAF);
		url.append("&pa_MP=").append(pa_MP);
		url.append("&pd_FrpId=").append(pd_FrpId);
		url.append("&pr_NeedResponse=").append(pr_NeedResponse);
		url.append("&hmac=").append(hmac);
		/*
		 * 重定向到易宝
		 */
		response.sendRedirect(url.toString());
		return null;
		
	}
	/**
	 * 易宝回调方法
	 * 必须要判断调用方法的是不是易宝
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String back(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*
		 * 1.获取11+1参数
		 */
		String p1_MerId = request.getParameter("p1_MerId");
		String r0_Cmd = request.getParameter("r0_Cmd");
		String r1_Code = request.getParameter("r1_Code");
		String r2_TrxId = request.getParameter("r2_TrxId");
		String r3_Amt = request.getParameter("r3_Amt");
		String r4_Cur = request.getParameter("r4_Cur");
		String r5_Pid = request.getParameter("r5_Pid");
		String r6_Order = request.getParameter("r6_Order");
		String r7_Uid = request.getParameter("r7_Uid");
		String r8_MP = request.getParameter("r8_MP");
		String r9_BType = request.getParameter("r9_BType");

		String hmac = request.getParameter("hmac");
		/*
		 * 2.校验访问者是否是易宝
		 */
		Properties props = new Properties();
		InputStream in = this.getClass().getClassLoader().getResourceAsStream("merchantInfo.properties");
		props.load(in);
		String keyValue = props.getProperty("keyValue");
		boolean bool = PaymentUtil.verifyCallback(hmac, p1_MerId, r0_Cmd, 
				r1_Code, r2_TrxId, r3_Amt, r4_Cur, r5_Pid, r6_Order, 
				r7_Uid, r8_MP, r9_BType, keyValue);
		
		if(!bool){
			request.setAttribute("msg", "校验失败,非法访问!");
			return "f:/jsps/msg.jsp";
		}
		
		/*
		 * 3.获取订单状态,确定是否要修改订单状态,以及添加积分等其他业务操作
		 */
		orderService.zhiFu(r6_Order);
		/*
		 * 4.判断回调方式
		 * 如果是点对点,需要回馈以success开头的串
		 */
		if(r9_BType.equals("2")){
			response.getWriter().print("success");
		}
		/*
		 * 5.保存成功信息.转发到msg.sjp
		 */
		request.setAttribute("msg", "支付成功,祝你生活愉快");
		return "f:/jsps/msg.jsp";
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
		
		return "f:/jsps/order/desc.jsp";
	}
	
}

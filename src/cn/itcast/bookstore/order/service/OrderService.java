package cn.itcast.bookstore.order.service;

import java.sql.SQLException;
import java.util.List;

import cn.itcast.bookstore.order.dao.OrderDao;
import cn.itcast.bookstore.order.domain.Order;
import cn.itcast.bookstore.order.domain.OrderException;
import cn.itcast.jdbc.JdbcUtils;

public class OrderService {
	private OrderDao orderDao = new OrderDao();
	/**
	 * 添加订单
	 * 需要处理事务
	 * @param order
	 */
	public void add(Order order){
		try{
			//开启事务
			JdbcUtils.beginTransaction();
			//添加订单
			orderDao.addOrder(order);
			//添加订单条目到订单
			orderDao.addOrderItemList(order.getOrderItemList());
			
			
			
			//提交事务
			JdbcUtils.commitTransaction();
			
		} catch(Exception e ){
			 //回滚事务
			try {
				JdbcUtils.rollbackTransaction();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				throw new RuntimeException(e); 
			}			
		}
	}
	/**
	 * 
	 * 我的订单
	 * @param uid
	 * @return
	 */
	public List<Order> myOrders(String uid) {
		// TODO Auto-generated method stub
		return orderDao.findByUid(uid);
	}
	/**
	 * 加载订单
	 * @param oid
	 * @return
	 */
	public Order load(String oid) {
		return orderDao.load(oid);
	}
	/**
	 * 确认订单
	 * @param oid
	 * @throws OrderException
	 */
	public void confirm(String oid) throws OrderException {
		int state = orderDao.getStateByOid(oid);
		if(state!=3)throw new OrderException("订单确认失败,请重试");
		orderDao.updateState(oid,4);
		
	}
	public void send(String oid) throws OrderException {
		int state = orderDao.getStateByOid(oid);
		if(state!=2)throw new OrderException("发货失败,请重试");
		orderDao.updateState(oid,3);
		
	}
	
	/**
	 * 支付方法
	 * @param r6_Order
	 */
	public void zhiFu(String oid) {
		/*
		 * 1.获取订单的状态
		 * 	  如果是1 ,那么执行代码,否则什么都不做
		 */
		int state = orderDao.getStateByOid(oid);
		if(state==1){
			orderDao.updateState(oid, 2);
		}
		
	}
	//后台查询所有的订单
	public List<Order> findAllOrders() {
		// TODO Auto-generated method stub
		return orderDao.findAllOrders();
	}
	public List<Order> findSomeOrders(String state) {
		// TODO Auto-generated method stub
		return orderDao.findByState(state);
	}
}

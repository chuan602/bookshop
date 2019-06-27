package cn.itcast.bookstore.order.dao;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import cn.itcast.bookstore.book.domain.Book;
import cn.itcast.bookstore.order.domain.Order;
import cn.itcast.bookstore.order.domain.OrderItem;
import cn.itcast.bookstore.user.domain.User;
import cn.itcast.commons.CommonUtils;
import cn.itcast.jdbc.TxQueryRunner;

public class OrderDao {
	private QueryRunner qr = new TxQueryRunner();

	/**
	 * 添加订单到数据库
	 * 
	 * @param order
	 */
	public void addOrder(Order order) {
		try {
			String sql = "insert into orders values(?,?,?,?,?,?)";
			Timestamp timestamp = new Timestamp(order.getOrdertime().getTime());
			Object[] params = { order.getOid(), timestamp, order.getTotal(), order.getState(),
					order.getOwner().getUid(), order.getAddress() };
			qr.update(sql, params);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 添加订单条目到订单
	 * 
	 * @param orderItemList
	 */
	public void addOrderItemList(List<OrderItem> orderItemList) {
		try {
			String sql = "insert into orderitem values(?,?,?,?,?)";
			Object[][] params = new Object[orderItemList.size()][];
			for (int i = 0; i < orderItemList.size(); i++) {
				OrderItem item = orderItemList.get(i);
				params[i] = new Object[] { item.getIid(), item.getCount(), item.getSubtotal(), item.getOrder().getOid(),
						item.getBook().getBid() };
			}
			qr.batch(sql, params);

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 我的订单
	 * 
	 * @param uid
	 * @return
	 */
	public List<Order> findByUid(String uid) {
		try {
			/*
			 * 1.得到当前用户的所有订单
			 */
			String sql = "select * from orders where uid =?";
			List<Order> orderList = qr.query(sql, new BeanListHandler<Order>(Order.class), uid);
			/*
			 * 2.循环遍历每个Order,为其加载他自己所有的订单条目
			 */
			for (Order order : orderList) {
				loadOrderItems(order);// 为order对象添加它的所有订单条目
			}
			return orderList;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	/**
	 * 加载指定的订单的所有的订单条目
	 * 
	 * @param order
	 * @throws SQLException
	 */
	private void loadOrderItems(Order order) throws SQLException {
		// TODO Auto-generated method stub
		/*
		 * 查询两张表:orderitem,book
		 */
		String sql = "select * from orderitem i , book b where i.bid = b.bid and oid =?";
		List<Map<String, Object>> mapList = qr.query(sql, new MapListHandler(), order.getOid());
		List<OrderItem> orderItemList = toOrderItemList(mapList);
		order.setOrderItemList(orderItemList);

	}

	/**
	 * 把每个mapList中的每个Map装换成两个对象,并建立关系(把一堆map转换成一堆orderItem)
	 * 
	 * @param mapList
	 * @return
	 */
	private List<OrderItem> toOrderItemList(List<Map<String, Object>> mapList) {
		List<OrderItem> orderItemList = new ArrayList<OrderItem>();
		for (Map<String, Object> map : mapList) {
			OrderItem item = toOrderItem(map);
			orderItemList.add(item);
		}
		return orderItemList;
	}

	/**
	 * 把一个Map转换成一个OrderItem对象
	 * 
	 * @param map
	 * @return
	 */
	private OrderItem toOrderItem(Map<String, Object> map) {
		// TODO Auto-generated method stub
		OrderItem orderItem = CommonUtils.toBean(map, OrderItem.class);
		Book book = CommonUtils.toBean(map, Book.class);
		orderItem.setBook(book);
		return orderItem;
	}

	public Order load(String oid) {
		try {
			/*
			 * 1.得到当前用户的所有订单
			 */
			String sql = "select * from orders where oid =?";
			Order order = qr.query(sql, new BeanHandler<Order>(Order.class), oid);
			/*
			 * 2.为order加载他的所有条目
			 */

			loadOrderItems(order);// 为order对象添加它的所有订单条目

			return order;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	public int getStateByOid(String oid) {
		try {
			String sql = "select state from orders where oid =?";
			return (Integer) qr.query(sql, new ScalarHandler(), oid);

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void updateState(String oid, int state) {
		try {
			String sql = "update orders set state=? where oid=?";
			qr.update(sql, state, oid);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	// 找到所有的订单
	public List<Order> findAllOrders() {
		// TODO Auto-generated method stub
		try {

			String sql = "select * from orders ";
			List<Order> orderList = qr.query(sql, new BeanListHandler<Order>(Order.class));
			/*
			 * 2.循环遍历每个Order,为其加载他自己所有的订单条目
			 */
			for (Order order : orderList) {
				loadOrderItems(order);// 为order对象添加它的所有订单条目
			}
			return orderList;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	/**
	 * 后台找到各种状态的订单
	 * 
	 * @param state
	 * @return
	 */
	public List<Order> findByState(String state) {
		try {

			String sql = "select * from orders where state = ?";
			List<Order> orderList = qr.query(sql, new BeanListHandler<Order>(Order.class), state);
			/*
			 * 2.循环遍历每个Order,为其加载他自己所有的订单条目
			 */
			for (Order order : orderList) {
				loadOrderItems(order);// 为order对象添加它的所有订单条目
			}
			return orderList;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public Order findById(String oid) {
		// TODO Auto-generated method stub
		try {
			String sql = "select * from orders where oid = ? ";
			return qr.query(sql, new BeanHandler<Order>(Order.class), oid);

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void deleteOrders(String oid) {
		try {
			String sql1 = "delete from orderitem where oid = ?";
			String sql = "delete from orders where oid = ?";
			qr.update(sql1, oid);
			qr.update(sql, oid);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}

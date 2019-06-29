package cn.itcast.bookstore.cart.domain;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 购物车
 * @author cpy
 *
 */
public class Cart {
	//private Map<String,CartItem> map = new LinkedHashMap<String,CartItem>();
	private Map<String,CartItem> map = new LinkedHashMap<String,CartItem>();
	
	public double getTotal(){
		
		BigDecimal d = new BigDecimal("0");
		for(CartItem cartItem: map.values()){
			BigDecimal d1 = new BigDecimal(cartItem.getSubtotal()+"");
			d = d.add(d1);
		}
		return d.doubleValue();
	}
	/**
	 * 添加条目到购物车中
	 * @param cartItem
	 */
	/*public void add(CartItem cartItem){
		if(map.containsKey(cartItem.getBook().getBid())){
			CartItem _cartItem = map.get(cartItem.getBook().getBid());
			_cartItem.setCount(_cartItem.getCount()+cartItem.getCount());
			map.put(cartItem.getBook().getBid(), _cartItem);
		}else{
			map.put(cartItem.getBook().getBid(), cartItem);
		}
	}*/
	public void add(CartItem cartItem) {
		if(map.containsKey(cartItem.getBook().getBid())) {//判断原来车中是否存在该条目
			CartItem _cartItem = map.get(cartItem.getBook().getBid());//返回原条目
			_cartItem.setCount(_cartItem.getCount() + cartItem.getCount());//设置老条目的数量为，其自己数量+新条目的数量
			map.put(cartItem.getBook().getBid(), _cartItem);
		} else {
			map.put(cartItem.getBook().getBid(), cartItem);
		}
	}
	/**
	 * 清空所有条目
	 */
	public void clear(){
		map.clear();
	}
	/**
	 * 删除指定条目
	 * @param bid
	 */
	public void delete(String bid){
		map.remove(bid);
	}
	/**
	 * 获取所有条目
	 * @return
	 */
	public Collection<CartItem> getCartItems(){
		return map.values();
	}
	
	
}

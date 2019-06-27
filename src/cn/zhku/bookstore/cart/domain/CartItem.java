package cn.zhku.bookstore.cart.domain;

import java.math.BigDecimal;

import cn.zhku.bookstore.book.domain.Book;

/**
 * 购物车条目
 * @author cpy
 *
 */
public class CartItem {
	private Book book;//商品
	private int count;//数量
	
	public double getSubtotal(){//小计
		BigDecimal d1 = new BigDecimal(book.getPrice()+"");
		BigDecimal d2 = new BigDecimal(count+"");
		return d1.multiply(d2).doubleValue();
	}
	
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	@Override
	public String toString() {
		return "Cartitem [book=" + book + ", count=" + count + "]";
	}
	
}

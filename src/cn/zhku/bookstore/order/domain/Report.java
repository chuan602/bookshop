package cn.zhku.bookstore.order.domain;

import cn.zhku.bookstore.book.domain.Book;

public class Report extends Book{
	private int totalCount;
	private String bidd;
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public String getBidd() {
		return bidd;
	}
	public void setBidd(String bidd) {
		this.bidd = bidd;
	}
}

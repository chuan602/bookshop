package cn.itcast.bookstore.search.service;

import java.util.List;

import cn.itcast.bookstore.book.domain.Book;
import cn.itcast.bookstore.search.dao.SearchDao;

public class SearchService {
	private SearchDao searchDao = new SearchDao();

	/**
	 * 查询全部
	 * 
	 * @return
	 */
	public List<Book> search(String condition) {
		return searchDao.search(condition);
	}

}

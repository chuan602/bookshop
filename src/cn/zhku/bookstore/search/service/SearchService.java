package cn.zhku.bookstore.search.service;

import java.util.List;

import cn.zhku.bookstore.book.domain.Book;
import cn.zhku.bookstore.search.dao.SearchDao;

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

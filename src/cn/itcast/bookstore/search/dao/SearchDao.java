package cn.itcast.bookstore.search.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.itcast.bookstore.book.domain.Book;
import cn.itcast.jdbc.TxQueryRunner;

public class SearchDao {
	private QueryRunner qr = new TxQueryRunner();

	/**
	 * 搜索
	 * 
	 * @return List<Book>
	 */
	public List<Book> search(String condition) {
		try {
			String sql = "select * from book where bname LIKE ?";
			return qr.query(sql, new BeanListHandler<Book>(Book.class),condition);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}

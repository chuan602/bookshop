package cn.itcast.bookstore.book.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import cn.itcast.bookstore.book.domain.Book;
import cn.itcast.bookstore.category.domain.Category;
import cn.itcast.commons.CommonUtils;
import cn.itcast.jdbc.TxQueryRunner;

public class BookDao {
	private QueryRunner qr = new TxQueryRunner();

	/**
	 * 查询全部
	 * 
	 * @return
	 */
	public List<Book> fingAll() {
		try {
			String sql = "select * from book where del=false";
			return qr.query(sql, new BeanListHandler<Book>(Book.class));
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 按分类查询
	 * 
	 * @param cid
	 * @return
	 */
	public List<Book> findByCategory(String cid) {
		try {
			String sql = "select * from book where cid = ? and del =false";
			return qr.query(sql, new BeanListHandler<Book>(Book.class), cid);

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 加载图书
	 * 
	 * @param bid
	 * @return
	 */
	public Book load(String bid) {
		try {
			String sql = "select *from book where bid=?";
			Map<String,Object> map =  qr.query(sql, new MapHandler(),bid);
			Book book = CommonUtils.toBean(map, Book.class);
			Category category = CommonUtils.toBean(map, Category.class);
			book.setCategory(category);
			return book;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	/**
	 * 查询图书数量byId
	 * @param cid
	 * @return
	 */
	public int getCountByCid(String cid) {
		try{
			String sql = "select count(*) from book where cid =?";
			Number cnt  =(Number) qr.query(sql, new ScalarHandler(),cid);
			return cnt.intValue();
		}catch (SQLException e ){
			 throw new RuntimeException(e);
		}
	}
	/**
	 * 增加图书
	 * @param book
	 */
	public void add(Book book) {
		try{
			String sql ="insert into book values(?,?,?,?,?,?,?)";
			Object [] params = {book.getBid(),book.getBname(),book.getPrice(),
					book.getAuthor(),book.getImage(),book.getCategory().getCid(),0};
			
			qr.update(sql,params);
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
		
	}
	/**
	 * 修改del标记,达到删除的母的
	 * @param bid
	 */
	public void updateDel(String bid) {
		try{
			String sql ="update book set del=1 where bid=?";
			qr.update(sql,bid);
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
		
	}

	public void edit(Book book) {
		try{
			String sql = "update book set bname=?,price=?,author=?,image=?,cid=? where bid=?";
			Object[] params={book.getBname(),book.getPrice(),book.getAuthor(),book.getImage(),book.getCategory().getCid(),book.getBid()};
			qr.update(sql,params);
			
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
		
	}

	public List<Book> findByName(String bookName) {
		try {
			String sql = "select * from book where bname  like ? and del =false";
			return qr.query(sql, new BeanListHandler<Book>(Book.class), bookName);

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}

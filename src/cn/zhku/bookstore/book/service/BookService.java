package cn.zhku.bookstore.book.service;

import java.util.List;

import cn.zhku.bookstore.book.dao.BookDao;
import cn.zhku.bookstore.book.domain.Book;

public class BookService {
	private BookDao bookDao = new BookDao();

	/**
	 * 查询全部
	 * 
	 * @return
	 */
	public List<Book> findAll() {
		return bookDao.fingAll();
	}

	/**
	 * 按分类查询
	 * 
	 * @param cid
	 * @return
	 */
	public List<Book> findByCategory(String cid) {
		return bookDao.findByCategory(cid);
	}

	/**
	 * 加载图书信息
	 * 
	 * @param bid
	 * @return
	 */
	public Book load(String bid) {
		return bookDao.load(bid);
	}
	/**
	 * 添加图书
	 * @param book
	 */
	public void add(Book book) {
		bookDao.add(book);
		
	}
	/**
	 * 根据bid删除(假删除,只是修改标记)
	 * @param bid
	 */
	public void delete(String bid) {
		bookDao.updateDel(bid);
		
	}
	/**
	 * 修改方法
	 * @param book
	 */
	public void edit(Book book) {
		
		bookDao.edit(book);
		
	}
	/**
	 * 根据书的名字去查找。当做是搜索了
	 * @param bookName
	 * @return
	 */
	public List<Book> findBookByName(String bookName) {
		// TODO Auto-generated method stub
		return bookDao.findByName(bookName);
	}
	//图表统计的查询方法，销量好的图书
	public List<Book> sells() {
		
		return  bookDao.findSells();
	}
}

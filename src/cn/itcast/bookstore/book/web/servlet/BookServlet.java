package cn.itcast.bookstore.book.web.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Test;

import net.sf.json.JSONArray;

import com.alibaba.fastjson.JSON;
import com.google.gson.Gson;

import cn.itcast.bookstore.book.domain.Book;
import cn.itcast.bookstore.book.service.BookService;
import cn.itcast.servlet.BaseServlet;

public class BookServlet extends BaseServlet {
	private BookService bookService = new BookService();
	
	
	/**
	 * 销量情况
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String sellSituation(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		 List<Book> list = new ArrayList<Book>();
		request.setAttribute("bookList", list);
		System.out.println(bookService.sells());
		
		System.out.println(list.toString());
		for(Book book:list){
			System.out.println(book.getBname()+":");
		}
		//String result = JSON.toJSONString(list);
		//System.out.println(result);
		//JSONArray jsonArray2 = JSONArray.fromObject(list);
		
		return null;
	}
	
	
	/**
	 * 根据全名称搜索,就当做是搜索了。。。  在首页那里找一个合适的位置放一下
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String findBookByName(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String bookName = request.getParameter("keyword");
		bookName = "%"+bookName+"%";
		request.setAttribute("searchList", bookService.findBookByName(bookName));
		
		return "f:/jsps/search/searchList.jsp";
	}

	/**
	 * 加载图书
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String load(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setAttribute("book",
				bookService.load(request.getParameter("bid")));
		return "f:/jsps/book/desc.jsp";

	}

	/**
	 * 查询全部图书
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String findAll(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("bookList", bookService.findAll());
		return "f:/jsps/book/list.jsp";
	}

	/**
	 * 按分类查询
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String findByCategory(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String cid = request.getParameter("cid");
		request.setAttribute("bookList", bookService.findByCategory(cid));
		return "f:/jsps/book/list.jsp";
	}

}

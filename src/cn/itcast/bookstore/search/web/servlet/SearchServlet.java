package cn.itcast.bookstore.search.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.bookstore.category.service.CategoryService;
import cn.itcast.bookstore.search.service.SearchService;
import cn.itcast.servlet.BaseServlet;

/**
 * Servlet implementation class SearchServlet
 */
public class SearchServlet extends BaseServlet {
	private SearchService searchService = new SearchService();
	
	
	public String search(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		String condition = req.getParameter("keyword");
		req.setAttribute("searchList",searchService.search("%"+condition+"%"));
		return "f:/jsps/search/searchList.jsp";
	}

}

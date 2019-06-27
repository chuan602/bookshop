package cn.zhku.bookstore.book.web.servlet.admin;


import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.ImageIcon;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadBase;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import cn.itcast.commons.CommonUtils;
import cn.zhku.bookstore.book.domain.Book;
import cn.zhku.bookstore.book.service.BookService;
import cn.zhku.bookstore.category.domain.Category;
import cn.zhku.bookstore.category.service.CategoryService;

public class AdminAddBookServlet extends HttpServlet {
	private BookService bookService = new BookService();
	private CategoryService categoryService = new CategoryService();
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		/*
		 * 上传3步:创建工厂,得到解析器,使用解析器解析request对象
		 */
		
		DiskFileItemFactory  factory = new DiskFileItemFactory(15*1024,new File("C://Users//cpy//Documents//download//temp"));
		ServletFileUpload sfu = new ServletFileUpload(factory);
		//设置单个文件大小是15kb
		sfu.setFileSizeMax(15*1024);
		try {
			List<FileItem> fileItemList = sfu.parseRequest(request);
			/*
			 * 1.把fileItem中的数据封装到Book对象中
			 * >先把所有普通表单项的数据封装到map中
			 * >再把map中的数据封装到book中
			 */
			Map<String,String> map = new HashMap<String,String>();
			for(FileItem fileItem : fileItemList){
				if(fileItem.isFormField()){
					map.put(fileItem.getFieldName(),fileItem.getString("UTF-8"));
				}
			}
			
			Book book = CommonUtils.toBean(map, Book.class);
			//为book指定bid
			book.setBid(CommonUtils.uuid());
			//需要把map中的cid封装到Category中,再把category赋给book
			Category category = CommonUtils.toBean(map, Category.class);
			book.setCategory(category);
			/*
			 * 2.保存上传的文件
			 * >保存的目录
			 * >保存的文件名称
			 */
			//得到保存的目录
			String savepath = this.getServletContext().getRealPath("/book_img");
			//得到文件的名称
			String filename = CommonUtils.uuid()+"_"+fileItemList.get(1).getName();
			
			/*
			 * 校验文件的拓展名
			 */
			if(!filename.toLowerCase().endsWith("jpg")){
				request.setAttribute("msg", "您上传的图片格式不是jpg拓展名");
				request.setAttribute("categoryList", categoryService.findAll());
				request.getRequestDispatcher("/adminjsps/admin/book/add.jsp").forward(request, response);
				return;
			}
			
			//使用目录和文件名称创建目标文件
			File destFile = new File(savepath,filename);
			//保存上传文件到目标文件位置
			fileItemList.get(1).write(destFile);
			
			/*
			 * 设置book对象的image
			 */
			book.setImage("book_img/"+filename);
			System.out.println(book);
			bookService.add(book);
			
			/*
			 * 校验图片尺寸
			 */
			Image image = new ImageIcon(destFile.getAbsolutePath()).getImage();
			if(image.getWidth(null)>200||image.getHeight(null)>200){
				destFile.delete();
				request.setAttribute("msg", "你上传的图片尺寸超出了200*200");
				request.setAttribute("categoryList", categoryService.findAll());
				request.getRequestDispatcher("/adminjsps/admin/book/add.jsp").forward(request, response);
				return;
			}
			
			
			request.getRequestDispatcher("/admin/AdminBookServlet?method=findAll").forward(request, response);
		
		} catch (Exception e) {
			if(e instanceof FileUploadBase.FileSizeLimitExceededException){
				request.setAttribute("msg", "您上传的图片超出了15Kb");
				System.out.println(request.getAttribute("msg"));
				request.setAttribute("categoryList",categoryService.findAll());
				request.getRequestDispatcher("/adminjsps/admin/book/add.jsp").forward(request, response);
				
				
			}
			
		}
		
	
	}

}

package com.trungtamjava.controller.admin;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.trungtamjava.dao.CategoryDao;
import com.trungtamjava.dao.ProductDao;
import com.trungtamjava.dao.impl.CategoryDaoImpl;
import com.trungtamjava.dao.impl.ProductDaoImpl;
import com.trungtamjava.model.Category;
import com.trungtamjava.model.Product;

@WebServlet(urlPatterns = "/admin/product/add")
public class AddProductController extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		CategoryDao categoryDao = new CategoryDaoImpl();
		Product product = new Product();
		List<Category> categoryList = categoryDao.search("");
		req.setAttribute("categoryList", categoryList);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/views/admin/product/addProduct.jsp");
		dispatcher.forward(req, resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {

			DiskFileItemFactory factory = new DiskFileItemFactory();

			/// doi thanh duong dan toi thu muc, luu tam thoi file upload len
			factory.setRepository(new File("D:\\anh"));

			ServletFileUpload servletFileUpload = new ServletFileUpload(factory);
			/// danh sach cac truong input tu form client
			List<FileItem> fieldList = servletFileUpload.parseRequest(req);

			Product product = new Product();
			// lay ra tung input
			for (FileItem item : fieldList) {
				System.out.println("1");
				if (item.getFieldName().equals("name")) {
					String name = item.getString();
					product.setName(name);
				}
				System.out.println("2");
				if (item.getFieldName().equals("price")) {
					String price = item.getString();
					product.setPrice(Integer.parseInt(price));
				}
				System.out.println("3");
				if (item.getFieldName().equals("description")) {
					String description = item.getString();
					product.setDesciption((description));
				}
				System.out.println("4");
				if (item.getFieldName().equals("categoryId")) {
					String categoryId = item.getString();

					Category category = new Category();
					category.setId(Integer.parseInt(categoryId));
					product.setCategory(category);
				}
				System.out.println("5");
				if (item.getFieldName().equals("imageFile")) {
					if (item.getSize() > 0) {
						final String UPLOAD_FOLDER = "D:\\anh";// duong dan trong may
						// tao 1 file tren server
						// tim dinh dang file
						String name = item.getName();// item .get name tra ve ten file upload
						int index = name.lastIndexOf(".");// tim giau cham cuoi cung
						String ext = name.substring(index);// lay ra phan dinh dang file cat tu dau "." do ve cuoi xem
															// ng ta up load file gi de tai tao file
						// minh se k lay ten file anh up len vi se xay ra trung nhau ma tao 1 file ten
						// moi

						/// tao file de luu tren server
						String image = System.currentTimeMillis() + ext;// thoi gian hien tai + ðuôi file .
						File file = new File(UPLOAD_FOLDER + File.separator + image);
						// ghi du lieu upload len vao file
						item.write(file);// doc du lieu tu item ban vao file

						product.setImage(image);// luu lai ten file anh trong db
					}
				}
			}
			System.out.println("6");
			ProductDao producDao = new ProductDaoImpl();
			producDao.add(product);

			resp.sendRedirect(req.getContextPath() + "/admin/product/search");
		} catch (Exception e) {
			System.out.println("Loi " + e);
		}

	}

}

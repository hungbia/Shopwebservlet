package com.trungtamjava.client;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.trungtamjava.dao.CategoryDao;
import com.trungtamjava.dao.ProductDao;
import com.trungtamjava.dao.impl.CategoryDaoImpl;
import com.trungtamjava.dao.impl.ProductDaoImpl;
import com.trungtamjava.model.Category;
import com.trungtamjava.model.Product;

@WebServlet(urlPatterns = "/client/product/category") // ?cid=2
public class ClientProductSearchCategoryController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String categoryId = req.getParameter("cid");// doc url
		// mac dinh lay tat ca san pham
		ProductDao productDao = new ProductDaoImpl();
		List<Product> pList = productDao.search(categoryId);
		req.setAttribute("Plist", pList);

		CategoryDao categoryDao = new CategoryDaoImpl();
		List<Category> cList = categoryDao.search("");
		req.setAttribute("categoryList", cList);

		RequestDispatcher dispatcher = req.getRequestDispatcher("/views/client/product/search-product.jsp");
		dispatcher.forward(req, resp);

	}

}

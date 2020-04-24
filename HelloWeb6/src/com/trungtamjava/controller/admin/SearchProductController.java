package com.trungtamjava.controller.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.trungtamjava.dao.ProductDao;
import com.trungtamjava.dao.impl.ProductDaoImpl;
import com.trungtamjava.model.Product;

@WebServlet(urlPatterns = "/admin/product/search")
public class SearchProductController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ProductDao dao = new ProductDaoImpl();
		List<Product> productList = dao.search("");
		req.setAttribute("products", productList);// key value
		RequestDispatcher dispatcher = req.getRequestDispatcher("/views/admin/product/search-product.jsp");
		dispatcher.forward(req, resp);

	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String keyword = req.getParameter("keyword");
		ProductDao dao = new ProductDaoImpl();
		List<Product> productList = dao.search(keyword);
		req.setAttribute("products", productList);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/views/admin/product/search-product.jsp");
		dispatcher.forward(req, resp);
	}
}
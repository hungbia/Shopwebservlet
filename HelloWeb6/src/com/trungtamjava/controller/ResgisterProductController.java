package com.trungtamjava.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.trungtamjava.dao.ProductDao;
import com.trungtamjava.dao.impl.ProductDaoImpl;
import com.trungtamjava.model.Category;
import com.trungtamjava.model.Product;

@WebServlet(urlPatterns = "/product/dang-ky")
public class ResgisterProductController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getRequestDispatcher("/views/dangky-product.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// doc du lieu tu form gui len
		String id = req.getParameter("id");
		String name = req.getParameter("name");
		String price = req.getParameter("price");
		String image = req.getParameter("image");
		String description = req.getParameter("description");
		String categoryId = req.getParameter("categoryId");

		System.out.println(id);
		System.out.println(name);
		System.out.println(price);
		System.out.println(categoryId);
		System.out.println(image);
		System.out.println(description);

		Product product = new Product();
		ProductDao productDao = new ProductDaoImpl();
		product.setId(Integer.parseInt(id));
		product.setName(name);
		product.setPrice(Integer.parseInt(price));
		Category ca = new Category();
		ca.setId(Integer.parseInt(categoryId));
		product.setCategory(ca);

		productDao.update(product);
		resp.sendRedirect("/HelloWeb6/admin/product/search");

	}
}

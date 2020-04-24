package com.trungtamjava.controller.admin;

import java.io.IOException;

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

@WebServlet(urlPatterns = "/admin/product/update")
// /?id=1
public class UpdateProductController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// doc du lieu url
		String id = req.getParameter("id");
		ProductDao productDao = new ProductDaoImpl();
		Product product = productDao.getProduct(Integer.parseInt(id));
		req.setAttribute("products", product);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/views/client/update-product.jsp");
		dispatcher.forward(req, resp);
		System.out.println("táo lê");

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// doc du lieu tu form
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

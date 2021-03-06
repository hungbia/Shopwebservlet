package com.trungtamjava.controller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.trungtamjava.dao.ProductDao;
import com.trungtamjava.dao.impl.ProductDaoImpl;

@WebServlet(urlPatterns = "/admin/product/delete")
// /?id=1
public class DeleteProductContorller extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// doc duong dan url o tren id= 1
		String id = req.getParameter("id");
		ProductDao productDao = new ProductDaoImpl();
		productDao.delete(Integer.parseInt(id));
		resp.sendRedirect("/HelloWeb6/admin/product/search");

	}
}

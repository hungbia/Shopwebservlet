package com.trungtamjava.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/trang-chu")
public class Home extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = "Hello servlet";
		int tong = 10;
		req.setAttribute("tong", tong);
		req.setAttribute("msg", name);// set req de gui len kieu MAp key values
		RequestDispatcher dispatcher1 = req.getRequestDispatcher("/views/admin/category/search-category.jsp");
		dispatcher1.forward(req, resp);

	}

}

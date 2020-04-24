package com.trungtamjava.controller.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.trungtamjava.dao.CategoryDao;
import com.trungtamjava.dao.impl.CategoryDaoImpl;
import com.trungtamjava.model.Category;

@WebServlet(urlPatterns = "/admin/category/search")
public class SearchCategoryController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		CategoryDao categoryDao = new CategoryDaoImpl();
		List<Category> categories = categoryDao.search("");
		req.setAttribute("category", categories);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/views/admin/category/search-category.jsp");
		dispatcher.forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String keyword = req.getParameter("keyword");
		CategoryDao categoryDao = new CategoryDaoImpl();
		List<Category> categories = categoryDao.search(keyword);
		req.setAttribute("category", categories);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/views/admin/category/search-category.jsp");
		dispatcher.forward(req, resp);
	}
}

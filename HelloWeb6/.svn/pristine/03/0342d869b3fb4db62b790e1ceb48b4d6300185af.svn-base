package com.trungtamjava.controller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.trungtamjava.dao.UserDao;
import com.trungtamjava.dao.impl.UserDaoImpl;

@WebServlet(urlPatterns = "/admin/user/delete")
// /?id=1
public class DeleteUser extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// doc duong dan url
		String id = req.getParameter("id");
		UserDao dao = new UserDaoImpl();
		dao.delete(Integer.parseInt(id));// ep kieu sang so nguyen
		resp.sendRedirect("/HelloWeb6/admin/user/search");
	}

}

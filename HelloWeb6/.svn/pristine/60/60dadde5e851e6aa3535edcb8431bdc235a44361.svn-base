package com.trungtamjava.client;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.trungtamjava.dao.UserDao;
import com.trungtamjava.dao.impl.UserDaoImpl;
import com.trungtamjava.model.User;

@WebServlet(urlPatterns = "/login-member") // ?errCode=100
public class ClientLoginController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String code = req.getParameter("errCode");
		if (code != null && code.equals("100")) {
			req.setAttribute("msg", "tai khoan mat khau sai");
			RequestDispatcher dispathcer = req.getRequestDispatcher("/views/client/login.jsp");
			dispathcer.forward(req, resp);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// doc du lieu tu form gui len
		String username = req.getParameter("username");
		String pass = req.getParameter("password");
		// tao session
		HttpSession session = req.getSession();
		UserDao dao = new UserDaoImpl();
		User user = dao.getByUsername(username);
		if (user != null && user.getPassword().equals(pass)) {
			System.out.println("login thanh cong");
			// luu doi tuong vao session
			session.setAttribute("LoginUser", user);
			resp.sendRedirect("/HelloWeb6/client/product/search");

		} else {
			System.out.println("Fail");
			resp.sendRedirect("/login-member?errCode=100");
		}
	}

}

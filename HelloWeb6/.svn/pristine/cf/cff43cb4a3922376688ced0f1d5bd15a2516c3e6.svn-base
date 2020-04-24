package com.trungtamjava.controller.admin;

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

@WebServlet(urlPatterns = "/dang-nhap")
// ?errCode=100
public class Login extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String code = req.getParameter("errCode");
		System.out.println(code);

		if (code != null && code.equals("100")) {
			req.setAttribute("msg", "Tai khoan hoac mat khai sai");
		}

		RequestDispatcher dispatcher = req.getRequestDispatcher("/views/admin/login.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("HELLO POST");
		// doc du lieu tu form gui len
		String username = req.getParameter("ten");
		String password = req.getParameter("pass");
		// tao session
		HttpSession session = req.getSession();// get session chua co doi tuogn
												// nao thi new 1 doi tuong moi ,
												// k co tu tao. luu trong bo nho
												// severlet quan ly ,
		// co the set thoi gian song xac dinh ( bt new person k du dung se bi
		// mat di )
		// session luu sever cookie luu client trinh duyet cung co thoi gian
		// song co the set ,
		// sesion khi reset thời gian sống sẽ tính lại cooki set cứng.
		System.out.println("session id login:" + session.getId());
		UserDao userDao = new UserDaoImpl();
		User user = userDao.getByUsername(username);

		if (user != null && user.getPassword().equals(password)) {// check user xem có chưa và check pass với pass nhập
																	// vào
			System.out.println("Log in success");
			// luu doi tượng vào session
			session.setAttribute("loginUser", user);// key value//login
													// thanh cong luu
													// lai username o
													// day

			// / chuyen huong
			// server tra ve 1 duong dan url
			// client se goi sang duong dan moi
			resp.sendRedirect("/HelloWeb6/admin/product/search");
		} else {
			System.out.println("Fail");
			resp.sendRedirect("/HelloWeb6/dang-nhap");
		}
	}

}

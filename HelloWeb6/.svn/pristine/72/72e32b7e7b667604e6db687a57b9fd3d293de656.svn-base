package com.trungtamjava.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.trungtamjava.dao.impl.UserDaoImpl;
import com.trungtamjava.model.User;

@WebServlet(urlPatterns = "/user/dangky")
public class RegisterController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getRequestDispatcher("/views/dangki.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// doc du lieu tu form gui len
		String name = req.getParameter("name");
		String userName = req.getParameter("username");
		String password = req.getParameter("password");
		String image = req.getParameter("image");
		String gender = req.getParameter("gender");
		String role = req.getParameter("role");
		String age = req.getParameter("age");
		// int age = Integer.parseInt(req.getParameter("age"));

		System.out.println(name);
		System.out.println(userName);
		System.out.println(password);
		System.out.println(image);
		System.out.println(gender);
		System.out.println(role);
		System.out.println(age);

		User user = new User();
		user.setName(name);
		user.setUsername(userName);
		user.setPassword(password);
		user.setImage(image);
		user.setGender(gender);
		user.setRole(role);
		user.setAge(Integer.parseInt(age));
		UserDaoImpl daoImpl = new UserDaoImpl();
		daoImpl.add(user);

		// / chuyen huong
		// server tra ve 1 duong dan url
		// client se goi sang duong dan moi
		resp.sendRedirect("/HelloWeb6/dang-nhap");
	}
}

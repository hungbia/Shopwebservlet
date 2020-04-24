package com.trungtamjava.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/dangki")
public class Dangki extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getRequestDispatcher("/views/dangki.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("HELLO POST");
		// doc du lieu tu form gui len
		String username = req.getParameter("ten");
		String password = req.getParameter("pass");
		String gioitinh = req.getParameter("gen");
		String city = req.getParameter("city");
		String[] fav = req.getParameterValues("fav");

		System.out.println(username);
		System.out.println(password);
		System.out.println(gioitinh);
		System.out.println(city);
		System.out.println(fav);
		if ("admin".equals(username) && "123".equals(password)) {
			System.out.println("log in success");
			// chuyen huong
			// sever tra ve 1 duong dan url
			// client se goi sang 1 duong dan moi
			// su dung 2 req khac nhau ( duong dan khac nhau)
			resp.sendRedirect("/HelloWed/trang-chu");
		} else {
			System.out.println("FAil");
			resp.sendRedirect("/HelloWeb6/dang-nhap");
		}

	}
}

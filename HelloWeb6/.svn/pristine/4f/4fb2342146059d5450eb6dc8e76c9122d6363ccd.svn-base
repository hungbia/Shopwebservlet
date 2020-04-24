package com.trungtamjava.controller;

import java.io.IOException;

import javax.jws.soap.SOAPBinding.Use;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.trungtamjava.model.User;

@WebServlet(urlPatterns = "/user")
public class ProfileController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		User user = new User();
		user.setId(1);
		user.setName("hung");
		user.setAge(28);
		req.setAttribute("u", user);
		RequestDispatcher dispatcher = req
				.getRequestDispatcher("Use-detai.jsp");
		dispatcher.forward(req, resp);
	}
}

package com.trungtamjava.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/xinchao")
public class GoodNight extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// resp.setContentType("text/html");
		// PrintWriter pw = resp.getWriter();//respon tra ve
		// pw.println("<h1 class=>chao</h1>");
		// pw.println("<h2>xinchao</h2>");
		//
		// pw.close();
		RequestDispatcher dispatcher = req
				.getRequestDispatcher("/html/form.html");// chuyen sang 1 file
															// khac
		dispatcher.forward(req, resp);// khi vao xin chao thi xin chao forward (
										// goi cho 1 thang khac).

	}

}

package com.trungtamjava.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/hello")
public class HelloController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("helloa");

		resp.setContentType("text/html");// contentype tra ve file html , co the
											// tra ve mp3 mp4 ..v.v.
		PrintWriter pw = resp.getWriter();
		pw.println("<h1>Hello</h1>");
		pw.println("<h1>Hello servlet</h1>");

		pw.close();
	}

}

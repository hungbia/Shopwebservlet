package com.trungtamjava.client;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = "/client/logout")
public class ClientLogoutController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		// cach 1 xoa doi tuong session
		session.invalidate();// xoa session
		// cach 2 : Xoa key trong doi tuong session
		// session.removeAttribute("loginUsername");
		resp.sendRedirect("client/product/search");
	}

}

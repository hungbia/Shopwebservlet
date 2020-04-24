package com.trungtamjava.controller.admin;

import java.io.IOException;
import java.util.List;

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

@WebServlet(urlPatterns = "/admin/user/search")
public class SearchUser extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// User user = new User();
		// user.setId(1);
		// user.setName("hung");
		// user.setAge(28);
		// req.setAttribute("u", user);
		// User user1 = new User();
		// user1.setId(2);
		// user1.setName("hai");
		// user1.setAge(24);
		// List<User> users = new ArrayList<User>();
		// users.add(user);
		// users.add(user1);
		// UserDao userDao = new UserDaoImpl();
		// List<User> users = userDao.search("");
		//
		// req.setAttribute("userList", users);
		//
		// RequestDispatcher dispatcher = req
		// .getRequestDispatcher("/SearchUser.jsp");
		// dispatcher.forward(req, resp);
//		HttpSession session = req.getSession();
//		System.out.println("session id search:" + session.getId());
//		Object object = session.getAttribute("loginUsername");
//		if (object != null) {
//			String username = (String) object;// ep kieu xuong
//			System.out.println(username);
//		} else {
//			// k con login nua het thoi gian
//			// session cu da bi xoa,
//			resp.sendRedirect("/HelloWeb6/dang-nhap");
//		}
		UserDao dao = new UserDaoImpl();
		List<User> listUsers = dao.search("");// go trang thi show ra 1 list
		// req.setAttribute("userlist", users);
		// danh sach goi tu ham
		// dao.search
		req.setAttribute("users", listUsers);// key value
		RequestDispatcher dispatcher = req.getRequestDispatcher("/views/admin/user/search-user.jsp");
		dispatcher.forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String keyword = req.getParameter("keyword");
		UserDao userDao = new UserDaoImpl();
		List<User> userList = userDao.search(keyword);
		req.setAttribute("users", userList);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/views/admin/user/search-user.jsp");
		dispatcher.forward(req, resp);
	}
}

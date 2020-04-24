package com.trungtamjava.client;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.trungtamjava.dao.BillDao;
import com.trungtamjava.dao.BillProductDao;
import com.trungtamjava.dao.impl.BillDaoImpl;
import com.trungtamjava.dao.impl.BillProductDaoImpl;
import com.trungtamjava.model.Bill;
import com.trungtamjava.model.BillProduct;
import com.trungtamjava.model.User;

@WebServlet(urlPatterns = "/member-add-order")
public class AddOderController extends HttpServlet {
	BillDao billDao = new BillDaoImpl();
	BillProductDao billProductDao = new BillProductDaoImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		Object object = session.getAttribute("cart");// luu tam voa session
		if (object != null) {
			Map<String, BillProduct> map = (Map<String, BillProduct>) object;
			Bill bill = new Bill();

			SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
			bill.setBuyDate(sdf.format(new Date()));

			// lay dang nhap
			User buyer = (User) session.getAttribute("loginUser");
			bill.setBuyer(buyer);
			billDao.create(bill);
			// timmathang
			long total = 0;
			for (Entry<String, BillProduct> entry : map.entrySet()) {
				BillProduct billProduct = entry.getValue();

				billProduct.setBill(bill);// set bill id vao day
				billProductDao.create(billProduct);
				// tinh tong gia
				total += billProduct.getQuantity() * billProduct.getUnitPrice();
			}
			// cap nhap lai bill de co tong gia tien
			bill.setPriceTotal(total);
			billDao.update(bill);
			// chuyen ve trang thanh cong
			// xoa session gio hang vi da tao don hang thanh cong, giai phong bo nho
			session.removeAttribute("cart");
			resp.sendRedirect("/member/bills");
		} else {
			resp.sendRedirect("/client/product/search");
		}
	}

}

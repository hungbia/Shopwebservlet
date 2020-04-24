package com.trungtamjava.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.trungtamjava.dao.BillDao;
import com.trungtamjava.dao.JDBCConnection;
import com.trungtamjava.model.Bill;
import com.trungtamjava.model.User;

public class BillDaoImpl extends JDBCConnection implements BillDao {

	@Override
	public void create(Bill b) {
		Connection conn = super.getConn();
		try {
			String sql = "INSERT INTO bill(idperson, buydate, pricetotal) VALUES(?,?,?)";
			PreparedStatement preparedStatement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);// tra ve
																												// id
																												// den
																												// ra de
																												// luwu
																												// sang
																												// bill
			preparedStatement.setString(1, b.getBuyer().getName());
			preparedStatement.setString(2, b.getBuyDate());
			preparedStatement.setLong(3, b.getPriceTotal());
			preparedStatement.executeUpdate();

			/// tra ve ID gen ra, de luu sang bill
			ResultSet generatedKeys = preparedStatement.getGeneratedKeys();

		} catch (Exception e) {
			System.out.println("loi create +" + e);
		}

	}

	@Override
	public void update(Bill b) {
		Connection conn = super.getConn();
		try {
			String sql = "UPDATE bill SET(idperson =?, buydate=?, pricetotal=? WHERE id = ? )";
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setInt(1, b.getBuyer().getId());
			preparedStatement.setString(2, b.getBuyDate());
			preparedStatement.setLong(3, b.getPriceTotal());
			preparedStatement.setInt(4, b.getId());
			preparedStatement.executeUpdate();

		} catch (Exception e) {
			System.out.println("loiupdate +" + e);
		}
	}

	@Override
	public void delete(int id) {
		Connection connection = super.getConn();
		try {
			String sql = "DELETE from bill where id = ?";

			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();

		} catch (Exception e) {
			System.out.println("loi delete" + e);
		}

	}

	@Override
	public Bill get(int id) {
		Connection connection = super.getConn();
		String sql = "SELECT bill.id ,person.name , bill.buydate,bill.pricetotal FROM person inner join bill ON bill.idperson = person.id WHERE bill.id =?";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				int Pid = rs.getInt("bill.id");
				String name = rs.getString("person.name");
				String buyDAte = rs.getString("bill.duydate");
				long priceTotal = rs.getLong("bill.pricetoltal");
				Bill b = new Bill();
				b.setId(Pid);
				b.setBuyDate(buyDAte);
				b.setPriceTotal(priceTotal);

				User user = new User();
				user.setName(name);
				b.setBuyer(user);
				return b;
			}

		} catch (Exception e) {
			System.out.println("loi get" + e);
		}
		return null;
	}

	@Override
	public List<Bill> search(int userId) {
		List<Bill> billList = new ArrayList<Bill>();
		try {
			String sql = "SELECT id , name , buyDate, pricetotal FROM bill WHERE buyer_id = ?";
			Connection conn = super.getConn();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, userId);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int pid = rs.getInt("id");
				String pname = rs.getString("name");
				String buydate = rs.getString("buydate");
				Long pricetotal = rs.getLong("bill.pricetotal");

				Bill p = new Bill();
				p.setId(pid);
				p.setBuyDate(buydate);
				p.setPriceTotal(pricetotal);

				User user = new User();
				user.setName(pname);
				p.setBuyer(user);

				billList.add(p);
			}
		} catch (Exception ex) {
			System.out.println("search loi :" + ex);
		}

		return billList;
	}

	@Override
	public List<Bill> getAll() {
		List<Bill> billList = new ArrayList<Bill>();
		try {
			String sql = "SELECT bill.id , bill.buy_date,bill.price_total, user.name  FROM bill inner join user ON bill.buyer_id = user.id";
			Connection conn = super.getConn();
			PreparedStatement ps = conn.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int pid = rs.getInt("id");
				String buyerName = rs.getString("name");
				String buydate = rs.getString("buy_date");
				Long pricetotal = rs.getLong("price_total");

				Bill bill = new Bill();
				bill.setId(pid);
				bill.setBuyDate(buydate);
				bill.setPriceTotal(pricetotal);

				User buyer = new User();
				buyer.setName(buyerName);
				bill.setBuyer(buyer);

				billList.add(bill);
			}
		} catch (Exception ex) {
			System.out.println("Update loi :" + ex);
		}

		return billList;
	}

}

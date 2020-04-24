package com.trungtamjava.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.trungtamjava.dao.JDBCConnection;
import com.trungtamjava.dao.PhoneDao;
import com.trungtamjava.model.Person;
import com.trungtamjava.model.Phone;

public class PhoneDaoImpl implements PhoneDao {

	public void create(Phone phone) {
		try {
			Connection conn = JDBCConnection.getConn();
			String sql = "insert into phone (id,phone_no,person_id) values (?,?,?)";
			PreparedStatement s1 = conn.prepareStatement(sql);
			s1.setInt(1, phone.getId());
			s1.setString(1, phone.getPhoneNo());
			s1.setInt(2, phone.getPerson().getId());
			s1.executeUpdate();
			System.out.println("thanhcong");

		} catch (Exception ex) {
			System.out.println("loi cr" + ex);
		}

	}

	public void getPhone(int id) {
		try {
			String sql = "select pe.id as 'p_id',pe.name,pe.age,p.id as 'phone_id', p.phone_no from person pe inner join phone p on pe.id = p.person_id where p.id = ?";
			Connection conn = JDBCConnection.getConn();
			PreparedStatement s1 = conn.prepareStatement(sql);
			s1.setInt(1, id);

		} catch (Exception ex) {
			System.out.println("loi get" + ex);
		}

	}

	public void update(Phone phone) {
		try {
			Connection conn = JDBCConnection.getConn();
			String sql = "update set phone_no = ?,person_id=? where id = ?";
			PreparedStatement s1 = conn.prepareStatement(sql);

			s1.setString(1, phone.getPhoneNo());
			s1.setInt(2, phone.getPerson().getId());
			s1.setInt(3, phone.getId());
			s1.executeUpdate();
			System.out.println("thanhcong");

		} catch (Exception ex) {
			System.out.println("loi upadte" + ex);
		}

	}

	public void delete(int id) {
		try {
			Connection conn = JDBCConnection.getConn();
			String sql = "delete from phone where id = ?";
			PreparedStatement pre = conn.prepareStatement(sql);

			pre.setInt(1, id);
			pre.executeUpdate();
			System.out.println("thanhcong");

		} catch (Exception ex) {
			System.out.println("loi delete" + ex);
		}
	}

	public List<Phone> search(String phoneNo) {
		List<Phone> listphone = new ArrayList<Phone>();
		Connection connection = JDBCConnection.getConn();

		try {
			String sql = "SELECT p.id as 'p_id', p.name,p.age,ph.id as 'phone_id',ph.phone_no "
					+ " FROM person p INNER JOIN phone ph ON ph.person_id = p.id WHERE ph.phone_no LIKE ?";

			PreparedStatement pre = connection.prepareStatement(sql);
			pre.setString(1, "%" + phoneNo + "%");
			ResultSet rs = pre.executeQuery();// goi ham sql bo vao trong

			while (rs.next()) {
				Phone phone = new Phone();
				int phoneId = rs.getInt("phone_id");
				phone.setId(phoneId);
				phone.setPhoneNo(rs.getString("phone_no"));

				Person person = new Person();
				person.setId(rs.getInt("p_id"));
				person.setName(rs.getString("name"));
				person.setAge(rs.getInt("age"));

				phone.setPerson(person);// tao qhe . tc bac cau

				listphone.add(phone);
			}
		} catch (Exception e) {
			System.out.println("Search loi " + e);
		}
		return listphone;
	}

	public Phone get(int id) {
		Connection connection = JDBCConnection.getConn();

		try {
			String sql = "SELECT p.id as 'p_id', p.name,p.age,ph.id as 'phone_id',ph.phone_no "
					+ " FROM person p INNER JOIN phone ph ON ph.person_id = p.id WHERE ph.id = ?";
			PreparedStatement pr = connection.prepareStatement(sql);
			pr.setInt(1, id);

			ResultSet rs = pr.executeQuery();

			while (rs.next()) {
				Phone phone = new Phone();
				int phoneId = rs.getInt("phone_id");
				phone.setId(phoneId);
				phone.setPhoneNo(rs.getString("phone_no"));

				Person person = new Person();
				person.setId(rs.getInt("p_id"));
				person.setName(rs.getString("name"));
				person.setAge(rs.getInt("age"));

				phone.setPerson(person);// tao qhe
				return phone;
			}
		} catch (Exception ex) {
			System.out.println("loi get" + ex);
		}

		return null;
	}
}

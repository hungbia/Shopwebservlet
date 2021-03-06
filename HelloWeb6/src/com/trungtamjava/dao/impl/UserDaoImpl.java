package com.trungtamjava.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.trungtamjava.dao.JDBCConnection;
import com.trungtamjava.dao.UserDao;
import com.trungtamjava.model.User;

public class UserDaoImpl extends JDBCConnection implements UserDao {

	@Override
	public void add(User user) {
		Connection conn = super.getConn();
		try {
			String sql = "INSERT INTO user(name,age,username, password,role, gender, image) VALUES (?,?,?,?,?,?,?)";
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, user.getName());
			preparedStatement.setInt(2, user.getAge());
			preparedStatement.setString(3, user.getUsername());
			preparedStatement.setString(4, user.getPassword());
			preparedStatement.setString(5, user.getRole());
			preparedStatement.setString(6, user.getGender());
			preparedStatement.setString(7, user.getImage());
			preparedStatement.executeUpdate();

		} catch (Exception ex) {
			System.out.println("loi add" + ex);
		}

	}

	@Override
	public void update(User user) {
		Connection conn = super.getConn();
		try {
			String sql = "update user set name=?,age=?,username=?,password=?,role=?,gender=?,image=? where id=?";
			PreparedStatement preparedStatement = conn.prepareStatement(sql);

			preparedStatement.setString(1, user.getName());
			preparedStatement.setInt(2, user.getAge());
			preparedStatement.setString(3, user.getUsername());
			preparedStatement.setString(4, user.getPassword());
			preparedStatement.setString(5, user.getRole());
			preparedStatement.setString(6, user.getGender());
			preparedStatement.setString(7, user.getImage());

			preparedStatement.executeUpdate();
			System.out.println("update thanh cong");

		} catch (Exception ex) {
			System.out.println("loi update" + ex);
		}

	}

	@Override
	public User delete(int id) {
		Connection conn = super.getConn();
		try {
			String sql = "delete from user where id =?";
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
			System.out.println("xoa thanh cong");

		} catch (Exception ex) {
			System.out.println("loi delete" + ex);
		}

		return null;
	}

	@Override
	public User get(int id) {
		Connection conn = super.getConn();
		try {
			String sql = "select * from user where id =?";
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setInt(1, id);

			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				User user = new User();
				int Uid = rs.getInt("id");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				String username = rs.getString("username");
				String password = rs.getString("password");
				String role = rs.getString("role");
				String gender = rs.getString("gender");
				String image = rs.getString("image");

				user.setId(Uid);
				user.setName(name);
				user.setAge(age);
				user.setUsername(username);
				user.setPassword(password);
				user.setRole(role);
				user.setGender(gender);
				user.setImage(image);

				return user;
			}

		} catch (Exception ex) {
			System.out.println("loi ");
		}
		return null;
	}

	@Override
	public User getByUsername(String username) {
		Connection conn = super.getConn();
		try {
			String sql = "select * from user where username=?";
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, username);

			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				User user = new User();
				int Uid = rs.getInt("id");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				String password = rs.getString("password");
				String role = rs.getString("role");
				String gender = rs.getString("gender");
				String image = rs.getString("image");

				user.setId(Uid);
				user.setName(name);
				user.setAge(age);
				user.setUsername(username);
				user.setPassword(password);
				user.setRole(role);
				user.setGender(gender);
				user.setImage(image);

				return user;
			}
		} catch (Exception ex) {
			System.out.println("loi getbyuser" + ex);
		}

		return null;
	}

	@Override
	public List<User> search(String name) {
		Connection conn = super.getConn();
		List<User> listUser = new ArrayList<User>();
		try {
			String sql = "select id,name,age,username,password,role,gender,image from user where name like ?";
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, "%" + name + "%");

			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				int Uid = rs.getInt("id");
				String username = rs.getString("name");
				int age = rs.getInt("age");
				String username1 = rs.getString("username");
				String password = rs.getString("password");
				String role = rs.getString("role");
				String gender = rs.getString("gender");
				String image = rs.getString("image");

				User user = new User();
				user.setId(Uid);
				user.setName(username);
				user.setAge(age);

				user.setUsername(username1);
				user.setPassword(password);
				user.setRole(role);
				user.setGender(gender);
				user.setImage(image);
				listUser.add(user);

			}
		} catch (Exception ex) {
			System.out.println("loi search" + ex);
		}
		return listUser;
	}
}

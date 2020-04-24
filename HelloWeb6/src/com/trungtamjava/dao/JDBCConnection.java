package com.trungtamjava.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class JDBCConnection {
	public static void main(String[] args) {
		Connection con = getConn();
		if (con != null) {
			System.out.println("thanh cong");
		} else {
			System.out.println("that bai");

		}
	}

	public static Connection getConn() {
		final String username = "root";
		final String password = "";
		final String url = "jdbc:mysql://localhost:3306/helloweb10";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			return DriverManager.getConnection(url, username, password);
		} catch (Exception ex) {
			System.out.println(ex);
		}
		return null;
	}
}

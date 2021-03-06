package com.trungtamjava.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.trungtamjava.dao.CategoryDao;
import com.trungtamjava.dao.JDBCConnection;
import com.trungtamjava.model.Category;

public class CategoryDaoImpl extends JDBCConnection implements CategoryDao {

	@Override
	public void add(Category category) {
		try {
			String sql = "insert into category (name) values (?)";
			Connection conn = super.getConn();
			PreparedStatement p = conn.prepareStatement(sql);
			p.setString(1, category.getName());
			p.executeUpdate();

		} catch (Exception ex) {
			System.err.println("loi add" + ex);
		}

	}

	@Override
	public void update(Category category) {
		try {
			String sql = "update category set name =? where id=?";
			Connection conn = super.getConn();
			PreparedStatement p = conn.prepareStatement(sql);
			p.setString(1, category.getName());
			p.setInt(2, category.getId());
			p.executeUpdate();

		} catch (Exception ex) {
			System.err.println("loiupdate" + ex);
		}

	}

	@Override
	public void delete(int id) {
		try {
			String sql = "delete from category where id=?";
			Connection conn = super.getConn();
			PreparedStatement p = conn.prepareStatement(sql);
			p.setInt(1, id);
			p.executeUpdate();
			System.out.println("oke xoa");

		} catch (Exception ex) {
			System.err.println("loi delete" + ex);

		}
	}

	@Override
	public Category get(int id) {
		try {
			String sql = "select * from category where id =?";
			Connection conn = super.getConn();
			PreparedStatement p = conn.prepareStatement(sql);
			p.setInt(1, id);
			ResultSet resultSet = p.executeQuery();
			while (resultSet.next()) {
				Category category = new Category();
				category.setId(resultSet.getInt("id"));
				category.setName(resultSet.getNString("name"));
				return category;
			}

		} catch (Exception ex) {
			System.err.println("loi get" + ex);

		}
		return null;
	}

	@Override
	public List<Category> search(String name) {
		List<Category> categories = new ArrayList<Category>();
		Connection conn = super.getConn();

		try {
			String sql = "select * from category where name like  ? ";
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, "%" + name + "%");
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				Category c = new Category();
				c.setId(rs.getInt("id"));
				c.setName(rs.getString("name"));

				categories.add(c);
			}
		} catch (Exception ex) {
			System.out.println("loi search moi" + ex);
		}
		return categories;
	}
}

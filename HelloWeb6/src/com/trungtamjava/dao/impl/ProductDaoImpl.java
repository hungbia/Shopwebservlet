package com.trungtamjava.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.trungtamjava.dao.JDBCConnection;
import com.trungtamjava.dao.ProductDao;
import com.trungtamjava.model.Category;
import com.trungtamjava.model.Product;

public class ProductDaoImpl implements ProductDao {

	@Override
	public void add(Product product) {
		try {
			Connection conn = JDBCConnection.getConn();
			String sql = "insert into product(name,price,image,description,category_id) values(?,?,?,?,?)";
			PreparedStatement p = conn.prepareStatement(sql);
			p.setString(1, product.getName());
			p.setInt(2, product.getPrice());
			p.setString(3, product.getImage());
			p.setString(4, product.getDesciption());
			p.setInt(5, product.getCategory().getId());
			p.executeUpdate();
		} catch (Exception e) {
			System.out.println("loi up date " + e);
		}
	}

	@Override
	public void update(Product product) {
		try {
			Connection conn = JDBCConnection.getConn();
			String sql = "update product set name=?, price=?,image=? ,description, category_id=? where id=?";
			PreparedStatement p = conn.prepareStatement(sql);
			p.setString(1, product.getName());
			p.setInt(2, product.getPrice());
			p.setString(3, product.getImage());
			p.setString(4, product.getDesciption());
			p.setInt(5, product.getCategory().getId());
			p.setInt(6, product.getId());
			p.executeUpdate();
		} catch (Exception e) {
			System.out.println("loi update " + e);
		}
	}

	@Override
	public Product getProduct(int id) {
		try {
			Connection conn = JDBCConnection.getConn();
			String sql = "select p.* ,c.name as 'c_name' from product p inner join category c on p.category_id = c.id where p.id = ?";
			PreparedStatement p = conn.prepareStatement(sql);
			p.setInt(1, id);
			ResultSet rs = p.executeQuery();
			while (rs.next()) {
				Product product = new Product();
				product.setId(rs.getInt("id"));
				product.setName(rs.getNString("name"));
				product.setImage(rs.getNString("image"));
				product.setPrice(rs.getInt("price"));
				product.setDesciption(rs.getNString("description"));

				Category category = new Category();
				category.setId(rs.getInt("id"));
				category.setName("name");
				product.setCategory(category);
				return product;
			}
		} catch (Exception e) {
			System.out.println("loi " + e);
		}
		return null;
	}

	@Override
	public void delete(int id) {
		try {
			Connection conn = JDBCConnection.getConn();

			String sql = "delete from product where id=?";
			PreparedStatement p = conn.prepareStatement(sql);
			p = conn.prepareStatement(sql);
			p.setInt(1, id);
			p.executeUpdate();
		} catch (Exception e) {
			System.out.println("loi delete" + e);
		}
	}

	@Override
	public List<Product> search(String name) {
		List<Product> list = new ArrayList<Product>();
		Connection conn = JDBCConnection.getConn();
		try {
			String sql = "select product.id,product.name,product.price,product.image,product.description,category.name From product inner join category  on product.category_id = category.id WHERE product.name LIKE ?";
			PreparedStatement p = conn.prepareStatement(sql);
			p = conn.prepareStatement(sql);
			p.setString(1, "%" + name + "%");
			ResultSet rs = p.executeQuery();
			while (rs.next()) {
				Product product = new Product();
				product.setId(rs.getInt("product.id"));
				product.setName(rs.getNString("product.name"));
				product.setImage(rs.getNString("product.image"));
				product.setPrice(rs.getInt("product.price"));
				product.setDesciption(rs.getNString("product.description"));

				Category category = new Category();
				category.setName("category.name");
				product.setCategory(category);
				list.add(product);
			}

		} catch (Exception e) {
			System.out.println("loi" + e);
		}
		return list;
	}

	@Override
	public List<Product> search(int category_id) {

		List<Product> pList = new ArrayList<Product>();
		try {
			String sql = "SELECT p.*, c.name as 'c_name' FROM product p "
					+ "INNER JOIN category c ON p.category_id = c.id WHERE p.category_id = ?";
			Connection conn = JDBCConnection.getConn();

			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, category_id);

			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				Product p = new Product();
				p.setId(rs.getInt("p.id"));
				p.setName(rs.getString("p.name"));
				p.setImage(rs.getString("p.image"));
				p.setPrice(rs.getInt("p.price"));
				p.setDesciption(rs.getString("p.description"));

				Category category = new Category();
				category.setId(rs.getInt("c.category_id"));
				category.setName(rs.getString("name"));

				p.setCategory(category);

				pList.add(p);
			}
		} catch (Exception ex) {
			System.out.println("loi search" + ex);
		}
		return pList;
	}

}

package be04.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import be04.entity.Book;
import be04.entity.Category;
import utility.connection.DbUtil;

//Write function:
public class CategoryService {
	public List<Category> getAllCategories() throws SQLException {

		// Hard code to generate list
//		list.add(new Category(1, "Geography"));
//		list.add(new Category(2, "Maths"));
//		list.add(new Category(3, "English"));

		// connect to DB
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Category> list = new ArrayList<Category>();
		try {
			// make connection to mySQL
			conn = DbUtil.makeConnection();

			// --> table Category -->
			// Run query "Select * from category"
			ps = conn.prepareStatement("Select * from `category`");

			// execute and get result SET
			rs = ps.executeQuery();

			// mapping data in result set (If result has data) into Entity class
			// Category
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				Category category = new Category(id, name);
				list.add(category);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				rs.close();
			}
			if (ps != null) {
				ps.close();
			}
			if (conn != null) {
				conn.close();
			}
		}
		return list;
	}

	public List<Category> getCategoriesBySearch(String searchText) throws SQLException {
		// connect to DB
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Category> list = new ArrayList<Category>();
		try {
			// make connection to mySQL
			conn = DbUtil.makeConnection();

			// --> table Category -->
			// Run query "Select * from category"
			ps = conn.prepareStatement("Select * from category where name like ?");
			ps.setString(1, "%" + searchText + "%");

			// execute and get result SET
			rs = ps.executeQuery();

			// mapping data in result set (If result has data) into Entity class
			// Category
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				Category category = new Category(id, name);
				list.add(category);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				rs.close();
			}
			if (ps != null) {
				ps.close();
			}
			if (conn != null) {
				conn.close();
			}
		}
		return list;
	}
}
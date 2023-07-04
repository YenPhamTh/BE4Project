package be04.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import be04.entity.Book;
import utility.connection.DbUtil;

public class BookService {
	
	public List<Book> getBooksByCategory(int categoryId) throws SQLException {
		// connect to DB
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Book> list = new ArrayList<Book>();
		try {
			// make connection to mySQL
			conn = DbUtil.makeConnection();
			
			//--> table Category -->
			// Run query "Select * from category"
			ps = conn.prepareStatement("Select * from book where category_id = ?");
			ps.setInt(1, categoryId);
			
			// execute and get result SET
			rs = ps.executeQuery();
			
			//mapping data in result set (If result has data) into Entity class
			//Category
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				
				Book book = new Book(id, name, categoryId);
				list.add(book);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				rs.close();
			}
			if (ps !=null) {
				ps.close();
			}
			if (conn !=null) {
				conn.close();
			}
		}
		return list;
	}

public List<Book> getAllBooks() throws SQLException {
	// connect to DB
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	List<Book> list = new ArrayList<Book>();
	try {
		// make connection to mySQL
		conn = DbUtil.makeConnection();
		
		//--> table Category -->
		// Run query "Select * from category"
		ps = conn.prepareStatement("Select * from book");
		// ps.setInt(1, categoryId);
		
		// execute and get result SET
		rs = ps.executeQuery();
		
		//mapping data in result set (If result has data) into Entity class
		//Category
		while (rs.next()) {
			int id = rs.getInt("id");
			String name = rs.getString("name");
			int categoryId = rs.getInt("category_id");
			
			Book book = new Book(id, name, categoryId);
			list.add(book);
		}
	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		if (rs != null) {
			rs.close();
		}
		if (ps !=null) {
			ps.close();
		}
		if (conn !=null) {
			conn.close();
		}
	}
	return list;
}

public List<Book> getBooksBySearch(String searchText) throws SQLException {
	// connect to DB
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	List<Book> list = new ArrayList<Book>();
	try {
		// make connection to mySQL
		conn = DbUtil.makeConnection();
		
		//--> table Category -->
		// Run query "Select * from category"
		ps = conn.prepareStatement("Select * from book where name like ?");
		ps.setString(1, "%"+ searchText + "%");
		
		// execute and get result SET
		rs = ps.executeQuery();
		
		//mapping data in result set (If result has data) into Entity class
		//Category
		while (rs.next()) {
			int id = rs.getInt("id");
			String name = rs.getString("name");
			int categoryId = rs.getInt("category_id");
			
			Book book = new Book(id, name, categoryId);
			list.add(book);
		}
	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		if (rs != null) {
			rs.close();
		}
		if (ps !=null) {
			ps.close();
		}
		if (conn !=null) {
			conn.close();
		}
	}
	return list;
}
}
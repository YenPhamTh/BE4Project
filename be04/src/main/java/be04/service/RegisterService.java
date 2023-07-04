package be04.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import be04.entity.Account;
import utility.connection.DbUtil;

public class RegisterService {

	public int registerAccount(Account account) throws SQLException {
		// connect to DB
		Connection conn = null;
		PreparedStatement ps = null;
		int rs = 0;
		try {
			// make connection to mySQL
			conn = DbUtil.makeConnection();
			
			//--> table Category -->
			// Run query "Select * from category"
			ps = conn.prepareStatement("INSERT INTO `be4`.`account` (`firstName`, `lastName`, `email`, `password`) VALUES (?, ?, ?, ?);");
			ps.setString(1, account.getFistName());
			ps.setString(2, account.getLastName());
			ps.setString(3, account.getEmail());
			ps.setString(4, account.getPassword());
			
			// execute and get result SET
			ps.executeQuery();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
//			if (rs != null) {
//				rs.close();
//			}
			if (ps !=null) {
				ps.close();
			}
			if (conn !=null) {
				conn.close();
			}
		}
		return rs;
	}
}
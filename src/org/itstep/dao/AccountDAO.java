package org.itstep.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.itstep.model.Account;

public class AccountDAO {

public void saveAccount(Account account) {
		
		Connection connection = null;
		PreparedStatement statement = null;
		String sql = "INSERT INTO account(user_email, user_password) VALUES(?, ?)";
		
		
		try {
			connection = ConnectionDB.getConnection();
			statement = connection.prepareStatement(sql);
			statement.setString(1, account.getEmail());
			statement.setString(2, account.getPassword());
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}

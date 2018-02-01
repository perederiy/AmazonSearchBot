package org.itstep.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.itstep.dao.ConnectionDB;
import org.itstep.model.Account;

public class AddVLandCDAO {

	public void addCart(String asinItem, Account account, long timeAddToCart) {
		
		Connection connection = null;
		PreparedStatement statement = null;
		String sql = "INSERT INTO add_good_to_wishlist_and_cart(email, asin, add_to_cart, time_add_cart) VALUES(?, ?, ?, ?)";
		
		try {
			connection = ConnectionDB.getConnection();
			statement = connection.prepareStatement(sql);
			statement.setString(1, account.getEmail());
			statement.setString(2, asinItem);
			statement.setString(3, "+");
			statement.setLong(4, timeAddToCart);
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
	
	public void addWishList(String asinItem, Account account, long timeAddToWishList) {
			
			Connection connection = null;
			PreparedStatement statement = null;
			String sql = "INSERT INTO add_good_to_wishlist_and_cart(email, asin, add_to_wishlist, time_add_wishlist) VALUES(?, ?, ?, ?)";
			
			try {
				connection = ConnectionDB.getConnection();
				statement = connection.prepareStatement(sql);
				statement.setString(1, account.getEmail());
				statement.setString(2, asinItem);
				statement.setString(3, "+");
				statement.setLong(4, timeAddToWishList);
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

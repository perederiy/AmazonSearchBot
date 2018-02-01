package org.itstep.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.itstep.dao.ConnectionDB;
import org.itstep.model.Account;
import org.itstep.model.Good;
import org.itstep.service.ImitatorAmazon;

public class GoodDAO {

	public void insertGood(Good good) {
		
		Connection connection = null;
		PreparedStatement statement = null;
		String sql = "INSERT INTO good(name, url, price, asin) VALUES(?, ?, ?, ?)";
		
		try {
			connection = ConnectionDB.getConnection();
			statement = connection.prepareStatement(sql);
			statement.setString(1, good.getName());
			statement.setString(2, good.getUrl());
			statement.setString(3, good.getPrice());
			statement.setString(4, good.getAsin());
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		finally {
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

	public void deleteGood(String asinItem) {
		
		Connection connection = null;
		PreparedStatement statement = null;
		String sql = "DELETE FROM good WHERE asin = ?";
		
		try {
			connection = ConnectionDB.getConnection();
			statement = connection.prepareStatement(sql);
			statement.setString(1, asinItem);
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

	public  ArrayList<String> getASIN() {

		ArrayList<String> asinItem = new ArrayList<>();

		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		String sql = "SELECT asin FROM good";
		
		try {
			connection = ConnectionDB.getConnection();
			statement = connection.prepareStatement(sql);
			resultSet = statement.executeQuery();
			while(resultSet.next()) {
				asinItem.add(resultSet.getString("asin"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				resultSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
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
		return asinItem;
	}
}

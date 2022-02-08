package com.bridgelabz.login.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.bridgelabz.login.model.*;

public class LoginDao {

	public Connection getConnection() {
		Connection connection = null;
		try {
			String JDBCURL = "jdbc:mysql://localhost:3307/demo";
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(JDBCURL, "root", "root");
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("Driver not loaded");
		}
		return connection;
	}

	// Retrieve username and password
	public boolean retrieveUserData() {
		try (Connection connection = getConnection()) {
			PreparedStatement preparedStatement = connection
					.prepareStatement("select * from users where username = ? and password = ?");
			{
				UserLogin userLogin = new UserLogin();
				preparedStatement.setString(1, userLogin.getUsername());
				preparedStatement.setString(2, userLogin.getPassword());
				ResultSet resultset = preparedStatement.executeQuery();
				if (resultset.next())
					return true;
				resultset.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	// Insert data into registration form
	public int insertUser() {
		int result = 0;
		try (Connection connection = getConnection()) {
			PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO users"
					+ "  (id, firstname, lastname, username, password, email,  phone, address) VALUES "
					+ " (?, ?, ?, ?, ?,?,?,?);");
			{
				UserRegistration userRegister = new UserRegistration();
				preparedStatement.setInt(1, 1);
				preparedStatement.setString(2, userRegister.getFirstname());
				preparedStatement.setString(3, userRegister.getLastname());
				preparedStatement.setString(4, userRegister.getUsername());
				preparedStatement.setString(5, userRegister.getPassword());
				preparedStatement.setString(6, userRegister.getEmail());
				preparedStatement.setString(7, userRegister.getPhone());
				preparedStatement.setString(8, userRegister.getAddress());
				System.out.println(preparedStatement);
				result = preparedStatement.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
}

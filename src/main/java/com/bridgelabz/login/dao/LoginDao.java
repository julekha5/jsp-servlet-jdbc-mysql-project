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
	public String retrieveUserData(UserRegistration userLogin) {
		
		try (Connection connection = getConnection()) {
			String login = "select username = ?, password = ? from users";
			PreparedStatement preparedStatement = connection
					.prepareStatement(login);
			{
				String userName = userLogin.getUsername();
				String password = userLogin.getPassword();
		
				preparedStatement.setString(1, userName);
				preparedStatement.setString(2, password);
				
				ResultSet resultset = preparedStatement.executeQuery();
				if (resultset.next()) {
					System.out.println("Login Success");
				}else {
					System.out.println("Invalid username or password");
				}
					
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "Invalid username or password";
	}

	// Insert data into registration form
	public String insertUser(UserRegistration userRegister) {

		try (Connection connection = getConnection()) {
			String insert = "insert into users(firstname,lastname,username,password,email,phone,address)values(?,?,?,?,?,?,?)";
			PreparedStatement preparedStatement = connection.prepareStatement(insert);
			{
				String firstname = userRegister.getFirstname();
				String lastname = userRegister.getLastname();
				String username = userRegister.getUsername();
				String password = userRegister.getPassword();
				String email = userRegister.getEmail();
				String phone = userRegister.getPhone();
				String address = userRegister.getAddress();

				preparedStatement.setString(1, firstname);
				preparedStatement.setString(2, lastname);
				preparedStatement.setString(3, username);
				preparedStatement.setString(4, password);
				preparedStatement.setString(5, email);
				preparedStatement.setString(6, phone);
				preparedStatement.setString(7, address);

				System.out.println(preparedStatement);
				int result = preparedStatement.executeUpdate();

				if (result != 0) {
					System.out.println("Registered Successfully");
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "Success";
	}
}

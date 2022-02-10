package com.bridgelabz.login.controller;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.bridgelabz.login.dao.LoginDao;
import com.bridgelabz.login.model.UserRegistration;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginServlet() {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String username = request.getParameter("username");
		String password = request.getParameter("password");

		UserRegistration userRegister = new UserRegistration();
		userRegister.setUsername(username);
		userRegister.setPassword(password);

		try {
			LoginDao loginDao = new LoginDao();
			loginDao.retrieveUserData(userRegister);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/views/LoginDetails.jsp");
			dispatcher.forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

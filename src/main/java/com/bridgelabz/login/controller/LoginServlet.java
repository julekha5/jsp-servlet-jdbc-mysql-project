package com.bridgelabz.login.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bridgelabz.login.dao.LoginDao;
import com.bridgelabz.login.model.UserLogin;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private LoginDao loginDao;

	public void init() {
		loginDao = new LoginDao();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String username = request.getParameter("username");
		String password = request.getParameter("password");

		UserLogin userLogin = new UserLogin();
		userLogin.setUsername(username);
		userLogin.setPassword(password);

		try {
			if (loginDao.retrieveUserData()) {
				response.sendRedirect("loginDetails.jsp");
			} else {
				HttpSession session = request.getSession();
				session.setAttribute("username", username);
				session.setAttribute("password", password);
				response.sendRedirect("loginDetails.jsp");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

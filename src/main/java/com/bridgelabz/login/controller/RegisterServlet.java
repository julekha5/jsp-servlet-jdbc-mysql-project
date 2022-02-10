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

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
 
    public RegisterServlet() {
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {	
		String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone"); 
        String address = request.getParameter("address");
        
        UserRegistration userRegister = new UserRegistration();
        userRegister.setFirstname(firstname);
        userRegister.setLastname(lastname);
        userRegister.setUsername(username);
        userRegister.setPassword(password);
        userRegister.setEmail(email);
        userRegister.setPhone(phone);
        userRegister.setAddress(address);
             
        try {
        	LoginDao loginDao = new LoginDao();
            loginDao.insertUser(userRegister);
        } catch (Exception e) {
            e.printStackTrace();
        }
       //response.sendRedirect("../views/UserDetails.jsp");		
        RequestDispatcher dispatcher = request.getRequestDispatcher("/views/UserDetails.jsp");
    	dispatcher.forward(request, response);
	}		
}

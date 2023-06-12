package com.user.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Db.DataBaseConnection;
import com.dao.UserDao;
import com.entity.User;
@WebServlet("/UserRegister")
public class UserRegister extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try
		{
		String fullName = req.getParameter("fullname");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		
		
		User u = new User(fullName, email, password);
		
		UserDao dao = new UserDao(DataBaseConnection.getConnection());
		HttpSession session = req.getSession();
		 boolean f = dao.register(u);
		 
		 if (f) {
			 session.setAttribute("sucMsg", "Register successfully !!!");
			 resp.sendRedirect("signup_page.jsp");
			
		}
		 else
		 {
			session.setAttribute("errMsg", "Rgister failed");
			resp.sendRedirect("signup_page.jsp");
		 }
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	

}

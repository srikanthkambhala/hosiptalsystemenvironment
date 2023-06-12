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
@WebServlet("/ChangePassword")
public class ChangePassword extends HttpServlet{
   @Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	// TODO Auto-generated method stub
	int uid = Integer.parseInt(req.getParameter("uid"));
	String oldPassword = req.getParameter("oldPassword");
	String newPassword = req.getParameter("newPassword");
	
	UserDao dao = new UserDao(DataBaseConnection.getConnection());
	HttpSession session = req.getSession();
	boolean f = dao.checkOldPassword(uid, oldPassword);
	if (f) {
		if (dao.changePassword(uid, newPassword)) {
			 session.setAttribute("succMsg", "Change password successfully");
			 resp.sendRedirect("change_password.jsp");
			
		} else {
			session.setAttribute("errMsg", "Something wrong on server");
			resp.sendRedirect("change_password.jsp");

		}
		
	} else {
		session.setAttribute("errMsg", "old password Incorrect");
		resp.sendRedirect("change_password.jsp");

	}
}	
 
}

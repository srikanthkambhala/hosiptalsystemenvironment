package com.admin.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Db.DataBaseConnection;
import com.dao.DoctorDao;
import com.entity.Doctor;
@WebServlet("/AddDoctor")
public class AddDoctor extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 String fname = req.getParameter("fullname");
		 String dob = req.getParameter("dob");
		 String qualification = req.getParameter("qualification");
		 String specialist = req.getParameter("spec");
		 String email = req.getParameter("email");
		 String mobile = req.getParameter("mobno");
		 String password = req.getParameter("password");
		 
		 Doctor d = new Doctor(fname, dob, qualification, specialist, email, mobile, password);
	    
		 
		 DoctorDao dao = new DoctorDao(DataBaseConnection.getConnection());
		 HttpSession session = req.getSession();
		 boolean f =dao.insertDoctor(d);
		 if (f) {
			session.setAttribute("succMsg", "Doctor Added Successfully");
			resp.sendRedirect("admin/doctor.jsp");
			System.out.println("record inserted successfully");
		}else
		{
			session.setAttribute("errMsg", "Something wrong on server");
			resp.sendRedirect("admin/doctor.jsp");
		}
	}

}

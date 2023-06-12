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
@WebServlet("/UpdateDoctor")
public class UpdateDoctor extends HttpServlet{
    
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String fname = req.getParameter("fullname");
		 String dob = req.getParameter("dob");
		 String qualification = req.getParameter("qualification");
		 String specialist = req.getParameter("spec");
		 String email = req.getParameter("email");
		 String mobile = req.getParameter("mobno");
		 String password = req.getParameter("password");
		 int id = Integer.parseInt(req.getParameter("id"));
		 
		 Doctor d = new Doctor(id,fname, dob, qualification, specialist, email, mobile, password);
	    
		 
		 DoctorDao dao = new DoctorDao(DataBaseConnection.getConnection());
		 HttpSession session = req.getSession();
		 boolean f =dao.updateDoctor(d);
		 if (f) {
			session.setAttribute("succMsg", "Doctor Updated  Successfully");
			resp.sendRedirect("admin/view_doctor.jsp");
			System.out.println("record updated successfully");
		}else
		{
			session.setAttribute("errMsg", "Something wrong on server");
			resp.sendRedirect("admin/view_doctor.jsp");
		}
	}
}

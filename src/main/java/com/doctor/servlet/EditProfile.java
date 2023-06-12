package com.doctor.servlet;

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
@WebServlet("/EditProfile")
public class EditProfile extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String fname = req.getParameter("fullname");
		 String dob = req.getParameter("dob");
		 String qualification = req.getParameter("qualification");
		 String specialist = req.getParameter("spec");
		 String email = req.getParameter("email");
		 String mobile = req.getParameter("mobno");
		 int id = Integer.parseInt(req.getParameter("id"));
	     Doctor d = new Doctor(id, fname, dob, qualification, specialist, email, mobile);
	     DoctorDao dao = new DoctorDao(DataBaseConnection.getConnection());
		 HttpSession session = req.getSession();
		 boolean f =dao.editDoctorProfile(d);
		 if (f) {
			 Doctor update = dao.getDoctorById(id);
			session.setAttribute("succMsgGd", "Doctor profile Updated  Successfully");
			session.setAttribute("docObj", update);
			resp.sendRedirect("doctor/edit_profile.jsp");
			
		}else
		{
			session.setAttribute("errMsgGd", "Something wrong on server");
			resp.sendRedirect("doctor/edit_profile.jsp");
		}
	}

}

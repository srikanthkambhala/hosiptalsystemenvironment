package com.user.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Db.DataBaseConnection;
import com.dao.AppointmentDao;
import com.entity.Appointment;
@WebServlet("/AppointmentServlet")
public class AppointmentServlet extends HttpServlet{
  @Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	// TODO Auto-generated method stub
	String temp = req.getParameter("userid");
	int userId = Integer.parseInt(temp);
	String fname = req.getParameter("fullname");
	String gender = req.getParameter("gender");
	String age = req.getParameter("age");
	String appint_date = req.getParameter("appoint_date");
	String email = req.getParameter("email");
	String phoneNo = req.getParameter("phno");
	String diseases = req.getParameter("diseases");
	int doctorId = Integer.parseInt(req.getParameter("doct"));
	String address = req.getParameter("address");
	
	Appointment ap = new Appointment(userId, fname, gender, age, appint_date, email, phoneNo, diseases, doctorId, address, "pending");
	
	AppointmentDao dao = new AppointmentDao(DataBaseConnection.getConnection());
	HttpSession session = req.getSession();
	boolean f = dao.addAppointment(ap);
	if (f) {
		session.setAttribute("succMsg", "appointment successfully ");
		resp.sendRedirect("User_Appointment.jsp");
	} else {
        session.setAttribute("errMsg", "something wrong on server");
        resp.sendRedirect("User_Appointment.jsp");
	}
	
	
}
}

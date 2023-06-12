package com.doctor.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Db.DataBaseConnection;
import com.dao.AppointmentDao;
@WebServlet("/UpdateStatus")
public class UpdateStatus extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(req.getParameter("id"));
		int did = Integer.parseInt(req.getParameter("did"));
		String comm = req.getParameter("comm");
		HttpSession session = req.getSession();
		AppointmentDao dao = new AppointmentDao(DataBaseConnection.getConnection());
		boolean f = dao.updateCommentStatus(id, did, comm);
		
		if (f) {
			session.setAttribute("succMsg", "comment updated");
			resp.sendRedirect("doctor/Patient.jsp");
			
		} else {
			session.setAttribute("errMsg", "something wrong on server");
			resp.sendRedirect("doctor/Patient.jsp");
		}
	}

}

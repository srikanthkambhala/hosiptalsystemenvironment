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
@WebServlet("/DeleteDoctor")
public class DeleteDoctor extends HttpServlet{
       @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	// TODO Auto-generated method stub
    	int id =Integer.parseInt(req.getParameter("id"));
    	
    	DoctorDao dao = new DoctorDao(DataBaseConnection.getConnection());
		 HttpSession session = req.getSession();
		 boolean f =dao.deleteDoctor(id);
		 if (f) {
			session.setAttribute("succMsg", "Doctor Record delete Successfully");
			resp.sendRedirect("admin/view_doctor.jsp");
			System.out.println("record inserted successfully");
		}else
		{
			session.setAttribute("errMsg", "Something wrong on server");
			resp.sendRedirect("admin/view_doctor.jsp");
		}
    }
}

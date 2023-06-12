package com.admin.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Db.DataBaseConnection;
import com.dao.SpecialistDao;
@WebServlet("/AddSpecialist")
public class AddSpecialist extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String specName = req.getParameter("specName");
		
		SpecialistDao dao = new SpecialistDao(DataBaseConnection.getConnection());
		boolean f = dao.addSpecialist(specName);
		HttpSession session = req.getSession();
		if (f) {
			session.setAttribute("succMsg", "Specialist added");
			resp.sendRedirect("admin/index.jsp");
			
		} else {
			session.setAttribute("errMsg", "something wrong on server");
			resp.sendRedirect("admin/index.jsp");

		}
	}

}

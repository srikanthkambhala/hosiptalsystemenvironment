<%@page import="com.entity.Appointment"%>
<%@page import="java.util.List"%>
<%@page import="com.Db.DataBaseConnection"%>
<%@page import="com.dao.AppointmentDao"%>
<%@page import="com.entity.Doctor"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Patient</title>
<style type="text/css">
 .card paint-card
 {
    box-shadow: 0 0 10px 0 rgba(0,0,0,e.3);
 }
</style>
<%@include file="../component/allcss.jsp" %>
</head>
<body>
     <c:if test="${empty docObj }">
        <c:redirect url="../Doctor_Login.jsp"></c:redirect>
   </c:if>

<%@include file="navbar.jsp" %>

<div class="container p-3">
		<div class="row">

			<div class="col-md-12">
				<div class="card paint-card">
					<div class="card-body">
						<p class="fs-3 text-center">Patient Details</p>
						<c:if test="${not empty errMsg}">
							<p class="fs-4 text-center text-danger">${errMsg}</p>
							<c:remove var="errMsg" scope="session" />
						</c:if>
						<c:if test="${not empty succMsg}">
							<p class=" fs-4 text-center text-success">${succMsg}</p>
							<c:remove var="succMsg" scope="session" />
						</c:if>

						<table class="table">
							<thead>
								<tr>
									<th scope="col">Full Name</th>
									<th scope="col">Gender</th>
									<th scope="col">Age</th>
									<th scope="col">Appointment Date</th>
									<th scope="col">Email</th>
									<th scope="col">Mob No</th>
									<th scope="col">Diseases</th>
									<th scope="col">Status</th>
									<th scope="col">Action</th>
								</tr>
							</thead>
							<tbody>
								<%
								Doctor d = (Doctor) session.getAttribute("docObj");
								AppointmentDao dao = new AppointmentDao(DataBaseConnection.getConnection());
								List<Appointment> list = dao.getAllAppointByDoctorLogin(d.getId());
								for (Appointment ap : list) {
								%>
								<tr>
									<th><%=ap.getFullName()%></th>
									<td><%=ap.getGender()%></td>
									<td><%=ap.getAge()%></td>
									<td><%=ap.getAppointmentDate()%></td>
									<td><%=ap.getEmail()%></td>
									<td><%=ap.getPhoneNo()%></td>
									<td><%=ap.getDiaeases() %></td>
									<td><%=ap.getStatus()%></td>
									<td>
									   <%
									       if("pending".equals(ap.getStatus()))
									       {
									   %>
										<a href="comment.jsp?id=<%=ap.getId()%>"
										class="btn btn-success btn-sm">Comment</a>
										<%
									       }else
									       {
									    	
									       %>
									       <a href="#" class="btn btn-success btn-sm disabled">comment </a>
									      <%
									       }
									      %>
									</td>
								</tr>
								<%
								}
								%>



							</tbody>
						</table>

					</div>
				</div>
			</div>

		</div>
	</div>


</body>
</html>
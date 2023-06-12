<%@page import="com.entity.Specalist"%>
<%@page import="java.util.List"%>
<%@page import="com.Db.DataBaseConnection"%>
<%@page import="com.dao.SpecialistDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>edit profile</title>
<style type="text/css">
 .card paint-card
 {
    box-shadow: 0 0 10px 0 rgba(0,0,0,0.3);
 }
</style>
<%@include file="../component/allcss.jsp" %>
</head>
<body>
       
      <c:if test="${empty docObj }">
         <c:redirect url="../Doctor_Login.jsp"></c:redirect>
     </c:if>

    <%@include file="navbar.jsp" %>
    
   <div class="container p-4">
		<div class="row">
			<div class="col-md-4 offset-md-4" style="margin-left: 10px;">
				<div class="card paint-card">
					<p class="text-center fs-3">Change Password</p>
					<c:if test="${not empty succMsg }">
						<p class="text-center text-success fs-3">${succMsg}</p>
						<c:remove var="succMsg" scope="session" />
					</c:if>

					<c:if test="${not empty errMsg }">
						<p class="text-center text-danger fs-5">${errMsg}</p>
						<c:remove var="errMsg" scope="session" />
					</c:if>
					<div class="card-body">
						<form action="../ChangeDoctorPassword" method="post">
							<div class="mb-3">
								<label>Enter New Password</label> <input type="text"
									name="newPassword" class="form-control" required>
							</div>

							<div class="mb-3">
								<label>Enter Old Password</label> <input type="text"
									name="oldPassword" class="form-control" required>
							</div>
							<input type="hidden" value="${docObj.id }" name="did">
							<button class="btn btn-success col-md-12">Change
								Password</button>
						</form>
					</div>
				</div>
			
			</div>
			
			<div class="col-md-5 offset-md-2">
			   <div class="card paint-card">
			        <p class="text-center fs-3">Edit Profile</p>
			        <c:if test="${not empty succMsgGd }">
						<p class="text-center text-success fs-3">${succMsgGd}</p>
						<c:remove var="succMsgGd" scope="session" />
					</c:if>

					<c:if test="${not empty errMsgGd }">
						<p class="text-center text-danger fs-5">${errMsgGd}</p>
						<c:remove var="errMsgGd" scope="session" />
					</c:if>
			       <div class="card-body">
			           <form action="../EditProfile"  method="post">
							<div class="mb-3">
								<label class="form-label">Full Name</label> <input type="text"
									required name="fullname" class="form-control" value="${docObj.fullName }">
							</div>

							<div class="mb-3">
								<label class="form-label">DOB</label> <input type="date"
									required name="dob" class="form-control" value="${docObj.dob }">
							</div>

							<div class="mb-3">
								<label class="form-label">Qualification</label> <input required
									name="qualification" type="text" class="form-control" value="${docObj.qualification}">
							</div>
							<div class="mb-3">
								<label class="form-label">Specialist</label> <select name="spec"
									required class="form-control" >
									<option>${docObj.specialist}</option>

									<%
									SpecialistDao dao = new SpecialistDao(DataBaseConnection.getConnection());
									List<Specalist> list = dao.getAllSpecialist();
									for (Specalist s : list) {
									%>
									<option><%=s.getSpecialistName()%></option>
									<%
									}
									%>


								</select>
							</div>

							<div class="mb-3">
								<label class="form-label">Email</label> <input type="text"
								 readonly	required name="email" class="form-control" value="${docObj.email}">
							</div>

							<div class="mb-3">
								<label class="form-label">Mob No</label> <input type="text"
									required name="mobno" class="form-control" value="${docObj.mobNo}">
							</div>

							 <input type="hidden" name="id" value="${docObj.id }">

							<button type="submit" class="btn btn-primary">Update</button>
						</form>
			       </div>
			   </div>
			</div>
			
		</div>
	</div>
   
</body>
</html>
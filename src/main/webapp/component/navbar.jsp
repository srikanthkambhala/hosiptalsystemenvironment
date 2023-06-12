<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<nav class="navbar navbar-expand-lg navbar-dark bg-success">
  <div class="container-fluid">
    <a class="navbar-brand" href="index.jsp"><i class="fa-solid fa-house-chimney-medical"></i>Medi Home</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav ms-auto mb-2 mb-lg-0">
      <c:if test="${empty userObj }">
        
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="Admin_Login.jsp"><i class="fa-solid fa-right-to-bracket"></i>ADMIN</a>
        </li>
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="Doctor_Login.jsp">DOCTOR</a>
        </li>
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="User_Appointment.jsp">APPOINTMENT</a>
        </li>
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="User_Login.jsp">USER</a>
        </li>
      
      
      </c:if>
        
        
        
        <c:if test="${not empty userObj }">
        
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="User_Appointment.jsp">APPOINTMENT</a>
        </li>
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="View_Appiontment.jsp">VIEW APPOINTMENT</a>
        </li>
        
        
    <div class="dropdown">
      <button class="btn btn-success dropdown-toggle" type="button" id="dropdownMenuButton1" data-bs-toggle="dropdown" aria-expanded="false">
        <i class="fa-sharp fa-solid fa-circle-user"></i> ${userObj.fname }
      </button>
      <ul class="dropdown-menu" aria-labelledby="dropdownMenuButton1">
          <li><a class="dropdown-item" href="change_password.jsp">Change Password</a></li>
          <li><a class="dropdown-item" href="UserLogout">Logout</a></li>
          
      </ul>
   </div>
    
     </c:if>
       
      </ul>
      
    </div>
  </div>
</nav>
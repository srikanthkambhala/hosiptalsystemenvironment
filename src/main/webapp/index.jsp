<%@page import="com.Db.DataBaseConnection"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>index page</title>
<%@ include file="component/allcss.jsp" %>
<style type="text/css">
 .card paint-card
 {
    box-shadow: 0 0 10px 0 rgba(0,0,0,e.3);
 }
</style>
</head>
<body>
  <%@ include file="component/navbar.jsp" %>
  <% Connection connect = DataBaseConnection.getConnection(); %>
   <%= connect %>
  
  <div id="carouselExampleIndicators" class="carousel slide" data-bs-ride="carousel">
  <div class="carousel-indicators">
    <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
    <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="1" aria-label="Slide 2"></button>
    <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="2" aria-label="Slide 3"></button>
  </div>
  <div class="carousel-inner">
    <div class="carousel-item active">
      <img src="img/hos1.jpg" class="d-block w-100" alt="..." height="500px">
    </div>
    <div class="carousel-item">
      <img src="img/hos2.jpg" class="d-block w-100" alt="..." height="500px">
    </div>
    <div class="carousel-item">
      <img src="img/hos3.jpg" class="d-block w-100" alt="..." height="500px">
    </div>
  </div>
  <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide="prev">
    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
    <span class="visually-hidden">Previous</span>
  </button>
  <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide="next">
    <span class="carousel-control-next-icon" aria-hidden="true"></span>
    <span class="visually-hidden">Next</span>
  </button>
</div>

   <div class="container p-3">
     <p class="text- container fs-2" style="margin-left:150px ">Key Features Of Our Hospital</p>
     
     <div class="row">
      <div class="col-md-8 p-5">
       <div class="row">
       <div class="col-md-6">
         <div class="card paint-card">
           <div class="card-body">
              <p class="fs-5">100% Safety</p>
              <p>Loram ipsum dolor sit amet, consecutor adipisicing elit.
                 Voluptatem, inventore</p>
           </div>
         </div>
       </div>
       <div class="col-md-6">
           <div class="card paint-card">
               <div class="card-body">
               <p class="fs-5">Clean Environment</p>
               <p>Loram ipsum dolor sit amet, consecutor adipisicing elit.
                 Voluptatem, inventore</p>
              </div>
           </div>
       </div>
       <div class="col-md-6">
           <div class="card paint-card">
               <div class="card-body">
               <p class="fs-5">Friendly Doctors</p>
               <p>Loram ipsum dolor sit amet, consecutor adipisicing elit.
                 Voluptatem, inventore</p>
              </div>
           </div>
       </div>
       <div class="col-md-6">
           <div class="card paint-card">
               <div class="card-body">
               <p class="fs-5">Medical Research</p>
               <p>Loram ipsum dolor sit amet, consecutor adipisicing elit.
                 Voluptatem, inventore</p>
              </div>
           </div>
       </div>
       
       </div>
      </div>
           <div class="col-md-4" style="margin-top: 50px;">
              <img alt="" src="img/doct.jpg">
           </div>
     </div>
   </div>
   
   <hr>
   
   <div class="container p-2">
       <p class="text-center fs-2">Our Team</p>
       <div class="row">
         <div class="col-md-3">
          <div class="card point-card">
            <div class="card-body text-center" >
                <img alt="" src="img/doct2.jpg" width="250px" height="300px">
                <p class="fw-bold fs-5">Mr.Daniel</p>
                <p class="fs-7">(CEO & Chairman)</p>
            </div>
          </div>
         </div>
         
         <div class="col-md-3">
          <div class="card point-card">
            <div class="card-body text-center" >
                <img alt="" src="img/doct3.jpg" width="250px" height="300px">
                <p class="fw-bold fs-5">Mr.Michel</p>
                <p class="fs-7">(Cheif Doctor)</p>
            </div>
          </div>
         </div>
         <div class="col-md-3">
          <div class="card point-card">
            <div class="card-body text-center" >
                <img alt="" src="img/doct1.jpg" width="250px" height="300px">
                <p class="fw-bold fs-5">Mrs.jennifer</p>
                <p class="fs-7">(Cheif Doctor)</p>
            </div>
          </div>
         </div>
         <div class="col-md-3">
          <div class="card point-card">
            <div class="card-body text-center" >
                <img alt="" src="img/doct4.jpg" width="250px" height="300px">
                <p class="fw-bold fs-5">Mr.rajashekar</p>
                <p class="fs-7">(Cheif Doctor)</p>
            </div>
          </div>
         </div>
       </div>
   </div>

<%@ include file="component/footer.jsp" %>
</body>
</html>
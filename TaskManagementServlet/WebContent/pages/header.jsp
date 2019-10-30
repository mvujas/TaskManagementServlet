<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
   <script src="/TaskManagementServlet/js/jquery-3.4.1.min.js"></script>
    <script src="/TaskManagementServlet/js/bootstrap.min.js"></script> 
   <script src="/TaskManagementServlet/js/mdb.min.js"></script> 
<meta charset="UTF-8">
  <!-- Font Awesome -->
  <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.11.2/css/all.css">
  <!-- Bootstrap core CSS -->
  <link href="/TaskManagementServlet/css/bootstrap.min.css" rel="stylesheet">
  <!-- Material Design Bootstrap -->
  <link href="/TaskManagementServlet/css/mdb.min.css" rel="stylesheet">
  <!-- Your custom styles (optional) -->
  <link href="/TaskManagementServlet/css/style.css" rel="stylesheet">
<title>Projekat iz razvoja informacionih sistema</title>
</head>
<!--Navbar-->
<nav class="navbar navbar-expand-lg navbar-dark default-color">


  <!-- Collapse button -->
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#basicExampleNav"
    aria-controls="basicExampleNav" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <!-- Collapsible content -->
  <div class="collapse navbar-collapse" id="basicExampleNav">

    <!-- Links -->
     
    <ul class="navbar-nav mr-auto">
    <c:if test="${not empty logedUser}">
      <li class="nav-item ">
        <a class="nav-link" href="/TaskManagementServlet/pages/home.jsp">Home
        </a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#">Projekti</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="http://localhost:8080/TaskManagementServlet/UserServlet">Radnici</a>
      </li>
 </c:if>
    </ul>
   
    <!-- Links -->
  <span class="navbar-text white-text">
  <c:choose>
  <c:when test="${empty logedUser}">
     <a href="/TaskManagementServlet/login.jsp" class="nav-link">Prijava</a>
   </c:when>
   <c:otherwise>
     <a href="http://localhost:8080/TaskManagementServlet/LoginServlet?action=logout" class="nav-link" >Odjava</a>
   </c:otherwise>
     </c:choose>
    </span>
  </div>
  <!-- Collapsible content -->

</nav> 

<!-- MODAL -->

</html>
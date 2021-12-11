<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="icon" href="../../favicon.ico">

    <title>Home</title>

    <!-- Bootstrap core CSS -->
    <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="<c:url value="/resources/css/custom.css" />" rel="stylesheet">
    
    <!-- Bootstrap core CSS -->
    <link href="<c:url value="/resources/css/jquery-ui.css" />" rel="stylesheet">
    
    <script src="<c:url value="/resources/js/jquery-2.1.4.min.js" />"></script>
    <script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
    <script src="<c:url value="/resources/js/jquery-ui.js" />"></script>
   
  </head>

  <body>

   <div class="container">

      <!-- Static navbar -->
      <nav class="navbar navbar-default">
        <div class="container-fluid">
          <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
              <span class="sr-only">Toggle navigation</span>
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">GYAN</a>
          </div>
          <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
              <li class="active"><a href="<c:url value="/home" />">Home</a></li>
              <sec:authorize access="hasRole('ROLE_ADMIN')">
              <li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">User<span class="caret"></span></a>
                <ul class="dropdown-menu">
                  <li><a href="<c:url value="/addEmp" />">Add Emp</a></li>
                  <li><a href="<c:url value="/viewAllEmp" />">View Emp</a></li>
                  <li><a href="<c:url value="/addStudent" />">Add Student</a></li>
                  <li><a href="<c:url value="/viewAllStudent" />">View Student</a></li>
                 </ul>
              </li>
              <li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Batch <span class="caret"></span></a>
                <ul class="dropdown-menu">
                  <li><a href="<c:url value="/addBatch" />">Add Batch</a></li>
                  <li><a href="<c:url value="/viewAllBatch" />">View Batch</a></li>
                </ul>
              </li>
              <li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Term <span class="caret"></span></a>
                <ul class="dropdown-menu">
                  <li><a href="<c:url value="/addTerm" />">Add Term</a></li>
                  <li><a href="<c:url value="/viewAllTerms" />">View Term</a></li>
                </ul>
              </li>
               </sec:authorize>
              <sec:authorize access="hasRole('ROLE_ADMIN')"> 
             <li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Subject <span class="caret"></span></a>
                <ul class="dropdown-menu">
                  <li><a href="<c:url value="/addSubject" />">Add Subject</a></li>
                  <li><a href="<c:url value="/viewAllSubject" />">View Subjects</a></li>
                </ul>
              </li>
               </sec:authorize>
              <sec:authorize access="hasRole('ROLE_ADMIN')">
               <li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Registration <span class="caret"></span></a>
                <ul class="dropdown-menu">
                  <li><a href="<c:url value="/openReg" />">Open</a></li>
                  <li><a href="<c:url value="/viewReg" />">View</a></li>
                  <li><a href="<c:url value="/srhRegInfo" />">Search By Bank</a></li>
                  <li><a href="<c:url value="/srhRegOfUser" />">Search By User</a></li>
                 </ul>
              </li>
              </sec:authorize>
              <li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Student Area <span class="caret"></span></a>
                <ul class="dropdown-menu">
                  <li><a href="<c:url value="/viewRegFormInfo" />">Submit</a></li>
                  <%-- <li><a href="<c:url value="/myDetails" />">My Details</a></li> --%>
                </ul>
              </li>
              <li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Profile<span class="caret"></span></a>
                <ul class="dropdown-menu">
                  <li><a href="<c:url value="/logout" />">Logout</a></li>
                 </ul>
              </li>
            </ul>
           </div>
        </div>
      </nav>

  <!--    

    </div> 


 
  </body>
</html>
 -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="com.dto.User" import="java.util.List" import="java.util.ArrayList"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>USERHOME</title>
<style>
ul {
  list-style-type: none;
  margin: 0;
  padding: 0;
  overflow: hidden;
  background-color: #EEE8AA	;
}

li {
  float: left;
}

li a {
  display: block;
  color: black;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
}

li a:hover:not(.active) {
  background-color: #FFD700;
}

.active {
  background-color: #FF6347;
}
</style>
<style>
body {
  font-family: Times New Roman;
}

.navbar {
  overflow: hidden;
  background-color: #233;
}

.navbar a {
  float: left;
  font-size: 16px;
  color: white;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
}

.dropdown {
  float: left;
  overflow: hidden;
}

.dropdown .dropbtn {
  font-size: 16px;  
  border: none;
  outline: none;
  color: white;
  padding: 14px 16px;
  background-color: inherit;
  font-family: inherit;
  margin: 0;
}

.navbar a:hover, .dropdown:hover .dropbtn {
  background-color: MediumTurquoise;
}

.dropdown-content {
  display: none;
  position: absolute;
  background-color: #f9f9f9;
  min-width: 160px;
  box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
  z-index: 1;
}

.dropdown-content a {
  float: none;
  color: black;
  padding: 12px 16px;
  text-decoration: none;
  display: block;
  text-align: left;
}

.dropdown-content a:hover {
  background-color: #ddd;
}

.dropdown:hover .dropdown-content {
  display: block;
}
</style>
<style>
.shadow {
  box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2);
}

body {
  font-family: Arial;
}



/* Create two columns/boxes that floats next to each other */


article {
  float: center;
  padding: 20px;
  width: 96.5%;
  background-color: Snow;
  height: 200px; /* only for demonstration, should be removed */
}

/* Clear floats after the columns */
section:after {
  content: "";
  display: table;
  clear: both;
}

/* Style the footer */
footer {
  background-color: NavajoWhite;
  padding: 5px;
  text-align: center;
  color: white;
}

/* Responsive layout - makes the two columns/boxes stack on top of each other instead of next to each other, on small screens */
@media (max-width: 600px) {
  nav, article {
    width: 99%;
    height: auto;
  }
}
</style>
<style>
.center {
  margin: auto;
  width: 70%;
  border: none;
  padding: 13px;
}
</style>
</head>
<body>
	<ul>
	<li><font face = "Chiller" size = "5">&nbsp;&nbsp;ACADEMIC GURU</font></li>
		<li><div class="dropdown">
    <button class="dropbtn">MENU 
      <i class="fa fa-caret-down"></i>
    </button>
    <div class="dropdown-content">
      <a href="DisplayWorkshopPostsServlet">WORKSHOPS</a>
      <a href="DisplayRecruitmentPostsServlet">RECRUITMENT</a>
      <a href="DisplayTrainingProgramsPostsServlet">TRAINING PROGRAMS</a>
      <a href="DisplaySubjectPostsServlet">SUBJECTS</a>
    </div>
  </div> </li>
		<li><a href="DisplayAllPostsServlet">HOME</a></li>
		<li><a href="Ask.jsp">ASK</a></li>
		<li style="float:right"><a href="Profile.jsp"><%
		String userName = (String) session.getAttribute("loginId");
	%>
		<%=userName%></a></li>
		</ul>&nbsp;&nbsp;
		
		<div class="center">
		
		<h1>Welcome <%=userName %>. </h1></br>
		<h1>Let's check out the queries waiting for your answers. Go to HOME to post answers</h1></br></br>
		<h1>Have a doubt? Come and post it in the ASK to clarify.</h1>
		
	<!--  <section action="UserHomePage.jsp">
  
</section>
<footer>
  <div class="shadow">
  <form>
    <input type="submit" value="Show Answers" formaction="/submit/a">&nbsp;&nbsp;&emsp;&emsp;&emsp;&emsp;
    <input type="submit" value="Post Answer" formaction="/submit/b">    
</form></div>
</footer>-->
</div>
&nbsp;

</body>
</html>
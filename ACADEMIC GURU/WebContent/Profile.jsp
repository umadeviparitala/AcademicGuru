<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="com.dto.User" %>
	<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>PROFILE</title>
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
</style><style>

label, input {
    display: inline-block;
    vertical-align: baseline;
    width: 125px;
}

label {
    color: #2D2D2D;
    font-size: 15px;
}

form, input {
    box-sizing: border-box;
    -moz-box-sizing: border-box;
    -webkit-box-sizing: border-box;
}

form {
    width: 300px;
}</style>
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
		</ul><br/>
		
		<center><h1><%=userName%>'s Profile</h1></center>
	<%HttpSession httpSession = request.getSession(); %>
		<% User user = (User)httpSession.getAttribute("user"); %>
	
	<center>
	
			<form action="EditProfileServlet" method="post">
		    <label for="firstName">FIRSTNAME:</label><input type="textarea" name="firstName" value="<%=user.getFirstName() %>"><br/><br/>
		    <label for="lastName">LASTNAME:</label><input type="text" name="lastName" value="<%=user.getLastName() %>"><br/><br/>
		    <label for="userName">USERNAME:</label><input type="text" name="userName" value="<%=user.getUserName() %>"><br/><br/>
		    <label for="mailId">MAILID:</label><input type="text" name="mailId" value="<%=user.getMailId() %>"><br/><br/>
		    <label for="password">PASSWORD:</label><input type="password" name="password" value="<%=user.getPassword() %>"><br/><br/>
		    <input type="submit" value="Save changes"><br/><br/>
		    
		</form>
		    </center>
		
</body>
</html>
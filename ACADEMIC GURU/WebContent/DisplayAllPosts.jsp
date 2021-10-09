<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="com.dto.UserPosts, java.util.List"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>BLOG</title>

<script type="text/javascript"
	src='https://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.8.3.min.js'></script>
<script type="text/javascript"
	src='https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.0.3/js/bootstrap.min.js'></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js">
</script>
<!-- <link rel="stylesheet"
	href='https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.0.3/css/bootstrap.min.css'
	media="screen" /> -->
<style>
ul {
	list-style-type: none;
	margin: 0;
	padding: 0;
	overflow: hidden;
	background-color: #EEE8AA;
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
	background-color: #FFD700
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
	box-shadow: 0px 8px 16px 0px rgba(0, 0, 0, 0.2);
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
@media ( max-width : 600px) {
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
<style>
#customers {
	font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
	border-collapse: collapse;
	width: 75%;
}

#customers td, #customers th {
	border: 1px solid #ddd;
	padding: 8px;
}

#customers tr:nth-child(even) {
	background-color: #f2f2f2;
}

#customers tr:hover {
	background-color: #ddd;
}

#customers th {
	padding-top: 12px;
	padding-bottom: 12px;
	text-align: left;
	background-color: #EEE8AA;
	color: black;
}
</style>
</head>
<body>
	<ul>
		<li><font face="Chiller" size="5">&nbsp;&nbsp;ACADEMIC
				GURU</font></li>
		<li><div class="dropdown">
				<button class="dropbtn">
					MENU <i class="fa fa-caret-down"></i>
				</button>
				<div class="dropdown-content">
					<a href="DisplayWorkshopPostsServlet">WORKSHOPS</a> <a
						href="DisplayRecruitmentPostsServlet">RECRUITMENT</a> <a
						href="DisplayTrainingProgramsPostsServlet">TRAINING PROGRAMS</a> <a
						href="DisplaySubjectPostsServlet">SUBJECTS</a>
				</div>
			</div></li>
		<li><a href="DisplayAllPostsServlet">HOME</a></li>
		<li><a href="Ask.jsp">ASK</a></li>
		<li style="float: right"><a href="Profile.jsp"> <%
		String userName = (String) session.getAttribute("loginId");
	%> <%=userName%></a></li>
	</ul>
	&nbsp;&nbsp;
	<style>

/* Style the counter cards */
.card {
	box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2);
	padding: 12px 30px;
	text-align: center;
	widht: 100px;
	height: 100px;
	background-color: #f1f1f1;
}
</style>
</head>
<body>
<center><h2><font face="Times New Roman">ALL CATEGORIES</font></h2></center>
	<%
		List<UserPosts> postsList = (List<UserPosts>) request.getAttribute("postsList");
	%>
	<!-- <table align=center border=2>
			<tr><th>USERNAME</th><th>QUERY</th><th>CATEGORY</th></tr> --><center>
	<table id="customers">
		<tr>
			<th><b>USER</b></th>
			<th><b>CATEGORY</b></th>
			<th><b>QUERY</b></th>
			<th><b>SHOW</b></th>
			<th><b>POST</b></th>
		</tr>
		<%
			for (UserPosts userPosts : postsList) {
		%>
		<tr>
			<td><%=userPosts.getUserName()%></td>
			<td><%=userPosts.getCategory()%></td>
			<td><%=userPosts.getQuery()%></td>
			
			<td><form action="ShowAnswersServlet"><input type="submit" value="Show Answers"></form></td>
			<td><form action="PostAnswer.jsp?"><input type="submit" value="Post Answer"></form></td>
		</tr>

		<!-- <div class="card" style="width: 100rem;">
			<div class="card-body">
				<h5 class="card-title">
					<b> By </b>
				</h5>
				<p class="card-text">
					<b>CATEGORY:</b>
					 <b>QUERY: </b></p>
				<button type="button" data-id="${userPosts.getQuery() }" data-toggle="modal" data-target="#ShowAnswers">Show
					Answers</button>
				&nbsp;&nbsp;&emsp;&emsp;&emsp;&emsp;
				<button type="button" data-toggle="modal" data-target="#PostAnswer">
					Post Answer</button>
			</div>
		</div> -->
		<!-- Modal Popup -->
		<!-- <div id="PostAnswer" class="modal fade" role="dialog">
			<div class="modal-dialog"> -->
		<!-- Modal content-->
		<!-- <div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">
							&times;</button>
						<h4 class="modal-title">Post your Answer here</h4>
					</div>
					<div class="modal-body">
						<textarea rows="4" cols="50" name="answer" id="answer"
							style="margin: 33px 0px 0px; width: 397px; height: 300px"
							placeholder="Enter text here..." required="required"></textarea>
					</div>
					<div class="modal-footer">
						<a href='PostAnswerServlet&id='>Post</a>
					</div>
				</div>
			</div>
		</div> -->
		<!-- Modal Popup -->
		<!-- show popup -->
		<!-- <div id="ShowAnswers" class="modal fade" role="dialog">
			<div class="modal-dialog"> -->
		<!-- Modal content
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">
							&times;</button>
						<h4 class="modal-title">
							<b>QUERY: </b></h4>
					</div>
					<div class="modal-body"></div>
					<div class="modal-footer">
						<button type="button" class="btn btn-danger" class="close" data-dismiss="modal">
							close</button>
					</div>
				</div>
			</div>
		</div>-->
		<!-- show popup -->


		<%
			}
		%>
	</table>
</center>

	<!-- <a href="javaScript:{openPopUp();}"></a> 
<form action="actionName"> 
<div id="divId" style="display:none;"> 
UsreName:<input type="text" name="userName"/> 
</div> 
</form> 
 <script>
function openPopUp() 
{ 
  $('#divId').css('display','block'); 
$('#divId').dialog(); 
} </script>
 -->
	<script type="text/javascript">
		$(function() {
			$("#btnClosePopup").click(function() {
				$("#PostAnswer").modal("hide");
			});
		});
	</script>
	<script type="text/javascript">
		$(function() {
			$("#btnClosePopup").click(function() {
				$("#ShowAnswers").modal("hide");
			});
		});
	</script>


</body>


</html>
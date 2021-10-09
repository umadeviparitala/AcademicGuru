<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="com.dto.UserPosts, java.util.List"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>PostAnswer</title>
</head>
<body>
	<center><h1>
		<font face="Chiller">ACADEMIC GURU</font>
	</h1></center>
	<center>
		<br />
		<h2>Please Post your Answer here for the question</h2>
		<form action="PostAnswerServlet" method="post">
			<textarea rows="4" cols="50" name="answer" id="answer"
				style="margin: 33px 0px 0px; width: 397px; height: 300px"
				placeholder="Enter Answer here..." required="required"></textarea>
			<br /> <br /> <input type="submit" value="Post"><br />
		</form>
		</br>
	</center>
</body>
</html>
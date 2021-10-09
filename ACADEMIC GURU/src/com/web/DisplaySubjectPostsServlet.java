package com.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.text.html.HTMLDocument.Iterator;

import com.dao.UserDAO;
import com.dao.UserPostsDAO;
import com.dto.User;
import com.dto.UserPosts;

@WebServlet("/DisplaySubjectPostsServlet")
public class DisplaySubjectPostsServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		UserPostsDAO userPostsDAO = new UserPostsDAO();
		List<UserPosts> postsList = new ArrayList<UserPosts>(); //List is parent of all child classes.  
		postsList = userPostsDAO.getSubjectPosts(); //so it can accept any child class returned like array list,vector, linked list.

		if(!postsList.isEmpty()) {
			System.out.println("Exists");
			request.setAttribute("postsList", postsList);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("DisplaySubjectPosts.jsp");
			requestDispatcher.forward(request, response);
			
			
			/*while(iterator.hasNext()){
				Employee employee = new Employee();
				employee = iterator.next();*/
			

		} else {
			out.println("<body>");
			out.println("<h1><center>NO RECORDS AVAILABLE :(</center></h1>");
			out.println("</body>");
			System.out.println("Empty");

			RequestDispatcher requestDispatcher = request.getRequestDispatcher("DisplayAllPosts.jsp");
			requestDispatcher.include(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}

package com.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.UserDAO;
import com.dto.User;

@WebServlet("/EditProfileServlet")
public class EditProfileServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String userName = request.getParameter("userName");
		String mailId = request.getParameter("mailId");
		String password = request.getParameter("password");
		//System.out.println(loginId+" "+password);

		User user = new User(firstName, lastName, userName, mailId, password);

		UserDAO userDAO = new UserDAO();
		int result = userDAO.update(user);

		if(result > 0) {
			
			out.println("<body>");
			out.println("<h1><center>SUCCESFULLY UPDATED :)</center></h1>");
			out.println("</body>");

			request.setAttribute("result", result);
			//session.setAttribute("user", user);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("Profile.jsp");
			requestDispatcher.include(request, response);
			
		} else{
			
			out.println("<body>");
			out.println("<h1><center>UPDATION FAILED. TRY AGAIN :(</center></h1>");
			out.println("</body>");

			RequestDispatcher requestDispatcher = request.getRequestDispatcher("Profile.jsp");
			requestDispatcher.include(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

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


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String userName = request.getParameter("loginId");
		String password = request.getParameter("password");
		//System.out.println(loginId+" "+password);
		HttpSession httpSession = request.getSession();
		httpSession.setAttribute("loginId", userName);
		
		out.println("<html>");

			UserDAO userDAO = new UserDAO();
			User user = userDAO.getUser(userName, password);
			//System.out.println(user);
			if(user != null) {
				httpSession.setAttribute("user", user);
				out.println("<body>");
				out.println("<h1><center>Welcome, Happy to See you. Questions are waiting for you. Go and answer them OR Having a doubt? Go and post it</center></h1>");
				out.println("</body>");
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("UserHomePage.jsp");
				requestDispatcher.forward(request, response);
				//System.out.println(user);
				
			} else{
				out.println("<body>");
				out.println("<h1><center>INVALID CREDENTIALS :(</center></h1>");
				out.println("</body>");
				System.out.println("empty");

				RequestDispatcher requestDispatcher = request.getRequestDispatcher("Login.html");
				requestDispatcher.include(request, response);
			}
		out.println("</html>");
		}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

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


@WebServlet("/ShowQueryServlet")
public class ShowQueryServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String query = request.getParameter("query");
		out.println(query);
		
		out.println("<html>");

				out.println("<body>");
				out.println("<h1><center>QUERY: " + query + "</center></h1>");
				out.println("</body>");
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("PostAnswer.jsp");
				requestDispatcher.forward(request, response);
				//System.out.println(user);
				
		out.println("</html>");
		}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

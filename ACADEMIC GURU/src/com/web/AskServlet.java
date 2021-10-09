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


@WebServlet("/AskServlet")
public class AskServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		HttpSession session = request.getSession();
		String userName = (String) session.getAttribute("loginId");
		String query = request.getParameter("query");
		String category = request.getParameter("category");
		System.out.println(userName+" "+query);

		UserDAO userDAO = new UserDAO();
		int result = userDAO.insertQuery(userName, query, category);
		//String r = ""+result;

		if(result > 0) {
			
			out.println("<body>");
			out.println("<center><h1>Thank you for posting. Hope your doubt clarify soon....</h1></center>");
			out.println("</body>");
			//request.setAttribute("result", r);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("Ask.jsp");
			requestDispatcher.include(request, response);
			
		} else{
			
			out.println("<body>");
			out.println("<h1><center>Posting Failed :(</center></h1>");
			out.println("</body>");

			RequestDispatcher requestDispatcher = request.getRequestDispatcher("Ask.jsp");
			requestDispatcher.include(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

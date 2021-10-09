package com.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.UserDAO;
import com.dao.UserPostsDAO;
import com.dto.User;


@WebServlet("/PostAnswerServlet")
public class PostAnswerServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		HttpSession session = request.getSession();
		String userName = (String)session.getAttribute("loginId");
		String category = request.getParameter("category");
		String query = request.getParameter("query");
		String answer = request.getParameter("answer");
		//System.out.println(loginId+" "+password);

		UserPostsDAO userPostsDAO = new UserPostsDAO();
		int result = userPostsDAO.insertAnswer(userName, category, query, answer);
		//String r = ""+result;

		if(result > 0) {
			
			/*out.println("<body>");
			out.println("<h1><center>Answer Posted Successfully</center></h1>");
			out.println("</body>");
			//request.setAttribute("result", r);*/
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("DisplayAllPostsServlet");
			requestDispatcher.include(request, response);
			
		} else{
			
			out.println("<body>");
			out.println("<h1><center>Posting Failed :(</center></h1>");
			out.println("</body>");

			RequestDispatcher requestDispatcher = request.getRequestDispatcher("PostAnswer.jsp");
			requestDispatcher.include(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

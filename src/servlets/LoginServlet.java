package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dbhelper.MySQLDBHelper;

public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 4261016544681578021L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		boolean isUserAuthenticated = MySQLDBHelper.validateUser(username, password);
		
		//boolean isUserAuthenticated = MySQLDBHelper.validateUserUsingPreparedStatement(username, password);

		if(isUserAuthenticated) {
			System.out.println("User Authenticated");
			request.getRequestDispatcher("/jsp/success.jsp").forward(request, response);
		} else {
			System.out.println("Authentication Failure");
			request.getRequestDispatcher("/jsp/failure.jsp").forward(request, response);
		}

		out.close();
	}

}
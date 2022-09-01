package com.nagarro.training.AdvancedJavaAssignment3.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nagarro.training.AdvancedJavaAssignment3.models.Users;
import com.nagarro.training.AdvancedJavaAssignment3.utility.UserValidate;

/**
 * Servlet implementation class loginServ
 */
public class LoginServ extends HttpServlet {


	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public LoginServ() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

//		request.getRequestDispatcher("NewFile.jsp").forward(request, response);

		String username = request.getParameter("username");
		String password = request.getParameter("password");

		Users user = new Users();
		user = UserValidate.validate(username);

		if (user == null) {
			response.getWriter().print("<html><body><h4 style='color:red;text-align:center;'>No such User Exists !</h4></body></html>");
			request.getRequestDispatcher("index.jsp").include(request, response);
		}
		
		
		else if (user.getPassword().equals(password)) {
//			request.getRequestDispatcher("ProducsHome.jsp").forward(request, response);
			System.out.println("Successful Login....");
			
			HttpSession session = request.getSession(true);
			session.putValue("username", username);
			
			response.sendRedirect(request.getContextPath()+"/homepage");


		} 
		
		
		
		else {
			System.out.println("Password not matched...");
			response.getWriter().print("<html><body><h4 style='color:red;text-align:center;'>Invalid Password !!</h4></body></html>");
			request.getRequestDispatcher("index.jsp").include(request, response);

		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

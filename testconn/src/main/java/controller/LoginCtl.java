package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.omg.CORBA.Request;

import bean.UserBean;
import model.UserModel;
import util.DataValidator;
import util.PropertyReader;

/**
 * Servlet implementation class LoginCtl
 */
public class LoginCtl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginCtl() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	
	
	protected boolean validate(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("pass");
		
		boolean pass = true;
		if(DataValidator.isNull(email)) {
			
			request.setAttribute("email", PropertyReader.getValue("error.require", "login ID"));
			pass=false;
		}
		if(DataValidator.isNull(password)) {
			
			request.setAttribute("password",PropertyReader.getValue("error.require", "password")); 
			
			pass=false;
			
		}
		return pass;
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		boolean val=validate(request,response);
		String email = request.getParameter("email");
		String password = request.getParameter("pass");
		
		UserBean ub = new UserBean();
		ub.setUserId(email);
		ub.setPwd(password);
		request.setAttribute("bean", ub);
		if(val) {
		response.setContentType("text/html");

		
HttpSession session=request.getSession();

		Cookie c = new Cookie("email", email);
		c.setMaxAge(-1);
		response.addCookie(c);

		UserModel um = new UserModel();
		try {
			UserBean ub1 = um.authenticate(ub.getUserId(), ub.getPwd());
			PrintWriter out = response.getWriter();
			// out.print(ub1.getFname());
			if (ub.getUserId().equals(ub1.getUserId()) && ub.getPwd().equals(ub1.getPwd())) {
				session.setAttribute("Fname", ub1.getFname());
				session.setAttribute("Lname", ub1.getLname());
				session.setAttribute("Gender", ub1.getGender());
				session.setAttribute("Dob", ub1.getDob());
				session.setAttribute("id", ub1.getId());
				RequestDispatcher rd = request.getRequestDispatcher("WelcomeView.jsp");
				// String name=(String)request.getAttribute(ub1.getFname());

				rd.forward(request, response);
			} else {
				String error = "Login id or password is incorrect";
				request.setAttribute("error", error);
				RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
				rd.forward(request, response);

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		else {
			
			
			RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
			rd.forward(request, response);

			
		}
	
}}

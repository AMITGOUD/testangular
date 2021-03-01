package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import bean.UserBean;
import model.UserModel;
import util.DataValidator;
import util.PropertyReader;
/**
 * Servlet implementation class Userctl
 */
@WebServlet("/Userctl")
public class Userctl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Userctl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		/*
		 * PrintWriter out=response.getWriter();
		 * out.println(Fname+Lname+Pwd+Gender+UserId+MaritalStatus+Dob+Language+Message)
		 * ;
		 */
		
		
	}
	protected boolean validate(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("pass");
		
		boolean pass = true;
		if(DataValidator.isNull(email)) {
			String em_error = "Login id is required";
			request.setAttribute("email", PropertyReader.getValue("error.require", "login ID"));
			pass=false;
		}
		if(DataValidator.isNull(password)) {
			
			request.setAttribute("password",PropertyReader.getValue("error.require", "password")); 
			
			pass=false;
			
		}
		return pass;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		String Fname  =request.getParameter("fname");
		String Lname  =request.getParameter("Lname");
		String Pwd    =request.getParameter("pass");
		String Gender =request.getParameter("gender");
		String UserId =request.getParameter("email");
		String MaritalStatus=request.getParameter("marital");
		String Dob    =request.getParameter("dob");
		String Language=request.getParameter("Language");
		String Message=request.getParameter("message");
		
		UserBean ub=new UserBean();
		ub.setFname(Fname);
		ub.setDob(Dob);
		ub.setGender(Gender);
		ub.setLanguage(Language);
		ub.setLname(Lname);
		ub.setMaritalStatus(MaritalStatus);
		ub.setMessage(Message);
		ub.setPwd(Pwd);
		ub.setUserId(UserId);
		
		
		if(DataValidator.isNull(Fname)||DataValidator.isNull(Lname)||DataValidator.isNull(Dob)||DataValidator.isNull(UserId)||DataValidator.isNull(Pwd)||DataValidator.isNull(Gender)||DataValidator.isNull(MaritalStatus)||DataValidator.isNull(Language)||DataValidator.isNull(Message)) {
			String pass_error1 = "fname is required";
			request.setAttribute("error1", pass_error1);
			String pass_error2 = "Lname is required";
			request.setAttribute("error2", pass_error2);
			String pass_error7 = "Dob is required";
			request.setAttribute("error7", pass_error7);
			String pass_error5 = "UserId is required";
			request.setAttribute("error5", pass_error5);
			String pass_error3 = "password is required";
			request.setAttribute("error3", pass_error3);
			String pass_error4 = "gender is required";
			request.setAttribute("error4", pass_error4);
			String pass_error6 = "status is required";
			request.setAttribute("error6", pass_error6);
			String pass_error8 = "Language is required";
			request.setAttribute("error8", pass_error8);
			String pass_error9 = "Message is required";
			request.setAttribute("error9", pass_error9);
			RequestDispatcher rd = request.getRequestDispatcher("Registration1.jsp");
			rd.forward(request, response);
			
			
		}
		 
		 else {
		UserModel um=new UserModel();
		try {
			int i=um.add(ub);
			if(i==1) {response.sendRedirect("Login.jsp");}
			/*
			 * UserBean bn=um.authenticate(UserId,Pwd);
			 * 
			 * 
			 * PrintWriter out=response.getWriter();
			 * out.println(bn.getUserId()+bn.getPwd());
			 */
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	}
}

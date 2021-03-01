package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.UserBean;
import model.UserModel;

/**
 * Servlet implementation class ForgetPassCtl
 */
public class ForgetPassCtl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ForgetPassCtl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		UserBean urb=new UserBean();
		urb.setUserId(request.getParameter("UserId"));
		UserModel um=new UserModel();
		try {
			UserBean ub=um.findPass(urb.getUserId());
			if(ub.getPwd()!=null) {
				request.setAttribute("pass", ub.getPwd());
				RequestDispatcher rd=request.getRequestDispatcher("ForgetPass.jsp");
				rd.forward(request, response);
				
			}
			else {response.sendRedirect("ForgetPass.jsp");}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.UserBean;
import model.UserModel;

/**
 * Servlet implementation class ProfileCtl
 */
public class ProfileCtl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProfileCtl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserBean Ubean=new UserBean();
		HttpSession session=request.getSession();
		Ubean.setFname(request.getParameter("fname"));
		Ubean.setLname(request.getParameter("lname"));
		Ubean.setDob(request.getParameter("dob"));
		Ubean.setGender(request.getParameter("gender"));
		Ubean.setId((int)session.getAttribute("id"));
		UserModel um=new UserModel();
		try {
			int i=um.update(Ubean);
			if(i!=0) {
				String update = "Login id or password is incorrect";
				request.setAttribute("msg1", update);
				
				  RequestDispatcher rd = request.getRequestDispatcher("WelcomeView.jsp");
				  rd.forward(request, response);
				 
				//response.sendRedirect("WelcomeView.jsp");

			}
			else {
				
				String error = "record not updated";
				request.setAttribute("error", error);
				RequestDispatcher rd = request.getRequestDispatcher("WelcomeView.jsp");
				rd.forward(request, response);

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}

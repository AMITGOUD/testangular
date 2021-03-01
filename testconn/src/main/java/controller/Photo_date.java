package controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Photo_dateBean;
import model.Photo_dateModel;

/**
 * Servlet implementation class Photo_date
 */
public class Photo_date extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Photo_date() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
		Photo_dateBean bean=new Photo_dateBean();
		long k=Photo_dateModel.nextPK();
		bean.setPhoto("photoId"+k);
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		//System.out.print("E:\\photo\\ppp\\amit&ajay weds\\"+request.getParameter("photo"));
		//code to store image
		File image  = new File(request.getParameter("photo"));
		
		FileInputStream in = new FileInputStream(image);
		StringBuffer img = new StringBuffer("E:\\JAVA SOFTWARE\\apache-tomcat-9.0.40\\webapps\\");
		 
		 img.append(bean.getPhoto()+".jpg");
		FileOutputStream writer=new FileOutputStream(img.toString());
		int ch=in.read();
		while(ch!=-1){
			
			writer.write(ch);
			ch=in.read();
		}
		writer.close();
		in.close();
		
		
		
			bean.setDob(sdf.parse(request.getParameter("sdate")));
			int i=Photo_dateModel.add(bean);
			if(i==1) {System.out.println("data Inserted successfully");}
			else {System.out.print("not inserted");}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

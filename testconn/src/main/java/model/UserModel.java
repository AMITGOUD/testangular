package model;
import util.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import bean.UserBean;
import exception.ApplicationException;
import util.JDBCDataSource;


public class UserModel {
	
	
	//amit
	
	public int add(UserBean bean) throws Exception {
		
		
		int pk=0;
		int i;
		Connection con = null;
		pk=nextPk();
		//System.out.println(pk);
		con = JDBCDataSource.getConnection();
		con.setAutoCommit(false);
		
		try {
		PreparedStatement pst=con.prepareStatement("insert into St_User values (?,?,?,?,?,?,?,?,?,?)");
		pst.setInt(1, pk);
		pst.setString(2,bean.getFname());
		pst.setString(3,bean.getLname());
		pst.setString(4,bean.getDob());
		pst.setString(5,bean.getUserId());
		pst.setString(6,bean.getPwd());
		pst.setString(7,bean.getGender());
		pst.setString(8,bean.getMaritalStatus());
		pst.setString(9,bean.getLanguage());
		pst.setString(10,bean.getMessage());
		
		 i=pst.executeUpdate();
		 con.commit();
		 }catch (Exception e) {
		           
		            try {
		            	con.rollback();
		            } catch (Exception ex) {
		                ex.printStackTrace();
		                throw new ApplicationException(
		                        "Exception : add rollback exception " + ex.getMessage());
		            }
		            throw new ApplicationException(
		                    "Exception : Exception in add College");
		        }
		finally {
	        JDBCDataSource.closeConnection(con);
	    }
		return i;
		
		 }
	
	

	public int nextPk() throws Exception {
		
        Connection con = null;
        int pk = 0;
       
        con = JDBCDataSource.getConnection();
        con.setAutoCommit(false);
    		PreparedStatement pst=con.prepareStatement("select max(id) from  St_User ");
            ResultSet rs = pst.executeQuery();
            con.commit();
            while (rs.next()) {
                pk = rs.getInt(1);
            }
            rs.close();

        
        return pk + 1;
        }

	public UserBean authenticate(String userId, String pwd) throws Exception {
		Connection con = null;
		 UserBean bean1=new UserBean();
		 con = JDBCDataSource.getConnection();
		 con.setAutoCommit(false);
		 try {
		PreparedStatement pst=con.prepareStatement("select * from  St_User where UserId=? AND Pwd=?");
		pst.setString(1, userId);
		pst.setString(2, pwd);
		String  uname = null;
		String pass=null;
		ResultSet rs = pst.executeQuery();
		con.commit();
       while (rs.next()) {
			 bean1.setId(rs.getInt(1));
			  
			  bean1.setFname(rs.getString(2)); 
			  
			  bean1.setLname(rs.getString(3));
			  bean1.setDob(rs.getString(4));
			  bean1.setUserId(rs.getString(5)); 
			  bean1.setPwd(rs.getString(6));
			  bean1.setGender(rs.getString(7)); 
			  bean1.setMaritalStatus(rs.getString(8));
			  bean1.setLanguage(rs.getString(9)); 
			  bean1.setMessage(rs.getString(10));
			 
   		
           
       }}catch (Exception e) {
           
           try {
           	con.rollback();
           } catch (Exception ex) {
               ex.printStackTrace();
               throw new ApplicationException(
                       "Exception : add rollback exception " + ex.getMessage());
           }
           throw new ApplicationException(
                   "Exception : Exception in add College");
       }
finally {
   JDBCDataSource.closeConnection(con);
}
       
      return bean1; 
	}
	
	public int update(UserBean bn) throws Exception {
			
			Connection con = null;
	 UserBean bean1=new UserBean();
	 con = JDBCDataSource.getConnection();
	 con.setAutoCommit(false);
	 int i;
	 try {
	PreparedStatement pst=con.prepareStatement("UPDATE ST_USER SET Fname=?,Lname=?,Dob=? ,Gender=?WHERE ID=?");
	pst.setString(1, bn.getFname());
	pst.setString(2, bn.getLname());
	pst.setString(3, bn.getDob());
	pst.setString(4, bn.getGender());
	pst.setInt(5, bn.getId());
	
	  i=pst.executeUpdate();
	con.commit();
  }catch (Exception e) {
      
      try {
      	con.rollback();
      } catch (Exception ex) {
          ex.printStackTrace();
          throw new ApplicationException(
                  "Exception : add rollback exception " + ex.getMessage());
      }
      throw new ApplicationException(
              "Exception : Exception in add College");
  }
finally {
JDBCDataSource.closeConnection(con);
}
	 return i;
	}
	
	
	public UserBean findPass(String userId) throws Exception {
		Connection con = null;
		 UserBean bean2=new UserBean();
		 con = JDBCDataSource.getConnection();
		 con.setAutoCommit(false);
		 try {
		PreparedStatement pst=con.prepareStatement("select Pwd from  St_User where UserId=?");
		pst.setString(1, userId);
		
		
		ResultSet rs = pst.executeQuery();
		con.commit();
      while (rs.next()) {
			
			  bean2.setPwd(rs.getString(1));
			 
  		
          
      }}catch (Exception e) {
          
          try {
          	con.rollback();
          } catch (Exception ex) {
              ex.printStackTrace();
              throw new ApplicationException(
                      "Exception : add rollback exception " + ex.getMessage());
          }
          throw new ApplicationException(
                  "Exception : Exception in add College");
      }
finally {
  JDBCDataSource.closeConnection(con);
}
      
     
		
		
		return bean2;
	}
	}



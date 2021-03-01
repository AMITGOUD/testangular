package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.StudentBean;
import bean.UserBean;
import exception.ApplicationException;
import util.JDBCDataSource;

public class StudentModel {

	public static int add(StudentBean bean) throws Exception {

		int i;
		Connection con = null;

		// System.out.println(pk);
		con = JDBCDataSource.getConnection();
		con.setAutoCommit(false);

		try {
			System.out.println(bean.getFileToUpload());
			File image  = new File(bean.getFileToUpload());
			FileInputStream in = new FileInputStream(image);
			PreparedStatement pst = con.prepareStatement("insert into Student values (?,?,?,?,?)");

			pst.setString(1, bean.getRollNo());
			pst.setString(2, bean.getFirstName());
			pst.setString(3, bean.getLastName());
			pst.setString(4, bean.getMobileNo());
            pst.setBinaryStream(5, (InputStream)in,in.available());
			i = pst.executeUpdate();
			con.commit();
		} catch (Exception e) {

			try {
				con.rollback();
			} catch (Exception ex) {
				ex.printStackTrace();
				throw new ApplicationException("Exception : add rollback exception " + ex.getMessage());
			}
			throw new ApplicationException("Exception : Exception in add student");
		} finally {
			JDBCDataSource.closeConnection(con);
		}
		return i;

	}

	public static int update(StudentBean bn) throws Exception {

		Connection con = null;
		UserBean bean1 = new UserBean();
		con = JDBCDataSource.getConnection();
		con.setAutoCommit(false);
		int i;
		try {
			PreparedStatement pst = con
					.prepareStatement("UPDATE Student SET firstname=?,lastName=?,mobileNo=? WHERE rollNo=?");
			pst.setString(1, bn.getFirstName());
			pst.setString(2, bn.getLastName());
			pst.setString(3, bn.getMobileNo());
			pst.setString(4, bn.getRollNo());
			

			i = pst.executeUpdate();
			con.commit();
		} catch (Exception e) {

			try {
				con.rollback();
			} catch (Exception ex) {
				ex.printStackTrace();
				throw new ApplicationException("Exception : add rollback exception " + ex.getMessage());
			}
			throw new ApplicationException("Exception : Exception in add College");
		} finally {
			JDBCDataSource.closeConnection(con);
		}
		return i;
	}

	 public static int delete(StudentBean bean) throws ApplicationException {
	        int i;
	        Connection conn = null;
	        try {
	            conn = JDBCDataSource.getConnection();
	            conn.setAutoCommit(false); // Begin transaction
	            PreparedStatement pstmt = conn
	                    .prepareStatement("DELETE FROM Student WHERE rollNo=?");
	            pstmt.setString(1, bean.getRollNo());
	            i=pstmt.executeUpdate();
	            conn.commit(); // End transaction
	            pstmt.close();

	        } catch (Exception e) {
	            
	            try {
	                conn.rollback();
	            } catch (Exception ex) {
	                throw new ApplicationException(
	                        "Exception : Delete rollback exception "
	                                + ex.getMessage());
	            }
	            throw new ApplicationException(
	                    "Exception : Exception in delete Student");
	        } finally {
	            JDBCDataSource.closeConnection(conn);
	        }
	      return i;
	    }
	
	public static List getList() throws Exception {
		
		 ArrayList list = new ArrayList();
		 StringBuffer sql = new StringBuffer("select * from Student");
		 
		/*
		 * if(pagesize>0) {
		 * 
		 * // Calculate start record index pageno = (pageno - 1) * pagesize;
		 * sql.append(" limit " + pageno + "," + pagesize); }
		 */
		Connection con = null;
	
	con = JDBCDataSource.getConnection();
	con.setAutoCommit(false);
	int i;
	try {
		PreparedStatement pst = con
				.prepareStatement(sql.toString());
		

		ResultSet rs= pst.executeQuery();
		while (rs.next()) {
			StudentBean bean1 = new StudentBean();
			
			bean1.setRollNo(rs.getString(1));
			bean1.setFirstName(rs.getString(2));
			bean1.setLastName(rs.getString(3));
			bean1.setMobileNo(rs.getString(4));
			bean1.setBinaryStream(rs.getBinaryStream(5));
			list.add(bean1);
			
		}
		con.commit();
	} catch (Exception e) {

		try {
			con.rollback();
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new ApplicationException("Exception : add rollback exception " + ex.getMessage());
		}
		throw new ApplicationException("Exception : Exception in add College");
	} finally {
		JDBCDataSource.closeConnection(con);
	}
	
		
		
		return list;
	} 
}

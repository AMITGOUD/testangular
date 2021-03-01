package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.Photo_dateBean;
import bean.StudentBean;
import exception.ApplicationException;

import util.JDBCDataSource;




public class Photo_dateModel {
	
	public static List getList() throws Exception {
		
		 ArrayList list = new ArrayList();
		 StringBuffer sql = new StringBuffer("select * from photo_date");
		 
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
			Photo_dateBean bean1 = new Photo_dateBean();
			
			bean1.setId(rs.getLong(1));
			bean1.setPhoto(rs.getString(2));
			bean1.setDob(new java.util.Date(rs.getDate(3).getTime()));
		
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
	
	
	public static long nextPK() throws Exception {
        
        Connection conn = null;
        long pk = 0;
        try {
            conn = JDBCDataSource.getConnection();
            PreparedStatement pstmt = conn
                    .prepareStatement("SELECT MAX(ID) FROM photo_date");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                pk = rs.getInt(1);
            }
            rs.close();

        } catch (Exception e) {
            
           e.printStackTrace();
        } finally {
            JDBCDataSource.closeConnection(conn);
        }
       
        return pk + 1;
    }
	public static int add(Photo_dateBean bean) throws Exception {

		int i;
		Connection con = null;
        long pk=nextPK();
        bean.setId(pk);
		// System.out.println(pk);
		con = JDBCDataSource.getConnection();
		con.setAutoCommit(false);

		try {
			
			
			PreparedStatement pst = con.prepareStatement("insert into photo_date values (?,?,?)");
            pst.setLong(1, bean.getId());
			pst.setString(2, bean.getPhoto());
			pst.setDate(3, new java.sql.Date(bean.getDob().getTime()));
			
           
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

}

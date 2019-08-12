package com.springbook.app.Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCUtil {
	public static Connection getConnetion() {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			return DriverManager.getConnection("jdbc:mysql://localhost:3306/prectice","root","1234");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
			
	}
	public static void close(PreparedStatement stmt, Connection conn) {
		if(stmt != null) {
			try {
				if(!stmt.isClosed()) stmt.close();
				
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			finally {
				stmt = null;
			}
		}
		if(conn != null) {
			
				try {
					if(!conn.isClosed())conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				finally {
					conn = null;
				}
		}
	}
	public static void close(ResultSet rs, PreparedStatement stmt, Connection conn) {
		if(rs !=null) {
			try {
				if(!rs.isClosed()) rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally {
				rs=null;
			}
		}
		if(stmt != null) {
			try {
				if(!stmt.isClosed()) stmt.close();
				
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			finally {
				stmt = null;
			}
		}
		if(conn != null) {
			
				try {
					if(!conn.isClosed())conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				finally {
					conn = null;
				}
		}
	}
}

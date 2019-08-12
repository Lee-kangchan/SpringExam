package com.springbook.app.user;



import java.sql.Connection; 
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springbook.app.Controller.JDBCUtil;


@Repository
public class UserDAO {
	private Connection conn;
	private PreparedStatement stmt;
	private ResultSet rs;

	private static final String USER_GET = "select * from user where id=?";

	public UserVO getUser(UserVO vo) {
		UserVO user = null;
		conn = JDBCUtil.getConnetion();
		try {
			stmt = conn.prepareStatement(USER_GET);
			stmt.setString(1, vo.getId());
			rs = stmt.executeQuery();

			if (rs.next()) {
				user = new UserVO();
				user.setId(rs.getString("ID"));
				user.setPassword(rs.getString("PASSWORD"));
				user.setName(rs.getString("NAME"));
				user.setRole(rs.getString("ROLE"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, stmt, conn);
			return user;
		}
	}

}

package com.springbook.app.board;

import java.sql.Connection; 
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springbook.app.Controller.JDBCUtil;


@Repository("boardDAO")
public class BoardDAO {

	private Connection conn;
	private PreparedStatement stmt;
	private ResultSet rs;
	private static final String BOARD_INSERT = "insert into board(title, writer, content) values(?,?,?)";
	private static final String BOARD_UPDATE = "update board set title=?, content=? where seq=?";
	private static final String BOARD_DELETE = "delate board where seq=?";
	private static final String BOARD_GET = "select * from board where seq=?";
	private static final String BOARD_LIST = "select * from board";

	public void insertBoard(BoardVO vo) {
		conn = JDBCUtil.getConnetion();
		try {
			stmt = conn.prepareStatement(BOARD_INSERT);
			stmt.setString(1, vo.getTitle());
			stmt.setString(2, vo.getWriter());
			stmt.setString(3, vo.getContent());
			stmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.close(stmt, conn);
		}

	}

	public void updateBoard(BoardVO vo) {
		conn = JDBCUtil.getConnetion();
		try {
			stmt = conn.prepareStatement(BOARD_UPDATE);
			stmt.setString(1, vo.getTitle());
			stmt.setString(2, vo.getContent());
			stmt.setInt(3, vo.getSeq());

			stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.close(stmt, conn);
		}
	}

	public void deleteBoard(BoardVO vo) {
		conn = JDBCUtil.getConnetion();
		try {
			stmt = conn.prepareStatement(BOARD_DELETE);
			stmt.setInt(1, vo.getSeq());
			stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.close(stmt, conn);
		}
	}

	public BoardVO getBoard(BoardVO vo) {
		BoardVO board = null;
		conn = JDBCUtil.getConnetion();
		try {
			stmt = conn.prepareStatement(BOARD_GET);
			stmt.setInt(1, vo.getSeq());
			rs = stmt.executeQuery();

			if (rs.next()) {
				board = new BoardVO();
				board.setSeq(rs.getInt("SEQ"));
				board.setTitle(rs.getString("TITLE"));
				board.setWriter(rs.getString("WRITER"));
				board.setContent(rs.getString("CONTENT"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			JDBCUtil.close(rs, stmt, conn);
			return board;
		}
	}

	public List<BoardVO> getBoardList(BoardVO vo) {

		List<BoardVO> boardList = new ArrayList<BoardVO>();
		conn = JDBCUtil.getConnetion();
		try {
			stmt = conn.prepareStatement(BOARD_LIST);
			rs = stmt.executeQuery();

			while (rs.next()) {
				BoardVO board = new BoardVO();
				board.setSeq(rs.getInt("SEQ"));
				board.setTitle(rs.getString("TITLE"));
				board.setWriter(rs.getString("WRITER"));
				board.setContent(rs.getString("CONTENT"));
				boardList.add(board);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			JDBCUtil.close(rs, stmt, conn);
			return boardList;
		}
	}
}

/*
 * package kr.or.connect;
 * 
 * import java.sql.Connection; import java.sql.DriverManager; import
 * java.sql.PreparedStatement; import java.sql.ResultSet; import
 * java.sql.SQLException; import java.util.List;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.jdbc.core.JdbcTemplate; import
 * org.springframework.jdbc.core.RowMapper; import
 * org.springframework.stereotype.Repository;
 * 
 * @Repository("boardDAO") public class BoardDAO {
 * 
 * @Autowired private JdbcTemplate jdbcTemplate;
 * 
 * private Connection conn; private PreparedStatement stmt; private ResultSet
 * rs; private static final String BOARD_INSERT =
 * "insert into board(title, writer, content) values(?,?,?)"; private static
 * final String BOARD_UPDATE =
 * "update board set title=?, content=? where seq=?"; private static final
 * String BOARD_DELETE = "delate board where seq=?"; private static final String
 * BOARD_GET = "select * from board where seq=?"; private static final String
 * BOARD_LIST = "select * from board";
 * 
 * 
 * 
 * public void insertBoard(BoardVO vo) { jdbcTemplate.update(BOARD_INSERT,
 * vo.getTitle(), vo.getWriter(), vo.getContent()); }
 * 
 * public void updateBoard(BoardVO vo) { jdbcTemplate.update(BOARD_UPDATE,
 * vo.getTitle(), vo.getContent(), vo.getSeq()); }
 * 
 * public void deleteBoard(BoardVO vo) {
 * jdbcTemplate.update(BOARD_DELETE,vo.getSeq()); } public BoardVO
 * getBoard(BoardVO vo) { Object[] args = {vo.getSeq()}; return
 * jdbcTemplate.queryForObject(BOARD_GET, args, new BoardRowMapper()); } public
 * List<BoardVO> getListBoard(BoardVO vo){ return jdbcTemplate.query(BOARD_LIST,
 * new BoardRowMapper()); }
 * 
 * }
 * 
 * class BoardRowMapper implements RowMapper<BoardVO>{
 * 
 * @Override public BoardVO mapRow(ResultSet rs, int rowNum) throws SQLException
 * { BoardVO board = new BoardVO(); board.setSeq(rs.getInt("SEQ"));
 * board.setTitle(rs.getString("TITLE"));
 * board.setWriter(rs.getString("WRITER"));
 * board.setContent(rs.getString("CONTENT")); return board; }
 * 
 * }
 * 
 */
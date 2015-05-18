package com.sds.icto.board.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.sds.icto.board.vo.BoardVo;


public class BoardDao {

	private Connection getConnection() throws ClassNotFoundException, SQLException {
		Connection conn = null;	
		// 1. 드라이버 로딩
		Class.forName("oracle.jdbc.driver.OracleDriver");
		// 2. connection 생성
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		conn = DriverManager.getConnection(url, "webdb", "webdb");
		
		return conn;
	}
	
	public void insert( BoardVo vo ) throws ClassNotFoundException, SQLException {

		Connection conn = getConnection();

		// 3. Statement 준비

		String sql = "insert into board values(board_no_seq.nextval , ?, ?, ?, ?, 0, sysdate)";

		PreparedStatement pstmt = conn.prepareStatement( sql );
		
		// 4. binding
		pstmt.setString( 1, vo.getTitle() );
		pstmt.setString( 2, vo.getContent() );
		pstmt.setLong( 3, vo.getMemberno() );
		pstmt.setString(4, vo.getName());
		
		// 5. 쿼리 실행
		pstmt.executeUpdate();

		if (pstmt != null) {
			pstmt.close();
		}
		if (conn != null) {
			conn.close();
		}
	} //insert
	
	public void delete(BoardVo vo) throws ClassNotFoundException, SQLException {
		Connection conn = getConnection();

		String sql = "delete from board where no = ? and member_no = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);

		pstmt.setLong(1, vo.getNo());
		pstmt.setLong(2, vo.getMemberno());

		pstmt.executeUpdate();

		pstmt.close();
		conn.close();
	}
	
	public void update(BoardVo vo) throws ClassNotFoundException, SQLException {
		Connection conn = getConnection();

		String sql = "update board set title=?, content=? where no = ? and member_no = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);

		pstmt.setString(1, vo.getTitle());
		pstmt.setString(2, vo.getContent());
		pstmt.setLong(3, vo.getNo());
		pstmt.setLong(4, vo.getMemberno());

		pstmt.executeUpdate();

		pstmt.close();
		conn.close();
	}
	
	public BoardVo getBoardVo(BoardVo vo) throws ClassNotFoundException,
			SQLException {
		BoardVo boardVo = null;

		Connection conn = getConnection();

		String sql = "select * from board where no = ? and member_no = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);

		pstmt.setLong(1, vo.getNo());
		pstmt.setLong(2, vo.getMemberno());

		ResultSet rs = pstmt.executeQuery();
		if (rs.next()) {
			Long no = rs.getLong(1);
			String title = rs.getString(2);
			String content = rs.getString(3);
			Long memberno = rs.getLong(4);
			String name = rs.getString(5);
			Long viewcount = rs.getLong(6);
			String sysdate = rs.getString(7);

			boardVo = new BoardVo();
			boardVo.setNo(no);
			boardVo.setTitle(title);
			boardVo.setContent(content);
			boardVo.setMemberno(memberno);
			boardVo.setName(name);
			boardVo.setViewcount(viewcount);
			boardVo.setSysdate(sysdate);
		}

		rs.close();
		pstmt.close();
		conn.close();

		return boardVo;
	}

	public BoardVo getBoardVo(Long boardNo) throws ClassNotFoundException,
			SQLException {
		BoardVo vo = null;

		Connection conn = getConnection();

		String sql = "select * from board where no = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);

		pstmt.setLong(1, boardNo);

		ResultSet rs = pstmt.executeQuery();
		if (rs.next()) {
			Long no = rs.getLong(1);
			String title = rs.getString(2);
			String content = rs.getString(3);
			Long memberno = rs.getLong(4);
			String name = rs.getString(5);
			Long viewcount = rs.getLong(6);
			String sysdate = rs.getString(7);

			vo = new BoardVo();
			vo.setNo(no);
			vo.setTitle(title);
			vo.setContent(content);
			vo.setMemberno(memberno);
			vo.setName(name);
			vo.setViewcount(viewcount);
			vo.setSysdate(sysdate);
		}

		rs.close();
		pstmt.close();
		conn.close();

		return vo;
	}	
	
	public List<BoardVo> fetchList() throws ClassNotFoundException, SQLException {
		List<BoardVo> list = new ArrayList<BoardVo>();

		// 1. Connection 생성
		Connection conn = getConnection();

		// 2. statement 생성
		Statement stmt = conn.createStatement();

		// 3. sql문 실행
		String sql = "select * from board";
		ResultSet rs = stmt.executeQuery( sql );

		// 4. 결과 처리
		while ( rs.next() ) {
						
			Long no = rs.getLong( 1 );
			String title = rs.getString( 2 );
			String content = rs.getString( 3 );
			Long memberno = rs.getLong( 4 );
			String name = rs.getString( 5 );
			Long viewcount = rs.getLong( 6 );
			String sysdate = rs.getString( 7 );
			
			BoardVo vo = new BoardVo();
			
			vo.setNo( no );
			vo.setTitle(title);
			vo.setContent(content);
			vo.setMemberno(memberno);
			vo.setName( name );
			vo.setViewcount(viewcount);
			vo.setSysdate( sysdate );

			list.add( vo );
		}

		// 5. 자원정리
		if (rs != null) {
			rs.close();
		}
		if (stmt != null) {
			stmt.close();
		}
		if (conn != null) {
			conn.close();
		}
		return list;
	}
	
	
} //BoardDao

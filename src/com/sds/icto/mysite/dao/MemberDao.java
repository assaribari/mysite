package com.sds.icto.mysite.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.sds.icto.mysite.vo.MemberVo;

public class MemberDao {
	
	private Connection getConnection() throws ClassNotFoundException, SQLException {
		Connection conn = null;	
		// 1. 드라이버 로딩
		Class.forName("oracle.jdbc.driver.OracleDriver");
		// 2. connection 생성
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		conn = DriverManager.getConnection(url, "webdb", "webdb");
		
		return conn;
	}
	
	public void insert( MemberVo vo ) throws ClassNotFoundException, SQLException {

		Connection conn = getConnection();

		// 1. Statement 준비

		String sql = "insert into member values(member_no_seq.nextval , ?, ?, ?, ? )";

		PreparedStatement pstmt = conn.prepareStatement( sql );

		// 2. binding
		pstmt.setString( 1, vo.getName() );
		pstmt.setString( 2, vo.getEmail() );
		pstmt.setString( 3, vo.getPassword() );
		pstmt.setString( 4, vo.getGender() );

		// 3. 쿼리 실행
		pstmt.executeUpdate();
		
		// 4. 자원 정리
		pstmt.close();
		conn.close();

	} //insert

	
	public MemberVo getMember( MemberVo vo ) throws ClassNotFoundException, SQLException {
		Connection conn = getConnection();

		// 1. Statement 준비
		String sql = "select * from member where email = ? and password = ?";

		PreparedStatement pstmt = conn.prepareStatement( sql );

		// 2. binding

		pstmt.setString( 1, vo.getEmail() );
		pstmt.setString( 2, vo.getPassword() );


		// 3. 쿼리 실행
		ResultSet rs = pstmt.executeQuery();
		
		MemberVo memberVo = null;
		
		if( rs.next() ){
			memberVo = new MemberVo();
			Long no = rs.getLong( 1 );
			String name = rs.getString( 2 );
			String email = rs.getString( 3 );
//			String password = rs.getString( 4 );
			String gender = rs.getString( 5 );
			
			memberVo = new MemberVo();
			memberVo.setNo(no);
			memberVo.setName(name);
			memberVo.setEmail(email);
//			memberVo.setPassword(password);
			memberVo.setGender(gender);
		}
		
		// 4. 자원 정리
		rs.close();
		pstmt.close();
		conn.close();
		
		return memberVo;
	}
	

}//MemberDao

package com.sds.icto.board.action;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sds.icto.board.dao.BoardDao;
import com.sds.icto.board.vo.BoardVo;
import com.sds.icto.web.Action;

public class AddAction implements Action {
	
	// 이메일 등록
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ClassNotFoundException, ServletException,
			IOException {
	
		request.setCharacterEncoding( "utf-8" );
		
		
		String title = request.getParameter( "title" );
		String content = request.getParameter( "content" );
		String memberno = request.getParameter( "memberno" );
		String name = request.getParameter( "name" );

		
		BoardVo vo = new BoardVo();

		vo.setTitle( title );
		vo.setContent(content);
		vo.setMemberno(Long.parseLong(memberno));
		vo.setName(name);
		vo.setViewcount(10l);
		
		BoardDao dao = new BoardDao();
		dao.insert( vo );

		response.sendRedirect( "/mysite/views/board/listform.jsp" ); 
		

	}
	
}

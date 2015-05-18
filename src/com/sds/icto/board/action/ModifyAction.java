package com.sds.icto.board.action;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sds.icto.board.dao.BoardDao;
import com.sds.icto.board.vo.BoardVo;
import com.sds.icto.mysite.vo.MemberVo;
import com.sds.icto.web.Action;
import com.sds.icto.web.WebUtil;

public class ModifyAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ClassNotFoundException, ServletException,
			IOException {
		// TODO Auto-generated method stub
		// 게시물 번호
				Long boardNo = 0L;
				
				try {
					boardNo = Long.parseLong( request.getParameter( "no" ) ); 
				} catch( NumberFormatException ex ) {
					System.out.println( "ModifyAction - parameter fails" );
					response.sendRedirect( "/mysite/board" );
					return;
				}
				
				// 세션 객체를 가져옴
				HttpSession session = request.getSession( false );
				if( session == null ) {
					response.sendRedirect( "/mysite/board" );
					return;
				}

				// 세션 객체에 저장된 MemberVo 객체를 꺼냄
				MemberVo memberVo = ( MemberVo ) session.getAttribute( "authMember" );
				if( memberVo == null ) {
					response.sendRedirect( "/mysite/board" );
					return;
				}
				
				// VO 세팅
				BoardVo vo = new BoardVo();
				vo.setNo( boardNo );
				vo.setMemberno( memberVo.getNo() );
				
				BoardDao dao = new BoardDao();
				BoardVo boardVo = dao.getBoardVo( vo );
				if( boardVo == null ) {
					response.sendRedirect( "/mysite/board" );
					return;	
				}
				
				request.setAttribute( "vo", boardVo );
				WebUtil.forward( "/views/board/modifyform.jsp" , request, response);
	}

}

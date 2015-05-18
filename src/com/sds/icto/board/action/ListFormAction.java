package com.sds.icto.board.action;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sds.icto.board.dao.BoardDao;
import com.sds.icto.board.vo.BoardVo;
import com.sds.icto.web.Action;
import com.sds.icto.web.WebUtil;

public class ListFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ClassNotFoundException, ServletException,
			IOException {
		// TODO Auto-generated method stub
		BoardDao dao = new BoardDao();
		List<BoardVo> list = dao.fetchList();
		
		request.setAttribute( "list", list );
		WebUtil.forward( "/views/board/listform.jsp", request, response );
		
	}

}

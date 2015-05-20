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
		
		Long no = Long.parseLong(request.getParameter("no"));
		
		BoardDao dao = new BoardDao();
		BoardVo boardVo = new BoardVo();
		
		boardVo = dao.getBoardVo(no);

		request.setAttribute("vo", boardVo);

		WebUtil.forward("/views/board/modifyform.jsp", request, response);
	}

}

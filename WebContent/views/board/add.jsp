
<%@page import="com.sds.icto.board.vo.BoardVo"%>
<%@page import="com.sds.icto.board.dao.BoardDao"%>
<%@page import="com.sds.icto.mysite.vo.MemberVo"%>

<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
	BoardDao dao = new BoardDao();
	BoardVo vo = new BoardVo(); 
	List<BoardVo> list = dao.fetchList();
	MemberVo authMember = (MemberVo)session.getAttribute("authMember");
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>방명록</title>
</head>
<body>
	<form action="/board" method="post">
	<input type="hidden" name="a" value="add">
	<table border=1 width=500>
		<tr>
			<input type="hidden" name="no" value=<%=vo.getNo() %>>
			<td>이름</td><td><input type="text" name="name" value=<%=authMember.getName()%>></td>
			<td>제목</td><td><input type="text" name="title"></td>
			<td>내용</td><td><input type="text" name="content"></td>
		</tr>
			
			<input type="hidden" name="no" value=<%=authMember.getNo() %>>
			<input type="hidden" name="name" value=<%=authMember.getName() %>>
			
			<td>제목</td><td><input type="text" name="title"></td>
			<td>제목</td><td><input type="text" name="title"></td>
			<td>제목</td><td><input type="text" name="title"></td>
		</tr>
		<tr>
			<td colspan=4><textarea name="content" cols=60 rows=5></textarea></td>
		</tr>
		<tr>
			<td colspan=4 align=right><input type="submit" VALUE=" 확인 "></td>
		</tr>
	</table>
	</form>
	<br>
	
</body>
</html>
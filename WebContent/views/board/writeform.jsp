<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>mysite</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<link href="/mysite/assets/css/board.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div id="container">
		<div id="header">
			<c:import url="/views/include/header.jsp" />
		</div>
		<div id="content">
			<h2>자유게시판</h2>
			<div id="board">
				<form class="board-form" method="post" action="/mysite/board">
					<input type = "hidden" name = "a" value="add">
					<input type = "hidden" name = "memberno" value="${authMember.getNo() }">
					<input type = "hidden" name = "name" value="${authMember.getName() }">
					<table class="tbl-ex">
						<tr>
							<th colspan="2" id = "modifytitle">새로운 글쓰기</th>
						</tr>
						<tr>
							<td class="label">제목</td>
							<td><input type="text" name="title" value=""></td>
						</tr>
						<tr>
							<td class="label">내용</td>
							<td>
								<textarea id="content" name="content"></textarea>
							</td>
						</tr>
					</table>
					<div class="bottom">
						<input type="submit" value="등록">
						<a href="/mysite/board">취소</a>
						
					</div>
				</form>				
			</div>
		</div>
		<div id="navigation">
			<c:import url="/views/include/navigation_board.jsp" />
		</div>
		<div id="footer">
			<c:import url="/views/include/footer.jsp" />
		</div>
	</div>
</body>
</html>
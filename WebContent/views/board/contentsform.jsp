
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% pageContext.setAttribute("newLineChar", "\n"); %>

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
			
			<div id="board" class="board-form">
			
				<table class="tbl-ex">
				
					<tr>
						<th>제목</th>
						<th class="cont-title">${vo.title }</th>
					</tr>
					
					<tr id="writerinfo">
						<td class="label">
							<em>${vo.name }</em>
						</td>
						<td>
							<p>조회 수 : 0</p>
						</td>
					</tr>
					
					<tr>
						<td class="label">내용</td>
						<td>
							<div class="view-content">
								${fn:replace( vo.content, newLineChar, "<br>" ) }
							</div>
						</td>
					</tr>
				</table>
				
				
				<div class="bottom">
					<a href="/mysite/board?a=listform">글목록</a>
					<a href="/mysite/board?a=modify">글수정</a>
				</div>
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
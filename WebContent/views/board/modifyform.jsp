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
				<form class="board-form" method="post" action="">
					<table class="tbl-ex">
						<tr>
							<th colspan="2" id = "modifytitle">글 수정하기</th>
						</tr>
						<tr>
							<td class="label">제목</td>
							<td><input type="text" name="title" value="제목을 수정할 생각이 없으면  이 입력창을 버리세요!"></td>
						</tr>
						<tr>
							<td class="label">내용</td>
							<td>
								<textarea id="content" name="content">수정해야 할 글은 고대로 
이렇게 textarea에 뿌려야 합니다.
개행문자 변경도 하지마세요.
하하하하하
즐건 과제 되세요~~~~</textarea>
							</td>
						</tr>
					</table>
					<div class="bottom">
						<input type="submit" value="수정">
						<a href="">취소</a>
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
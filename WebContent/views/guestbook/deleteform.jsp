<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String no = request.getParameter( "no" );
%>
<!doctype html>
<html>
<head>
<title>mysite</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<link href="/mysite/assets/css/guestbook.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div id="container">
		<div id="header">
			<jsp:include page = "/views/include/header.jsp" flush="false"/>
		</div>
		<div id="content">
			<div id="guestbook" class="delete-form">
				<form action="/mysite/gb?a=delete" method="post">
					<input type="hidden" name="a" value="delete"> <input
						type='hidden' name="no" value=<%=no%>>
					<table>
						<tr>
							<td>비밀번호</td>
							<td><input type="password" name="password"></td>
							<td><input type="submit" value="확인"></td>
							<td><a href="/mysite/gb?a=guestbookform">메인으로 돌아가기</a></td>
						</tr>
					</table>
				</form>
				<a href="/mysite/gb?a=guestbookform">방명록 리스트</a>
			</div>
		</div>
		<div id="navigation">
			<jsp:include page = "/views/include/navigation.jsp" flush = "false"/>
		</div>
		<div id="footer">
			<jsp:include page = "/views/include/footer.jsp" flush = "false"/>
		</div>
	</div>
</body>
</html>
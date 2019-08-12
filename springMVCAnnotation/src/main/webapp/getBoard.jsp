<%@page import ="com.springbook.view.Board.impl.*" %>
<%@page import ="com.springbook.view.user.*" %>
<%@page import ="com.springbook.app.board.BoardVO" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html" charset="UTF-8">
<title>글상세</title>
</head>
<body>
<center>
<h1>글 상세</h1>
<a href="logout.do">Log-out</a>
<hr>
<form action="updateBoard.do" method="post">
<input name="seq" type="hidden" value="${board.seq }">
<table border="1" cellpadding="0" cellspacing="0">
	<tr>
		<td bgcolor="#fe7062" width="70">제목</td>
		<td align="left"><input name="title" type="text" value="${board.title }"></td>
	</tr>
	<tr>
		<td bgcolor="#fe7062">작성자</td>
		<td align="left">${board.writer}</td>
	</tr>
	<tr>
		<td bgcolor="#fe7062">내용</td>
		<td align="left"><textarea name="content" cols="400" rows="10">${board.content }</textarea></td>
		
	</tr>
	<tr>
		<td colspan="2" align="center">
			<input type="submit" value="글 수정"/>
		</td>
	</tr>
	</table>
	</form>
<hr>
<a href="insertBoard.jsp">글등록</a>&nbsp;&nbsp;&nbsp;;
<a href="deleteBoard.do?seq=${board.seq }">글삭제</a>&nbsp;&nbsp;&nbsp;
<a href="getBoardList.jsp">글목록</a>
</center>
</body>
</html>
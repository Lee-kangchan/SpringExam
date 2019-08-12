<%@page import="java.util.List" %>
<%@page import ="com.springbook.view.Board.impl.*" %>
<%@page import ="com.springbook.view.user.*" %>
<%@page import = "com.springbook.app.board.BoardVO" %>
<%@page import ="java.util.ArrayList" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	List<BoardVO> board1 = (List)request.getAttribute("boardList");
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html" charset="UTF-8">
<title>글 목록</title>
</head>
<body>
<center>
		<h1>글 목록</h1>
		<h3> ${userName }님 환영합니다... </h3>
	 <a href="logout.do">Log-out</a>
<form action="getBoardList.jsp" method="post">
<table border="1" cellpadding="0" cellspacing="0" width="700">
<tr>
<td align="right">
	<select name="searchCondition">
	<option value="TITLE">제목
	<option value="CONTENT">내용
	</select>
	<input name="searchkeyword" type="text"/>
	<input type="submit" value="검색"/>
</td>
</tr>
</table>
</form>

<table border="1" cellpadding="0" cellspacing="0" width="700">
<tr>
	<th bgcolor="#fe7062" width="100">번호</th>
	<th bgcolor="#fe7062" width="300">제목</th>
	<th bgcolor="#fe7062" width="250">작성자</th>
</tr>
<%for(BoardVO board : board1) { %>
<tr>
	<td><%= board.getSeq() %></td>
	
	<td align="left"> <a href="getBoard.do?seq=<%=board.getSeq()%>"> <%=board.getTitle()%></a></td>
	<td> <%= board.getWriter()%></td>
	
</tr>

<% } %>
</table>
<br>

<a href="insertBoard.jsp">새글 등록</a>
</center>
</body>
</html>
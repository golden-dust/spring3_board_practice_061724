<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
	<title>Home</title>
</head>
<body>
	<h1>
		Hello world!  
	</h1>
	
	<P>  The time on the server is ${serverTime}. </P>
	
	<table>
		<tr>
			<td><a href="join">회원 가입</a></td>
			<td><a href="signin">로그인</a></td>
			<td><a href="delete_account">회원 탈퇴</a></td>
		</tr>
	</table>
</body>
</html>

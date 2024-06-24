<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Member List</title>
</head>
<body>
	<h2>회원 목록</h2>
	<hr>
	<table>
		<tr>
			<th></th>
			<th>아이디</th>
			<th>이름</th>
			<th>이메일</th>
			<th>가입일</th>
		</tr>
		<c:set var="count" value="1" />
		<c:forEach items="${memberList}" var="member">
		<tr>
			<td><c:out value="${count}" />. </td>
			<td><a href="memberSearchResult?mid=${member.mid}">${member.mid}</a></td>
			<td>${member.mname}</td>
			<td>${member.memail}</td>
			<td>${member.mdate}</td>
		</tr>
		<c:set var="count" value="${count + 1}" />
		</c:forEach>
	</table>
</body>
</html>
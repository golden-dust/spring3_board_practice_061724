<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Find PW</title>
</head>
<body>
	회원 정보 찾기 테스트
	<form action="pwsearch/result">
		아이디 : <input type="text" name="searchId"><br>
		이메일 : <input type="text" name="searchEmail"><br>
		<a href="idsearch">아이디 찾기</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<input type="submit" value="search">
	</form>
</body>
</html>
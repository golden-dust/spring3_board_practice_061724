<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sign Up</title>
</head>
<body>
	<h2>회원 가입</h2>
	<hr>
	<h4>${error }</h4>
	<form action="joinOk">
		<table>
			<tr>
				<td>아이디 : </td>
				<td><input type="text" name="mid"></td>
			</tr>
			<tr>
				<td>비밀번호 : </td>
				<td><input type="password" name="mpw"></td>
			</tr>
			<tr>
				<td>이름 : </td>
				<td><input type="text" name="mname"></td>
			</tr>
			<tr>
				<td>이메일 : </td>
				<td><input type="text" name="memail"></td>
			</tr>
		</table>
		<input type="submit" value="회원가입">
	</form>
	<br>
</body>
</html>
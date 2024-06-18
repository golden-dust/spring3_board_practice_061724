<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sign In</title>
</head>
<body>
	<h2>로그인</h2>
	<hr>
	<fieldset style="width: 300px; border: white;">
		<form action="signinOk">
			<table style="padding: 2px;">
				<tr>
					<td>아이디 : </td>
					<td><input type="text" name="mid"></td>
				</tr>
				<tr>
					<td>비밀번호 : </td>
					<td><input type="password" name="mpw"></td>
				</tr>
			</table>
			<div style="padding: 2px;">
				<a href="idsearch">아이디/비밀번호 찾기</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="submit" value="로그인">
			</div>
		</form>
	</fieldset>
</body>
</html>
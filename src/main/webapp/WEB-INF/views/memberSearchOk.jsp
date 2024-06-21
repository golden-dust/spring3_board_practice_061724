<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Member Search Result</title>
</head>
<body>
	<h2>회원 정보 수정</h2>
	<hr>
	<form action="memberInfoUpdated">
		<p>
			<input type="hidden" name="mid" value="${memberDto.mid}">
			
			아이디 : ${memberDto.mid}<br>
			이름 : <input type="text" name="mname" value="${memberDto.mname}"><br>
			이메일 : <input type="text" name="memail" value="${memberDto.memail}"><br>
			가입일 : ${memberDto.mdate}<br>
			비밀번호 : <input type="password" name="mpw" id="mpw">
		</p>
		<input type="submit" value="정보수정"> 
		<input type="button" value="회원탈퇴" onclick="javascript:window.location.href='account_deleted?mid=${memberDto.mid}'">
		<input type="button" value="이전페이지" onclick="javascript:history.go(-1)">
	</form>
</body>
</html>
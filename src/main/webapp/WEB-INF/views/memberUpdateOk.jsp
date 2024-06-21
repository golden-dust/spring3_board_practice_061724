<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>회원 정보 수정 결과</h2>
	<hr>
	<form>
		<p>
			아이디 : ${memberDto.mid}<br>
			이름 : ${memberDto.mname}<br>
			이메일 : ${memberDto.memail}<br>
			가입일 : ${memberDto.mdate}
		</p>
	</form>
	<p>
		<a href="home">홈으로 돌아가기</a>
	</p>
</body>
</html>
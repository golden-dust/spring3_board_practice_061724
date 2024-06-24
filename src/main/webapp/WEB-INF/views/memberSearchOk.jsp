<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Member Search Result</title>
<style>
	.warningMsg {
		color: red;
		font-size: small;
		display: none;
	}
	.error {
	    color: #f00;
	    border-color: #f00
	}
</style>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.5/dist/jquery.validate.js"></script>
</head>
<body>
	<h2>회원 정보 수정</h2>
	<hr>
	<form name="memInfoForm" id="memInfoForm" method="post">
		<p>
			<input type="hidden" name="mid" value="${memberDto.mid}">
			<input type="hidden" name="pw" id="pw" value="${memberDto.mpw}">
			아이디 : ${memberDto.mid}<br>
			이름 : <input type="text" name="mname" id="mname" value="${memberDto.mname}"> <br>
			이메일 : <input type="text" name="memail" id="memail" value="${memberDto.memail}"> <br>
			가입일 : ${memberDto.mdate} <br>
			비밀번호 : <input type="password" name="mpw" id="mpw"> <br>
		</p>
		<input type="submit" value="정보수정" formaction="memberInfoUpdated" > 
		<input type="submit" value="회원탈퇴" formaction="account_deleted">
		<input type="button" value="이전페이지" onclick="javascript:history.go(-1)">
	</form>
<script>
	$('#memInfoForm').validate({
		rules: {
			// name of an element
			mname: "required", 
			memail: {
				required: true, 
				email: true
			}, 
			mpw: {
				required: true,
				equalTo: pw
			} 
		}, 
		messages: {
			mname: {
				required: "이름을 입력해주세요"
			}, 
			memail: {
				email: "이메일 형식을 확인하세요"
			}, 
			mpw: {
				required: "비밀번호를 입력해주세요", 
				equalTo: "비밀번호가 일치하지 않습니다"
			}
		}, 

	});

</script>
</body>
</html>
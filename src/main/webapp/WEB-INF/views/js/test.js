function checkPw() {
    pwMsg.style.display = "none";
    let input_pw = document.getElementById("mpw");
    let pw = document.getElementById("pw");
    if (pw.value.equals(input_pw.value)) {
        return true;
    } else {
        alert("비밀번호가 일치하지 않습니다");
        input_pw.focus();
        pwMsg.style.display = "inline";
        return false;
    }
}
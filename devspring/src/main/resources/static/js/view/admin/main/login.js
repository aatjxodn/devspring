// DOM이 로드된 후
$(document).ready(function() {
	
});

// 로그인 버튼 클릭 시
$('#ctUserloginButton').click(function() {
	
	var ctUserId = $("#ctUserId").val();
	var ctUserPwd = $("#ctUserId").val();
	
	if (ctUserId === '') {
		alert("ID를 입력해주세요.");
		return;
	}
	if (ctUserPwd === '') {
		alert("Password를 입력해주세요.");
		return;	
	}
	
	$("#login-form").submit();
});

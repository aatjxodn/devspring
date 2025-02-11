// DOM이 로드된 후
$(document).ready(function() {
	
});

// 로그인 버튼 클릭 시
$('#djsUserloginButton').click(function() {
	
	var djsUserId = $("#djsUserId").val();
	var djsUserPwd = $("#djsUserId").val();
	
	if (djsUserId === '') {
		alert("ID를 입력해주세요.");
		return;
	}
	if (djsUserPwd === '') {
		alert("Password를 입력해주세요.");
		return;	
	}
	
	$("#login-form").submit();
});

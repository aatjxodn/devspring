// DOM이 로드된 후
$(document).ready(function() {
	// lnb 바인딩
	sessionInfo();
});

// 사용자 session
function sessionInfo() {

	$.ajax({
		url: '/user/userSession',
		method: 'GET',
		dataType: 'json',
		success: function(data) {
			$('.header-user-name').text(data.ctUserName);
		},
		error: function(jqXHR) {
			if (jqXHR.responseJSON) {
				alert(jqXHR.responseJSON.error + " : " + jqXHR.responseJSON.status + ", " + jqXHR.responseJSON.message);
				console.log(jqXHR.responseJSON);
			} else {
				alert("에러 메세지를 찾을 수 없습니다.");
			}
		}

	});
};

$('.header-user-logout').click(function() {
	
	if(confirm("로그아웃 하시겠습니까?")) {
		location.href="/user/logout";
	}
	
});

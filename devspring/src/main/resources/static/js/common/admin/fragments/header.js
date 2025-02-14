// DOM이 로드된 후
$(document).ready(function() {
	// lnb 바인딩
	sessionInfo();
});

// 사용자 session
function sessionInfo() {

	$.ajax({
		url: '/user/sessionInfo',
		method: 'GET',
		dataType: 'json',
		success: function(data) {
			console.log(data);
			
			$('.header-user-name').text(data.ctUserName);
		},
		error: function(request, status, error) {
			console.log("code: " + request.status)
			console.log("message: " + request.responseText)
			console.log("error: " + error);
		}

	});
};

$('.header-user-logout').click(function() {
	
	if(confirm("로그아웃 하시겠습니까?")) {
		location.href="/user/logout";
	}
	
});

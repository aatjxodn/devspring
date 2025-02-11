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
		},
		error: function(request, status, error) {
			console.log("code: " + request.status)
			console.log("message: " + request.responseText)
			console.log("error: " + error);
		}

	});
};

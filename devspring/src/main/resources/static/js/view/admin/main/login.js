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

// 비밀번호 변경 버튼 클릭 시
$('#ctUserUpdatePwdButton').click(function() {
	
	var reg = /^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$/;
	
	$(".modal-layout").css("display","flex");
	$("#passwordUpdateInsertBut").css("display","none");
	
	// 비밀번호 변경 - 변경 버튼 클릭 시
	$('#passwordUpdateUpdateBut').click(function() {
		
		var ctUserId = $("#updateCtUserId").val();
		var ctUserPwd = $("#updateCtUserPwd").val();
		var ctUserPwdNew = $("#updateCtUserPwdNew").val();
		var ctUserPwdNewConfirm = $("#updateCtUserPwdNewConfirm").val();
		
		if (ctUserId === '') {
			alert("ID를 입력해주세요.");
			return;
		}
		if (ctUserPwd === '') {
			alert("Password를 입력해주세요.");
			return;	
		}
		if (ctUserPwdNew === '') {
			alert("변경할 Password를 입력해주세요.");
			return;
		}
		if (ctUserPwdNewConfirm === '') {
			alert("비밀번호 확인을 입력해주세요.");
			return;	
		}
		if (ctUserPwdNew != ctUserPwdNewConfirm) {
			alert("변경할 Password를 동일하게 입력해주세요.");
			return;	
		}
		if (false === reg.test(ctUserPwdNew)) {
			alert('비밀번호는 8자 이상이어야 하며, 숫자/대문자/소문자/특수문자를 모두 포함해야 합니다.');
			return;
		}
		
		var params= {
			"ctUserId" : ctUserId,
			"ctUserPwd" : ctUserPwd,
			"ctUserPwdNewConfirm" : ctUserPwdNewConfirm
		}
		
		$.ajax({
		    url: '/user/user',
		    method: 'PATCH',
			data: JSON.stringify(params),
			dataType: 'json',
			contentType: 'application/json; charset=utf-8',
		    success: function (data) {
				console.log(data);
				alert("비밀번호 변경 완료됐습니다.");
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
		
	});
	
	// 비밀번호 변경 - 닫기 버튼 클릭 시
	$('#passwordUpdateCloseBut').click(function() {
		
		$(".modal-layout").css("display","none");
		
	});
	
});


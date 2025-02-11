$(document).ready(function() {
	
});

// 이메일 검증용 정규식
const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;

$('.emailBut').click(function() {
	
    var name = $('.name').val();
    var subject = $('.subject').val();
    const email = $('.email').val().trim();
    var content = $('#content').val();
	
	if (name === '') {
		alert('Please enter your name.');
		return;
	}
	if (subject === '') {
		alert('Please enter your subject.');
		return;
	}
	if (email === '') {
		alert('Please enter your email.');
		return;
	}
	if (content === '') {
		alert('Please enter your content.');
		return;
	}
	
	// 이메일 형식이 올바르지 않은 경우
	if (!emailRegex.test(email)) {
		alert('The email format is incorrect.');
		return;
    }
	
	// 내용이 5000자 이상일 경우
	if (content.length > 5000) {
        alert('Please write the content in 5000 characters or less.');
        return;
    }

    var params = {
        "name": name,
        "subject": subject,
        "email": email,
        "content": content
    };
	
    $.ajax({
        url: '/mail/sendEmail',
        method: 'POST',
        data: JSON.stringify(params),
        contentType: 'application/json',
        success: function(data) {
            alert('The email has been sent successfully.');
        },
        error: function(request, status, error) {
            alert("code:" + request.status + "\n" + "message:" + request.responseText + "\n" + "error:" + error);
        }
    });
	
});


// DOM이 로드된 후
$(document).ready(function() {
	$("#input_file").on("change", fileCheck);
});

$('#btn-upload').click(function (e) {
    e.preventDefault();
    $('#input_file').click();
});

// 파일 현재 필드 숫자 totalCount랑 비교값
var fileCount = 0;
// 해당 숫자를 수정하여 전체 업로드 갯수를 정한다.
var totalCount = 5;
// 파일 고유넘버
var fileNum = 0;
// 첨부파일 배열
var content_files = new Array();

function fileCheck(e) {
    var files = e.target.files;
    // 파일 배열 담기
    var filesArr = Array.prototype.slice.call(files);
    // 파일 개수 확인 및 제한
    if (fileCount + filesArr.length > totalCount) {
      alert('파일은 최대 '+totalCount+'개까지 업로드 할 수 있습니다.');
      return;
    } else {
    	 fileCount = fileCount + filesArr.length;
    }
	
	filesArr.forEach(function (f) {
		content_files.forEach(function (c) {
			if(f.name == c.name && c.is_delete != true) {
				alert('동일한 파일이 존재합니다.');
				fileCount = fileCount - filesArr.length;
				filesArr = [];
			}
			return;
		});
	});
    
	// 각각의 파일 배열담기 및 기타
	filesArr.forEach(function(f) {
		var reader = new FileReader();
		reader.onload = function(e) {
			content_files.push(f);
			$('#articlefileChange').append(
				'<div id="file' + fileNum + '">'
				+ '<span>' + f.name + '</span>'
				+ '<span onclick="fileDelete(\'file' + fileNum + '\')">X</span>'
				+ '<div/>'
			);
			fileNum++;
		};
		reader.readAsDataURL(f);
	});
	console.log(content_files);
	//초기화 한다.
	$("#input_file").val("");
}

// 파일 부분 삭제 함수
function fileDelete(fileNum){
    var no = fileNum.replace(/[^0-9]/g, "");
    content_files[no].is_delete = true;
	$('#' + fileNum).remove();
	fileCount --;
    console.log(content_files);
}

// 로그인 버튼 클릭 시
$('.butCl').click(function() {
	var formData = new FormData();
	for (var x = 0; x < content_files.length; x++) {
		// 삭제 안한것만 담아 준다. 
		if (!content_files[x].is_delete) {
			formData.append("files", content_files[x]);
		}
	}
	
	$.ajax({
		type: "POST",
		enctype: "multipart/form-data",
		url: "/notice/fileUpload",
		data: formData,
		processData: false,
		contentType: false,
		success: function(data) {
			alert("파일업로드 성공");
		},
		error: function(xhr, status, error) {
			alert("서버오류로 지연되고있습니다. 잠시 후 다시 시도해주시기 바랍니다.");
		}
	});
});

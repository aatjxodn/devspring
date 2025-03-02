// DOM이 로드된 후
$(document).ready(function() {
	setNoticeWriteSummernote();
	$("#noticeWrite-file").on("change", fileCheck);
});

// notice summernote 
function setNoticeWriteSummernote() {
	// textarea noticeWrite-summernote 적용하기
	$("#noticeWrite-summernote").summernote({
	    codeviewFilter: false,                              // 코드 보기 필터 비활성화
	    codeviewIframeFilter: false,                        // 코드 보기 iframe 필터 비활성화
	    height: 570,                                        // 에디터 높이
	    minHeight: null,                                    // 최소 높이
	    maxHeight: null,                                    // 최대 높이
	    lang: "ko-KR",                                      // 에디터 한글 설정
	    focus : true,                                       // 에디터 포커스 설정
	    toolbar: [
	        ['fontname', ['fontname']],                     // 글꼴 설정
	        ['fontsize', ['fontsize']],                     // 글자 크기
	        ['style', ['bold', 'italic', 'underline','strikethrough', 'clear']],  // 글자 스타일 설정
	        ['color', ['forecolor','color']],               // 글자색
	        ['table', ['table']],                           // 표 생성
	        ['insert', ['picture', 'link','video']],        // 이미지, 링크 , 동영상
	        ['para', ['ul', 'ol', 'paragraph']],            // 문단 스타일 설정
	        ['height', ['height']],                         // 줄간격
	        ['view', ['codeview','fullscreen', 'help']]     // 코드보기, 전체화면, 도움말
	    ],
	    fontNames: ['Arial', 'Arial Black', 'Comic Sans MS', 'Courier New','맑은 고딕','궁서','굴림체','굴림','돋음체','바탕체'], // 추가한 글꼴
	    fontSizes: ['8','9','10','11','12','14','16','18','20','22','24','28','30','36','50','72'], // 추가한 폰트사이즈
	    callbacks : {
	        // 파일 업로드
	        onImageUpload : function (files) {
	            for(let i=0; i < files.length; i++){
	                // 이미지가 여러개일 경우
	                imageUpload(files[i]);
	            }
	        },
	        // 파일 삭제
	        onMediaDelete: function ($target){
	            if(confirm("이미지를 삭제하시겠습니까?")){
	                let fileName = $target.attr('src').split('/').pop();
	                deleteFile(fileName);
	            }
	        }
	    }
	});
}

// 이미지 업로드
function imageUpload(file){
	
    let formData = new FormData();
    formData.append("file", file);

    $.ajax({
       url : "/notice/imageUpload",
       type : "POST",
       data : formData,
       contentType: false, // contentType, processData 설정 안하면 TypeError: Illegal invocation 오류가 발생한다
       processData: false,
       encType : "multipart/form-data",
       success : function (data) {
           $("#noticeWrite-summernote").summernote("insertImage", "/uploadPath/image/"+data);
       },
       error(e){
           console.log("error : "+ e);
       }
    });
}

// 이미지 삭제
function deleteFile(fileName) {
	
    let formData = new FormData();
    formData.append("file", fileName);
	
    $.ajax({
        url : "/notice/imageDelete",
        type : "POST",
        data : formData,
        contentType: false, // contentType, processData 설정 안하면 TypeError: Illegal invocation 오류가 발생한다
        processData: false,
        encType : "multipart/form-data"
    });
}

$('#noticeWrite-file-insert').click(function (e) {
    e.preventDefault();
    $('#noticeWrite-file').click();
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
	
	filesArr.some(function (f) {
	    return content_files.some(function (c) {
	        if (f.name === c.name && c.is_delete !== true) {
	            alert('동일한 파일이 존재합니다.');
	            fileCount -= filesArr.length;
	            filesArr = [];
	            return true;  // 내부 some() 루프 종료
	        }
	        return false;
	    });
	});
    
	// 각각의 파일 배열담기 및 기타
	filesArr.forEach(function(f) {
		var reader = new FileReader();
		reader.onload = function(e) {
			content_files.push(f);
			$('.noticeWrite-file-list').append(
				'<div id="file' + fileNum + '" style="border: 1px solid #ccc; border-radius: 3px; padding: 10px 15px; margin: 0 5px;">'
				+ '<span>' + f.name + '</span>'
				+ '<span style="color: red; font-weight: bold; cursor: pointer; margin-left: 5px;" onclick="fileDelete(\'file' + fileNum + '\')">X</span>'
				+ '<div/>'
			);
			fileNum++;
		};
		reader.readAsDataURL(f);
	});
	console.log(content_files);
	//초기화 한다.
	$("#noticeWrite-file").val("");
}

// 파일 부분 삭제 함수
function fileDelete(fileNum){
    var no = fileNum.replace(/[^0-9]/g, "");
    content_files[no].is_delete = true;
	$('#' + fileNum).remove();
	fileCount --;
    console.log(content_files);
}

// 등록 버튼 클릭 시
$('.noticeWrite-filter-insert').click(function() {
	
	var ctNoticeSubject = $('#noticeWrite-search').val();
	var ctNoticeContent = $('#noticeWrite-summernote').val();
	var ctNoticeAuthor = '서태우';
	
	var params = {
		'ctNoticeSubject': ctNoticeSubject,
		'ctNoticeContent': ctNoticeContent,
		'ctNoticeAuthor': ctNoticeAuthor
	}
	
	$.ajax({
		type: "POST",
		url: "/notice/notice",
		data: JSON.stringify(params),
		dataType: 'json',
		contentType: 'application/json',
		success: function(data) {
			console.log(JSON.stringify(data));
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

// 돌아가기 클릭 시
$('.noticeWrite-filter-back').click(function() {
	history.back();
});

/*if (fileCount > 0) {
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
}*/
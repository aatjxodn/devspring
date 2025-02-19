// DOM이 로드된 후
$(document).ready(function() {
	// 검색 
	setNoticeSearchCondition();
	// list
	noticeList();
	
	$('.header-title span').text('Notice');
});

// notice search condition
function setNoticeSearchCondition() {
	
	$("#notice-filter").select2({
        placeholder: "제목",  // placeholder 텍스트
        allowClear: true,  // X 버튼(선택 해제) 비활성화
        width: '100'  // 너비 설정
    });
	
	let comboData = [
		{ id: "subject", text: "제목" },
		{ id: "content", text: "내용" },
		{ id: "Author", text: "작성자" }
	];

	// 빈값을 유지하면서 데이터 추가
	$("#notice-filter").empty().append('<option value="">선택하세요</option>'); // 기본 선택값
	
	comboData.forEach(item => {
		let option = new Option(item.text, item.id, false, false);
		$("#notice-filter").append(option);
	});

	// 새롭게 갱신
	$("#notice-filter").trigger("change");
}


function noticeList(i) {
	
	if (i == null || i== undefined || i == '') {
		i = 1;
	}
	
	var params = {
		"nowPage" : i
	};
	
	$.ajax({
		    url: '/notice/notices',
		    method: 'GET',
			data: params,
			dataType: 'json',
			contentType: 'application/json',
		    success: function (data) {
				
		        var noticeList = data.noticeList;
				var page = data.noticePage;
				
		        var noticeTbody = $('.notice-list-table tbody');
				var noticePaging = $('.notice-paging');
				
				noticeTbody.empty();
				noticePaging.empty();

				$.each(noticeList, function(index, item) {
				    var noticeTbodyTr = $('<tr></tr>');

				    noticeTbodyTr.append('<td style="width: 100px;">' + item.ctNoticeIdx + '</td>');
				    noticeTbodyTr.append('<td style="max-width: 500px; overflow: hidden; text-overflow: ellipsis; white-space: nowrap; text-align: left;">' + item.ctNoticeSubject + '</td>');
				    noticeTbodyTr.append('<td style="width: 200px;">' + item.ctNoticeAuthor + '</td>');
				    noticeTbodyTr.append('<td style="width: 200px;">' + item.ctNoticeModifier + '</td>');
				    noticeTbodyTr.append('<td style="width: 250px;">' + item.ctNoticeCreateTime + '</td>');
				    noticeTbodyTr.append('<td style="width: 250px;">' + item.ctNoticeUpdateTime + '</td>');

				    noticeTbody.append(noticeTbodyTr);
					
					noticeTbodyTr.dblclick(function() {
						location.href='/notice/details/' + item.ctNoticeIdx;
					});
				});
				
				
				// 1번 이동
				var noticePagingFirst = $('<li></li>');
				if (page.nowPage == 1) {
					noticePagingFirst.append('<a ><<</a>');
				} else {
					noticePagingFirst.append('<a style="cursor:pointer;"><<</a>').attr('onclick', 'noticeList(1)');
				}
				noticePaging.append(noticePagingFirst);
				
				// 이전 이동
				var noticePagingPrev = $('<li></li>');
				noticePagingPrev.append('<a style="cursor:pointer;"><</a>').attr('onclick', 'noticeList('+ (page.beginPage-1) +')');
				noticePaging.append(noticePagingPrev);
				
				// 번호 이동
				for (var pageNo=page.beginPage; pageNo <= page.endPage; pageNo++) {
					var noticePagingNumber = $('<li></li>');
					if (i == pageNo) {
						noticePagingNumber.append('<a style="background-color:#384246; color:#fff; border:1px solid #384246;">' + pageNo +'</a>');
					} else {
						noticePagingNumber.append('<a style="cursor:pointer;">' + pageNo +'</a>').attr('onclick', 'noticeList('+ pageNo +')');
					}
					noticePaging.append(noticePagingNumber);
		        }
				
				// 다음 이동
				var noticePagingNext = $('<li></li>');
				noticePagingNext.append('<a style="cursor:pointer;">></a>').attr('onclick', 'noticeList('+ (page.endPage+1) +')');
				noticePaging.append(noticePagingNext);
				
				// 마지막 이동
				var noticePagingLast = $('<li></li>');
				if (page.nowPage == page.totalPage) {
					noticePagingLast.append('<a >>></a>');
				} else {
					noticePagingLast.append('<a style="cursor:pointer;">>></a>').attr('onclick', 'noticeList('+ page.totalPage +')');
				}
				noticePaging.append(noticePagingLast);

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
}


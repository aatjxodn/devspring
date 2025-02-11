
$(document).ready(function() {
	boardList();
});

function boardList(i) {
	
	if (i == null || i== undefined || i == '') {
		i = 1;
	}
	
	var params = {
		"nowPage" : i
	};
	
	
	$.ajax({
		    url: 'board/boardList',
		    method: 'GET',
			data: params,
			dataType: 'json',
			contentType: 'application/json',
		    success: function (data) {
				
		        // selectBoardList를 가져와서 반복문 실행
		        var boardList = data.selectBoardList;
		        var boardListTotal = data.selectBoardListTotal;
				
		        var boardTable = $('.board_table tbody');
				
				boardTable.empty();

		        $.each(boardList, function(index, item) {
					
		            var boardTableTr = $('<tr></tr>');
		            
		            var td1 = $('<td></td>').text(item.roNum);
		            var td2 = $('<td></td>').text(item.ctBoardIdx);
		            var td3 = $('<td></td>').text(item.ctBoardId);
		            var td4 = $('<td></td>').text(item.ctBoardSubject);
		            var td5 = $('<td></td>').text(item.ctBoardName);
		            var td6 = $('<td></td>').text(item.ctBoardCreateDate);

		            boardTableTr.append(td1, td2, td3, td4, td5, td6);
		            boardTable.append(boardTableTr);
		        });
				
				var page = data.page;
				var paging = $('.paging');
				var pagingLi = $('<li></li>');
				
				paging.empty();
				
				// 1번 이동
				if (page.nowPage == 1) {
					var pagingA = $('<a></a>').text('&#60;&#60;');
				} else {
					var pagingA = $('<a></a>').text('&#60;&#60;').attr('onclick', 'boardList(1)');
				}
				pagingLi.append(pagingA);
				
				for (var pageNo=page.beginPage; pageNo <= page.endPage; pageNo++) {
					var pagingA = $('<a></a>').text(pageNo).attr('onclick', 'boardList('+ pageNo +')');
					
					pagingLi.append(pagingA);
		        }
				
				// 마지막 이동
				var pagingA = $('<a></a>').text('&#62;&#62;').attr('onclick', 'boardList('+ page.totalPage +')');
				pagingLi.append(pagingA);
				
				paging.append(pagingLi);

		    },
			error: function(request, status, error){
				alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
			}
		});
}


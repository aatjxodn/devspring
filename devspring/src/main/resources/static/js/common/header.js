// DOM이 로드된 후
$(document).ready(function() {
	// lnb 바인딩
	setLnb();
	// mobile lnb 바인딩
	setLnbMob();
	// icon Event
	iconEvent();
});
// 화면 크기 변경 시 실행
$(window).on('resize', function() {
    mediaQuery();
});

// 현재 URL
var currentPath = window.location.pathname;

// lnb 설정
function setLnb() {
	
	$.ajax({
	    url: 'common/lnb',
	    method: 'GET',
		dataType: 'json',
	    success: function (data) {
			
			var lnbUl = $('.lnb');
			
			$.each(data, function(index, item) {
				
	            var lnbLi = $('<li></li>');
				var lnbA = $('<a></a>');

	            if (item.ctLnbUrl != '') {
	                lnbA.attr('href', item.ctLnbUrl).text(item.ctLnbName);

	                if (currentPath === item.ctLnbUrl || currentPath === '/' + item.ctLnbUrl) {
	                    lnbA.css("color", "#323232");
	                }
	            } else {
	                lnbA.text(item.ctLnbName).css("cursor", "default");
	            }
				
/*				var lnbA = $('<a></a>').text(item.ctLnbName); // a 태그 생성 및 텍스트 설정

	            if (item.ctLnbUrl != null) {
	                // 클릭 이벤트 동적으로 추가
	                lnbA.on('click', function () {
	                    asdclick(item.ctLnbUrl);
	                });

	                // 현재 경로와 비교하여 스타일 지정
	                if (currentPath === item.ctLnbUrl || currentPath === '/' + item.ctLnbUrl) {
	                    lnbA.css("color", "#323232");
	                }
	            } else {
	                // URL이 없는 경우 처리
	                lnbA.css("cursor", "default");
	            }*/

				lnbLi.append(lnbA);
				
				if (item.ctLnbSubYn == 'Y') {
					
					$.ajax({
					    url: 'common/lnbSub/' + item.ctLnbId,
					    method: 'GET',
						dataType: 'json',
					    success: function (subData) {
							
							var subUl = $('<ul></ul>');
							
							$.each(subData, function(subIndex, subItem) {
								
	                            var subLi = $('<li></li>');
								var subA = $('<a></a>');
								
								subA.attr('href', subItem.ctLnbSubUrl).text(subItem.ctLnbSubName);
								
				                if (currentPath == subItem.ctLnbSubUrl) {
				                    subA.css("color", "#323232");
				                }
								
	                            subLi.append(subA);
	                            subUl.append(subLi);
	                        });

	                        // 서브 메뉴가 다 추가되면, 이를 부모 li에 추가
	                        lnbLi.append(subUl);
							
							lnbLi.hover(function() {
								subUl.stop(true, true).slideDown(200);
							},function() {
			                    subUl.stop(true, true).slideUp(200);
							});
							
						},
						error: function(request, status, error){
							alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
						}
					});
				}
				lnbUl.append(lnbLi);
	        });
			
	    },
		error: function(request, status, error){
			alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
		}
	});
	
}

// 모바일 lnb 설정
/*function setLnbMob() {
	
	$.ajax({
	    url: 'common/lnb',
	    method: 'GET',
		dataType: 'json',
	    success: function (data) {
			
			var lnbUl = $('.lnb_mob');
			
			$.each(data, function(index, item) {
				
	            var lnbLi = $('<li></li>');
				var lnbA = $('<a></a>');

	            if (item.ctLnbUrl != null) {
	                lnbA.attr('href', item.ctLnbUrl).text(item.ctLnbName);
	                if (currentPath === item.ctLnbUrl || currentPath === '/' + item.ctLnbUrl) {
	                    lnbA.css("color", "#323232");
	                }
	            } else {
	                lnbA.text(item.ctLnbName).css("cursor", "default");
	            }

				lnbLi.append(lnbA);
				
				if (item.ctLnbSubYn == 'Y') {
					
					$.ajax({
					    url: 'common/lnbSub/' + item.ctLnbId,
					    method: 'GET',
						dataType: 'json',
					    success: function (subData) {
							
							var subUl = $('<ul></ul>');
							
							$.each(subData, function(subIndex, subItem) {
	                            // 서브 항목 li와 a 생성
	                            var subLi = $('<li></li>');
								var subA = $('<a></a>');
																
								subA.attr('href', subItem.ctLnbSubUrl).text(subItem.ctLnbSubName);
				                if (currentPath == subItem.ctLnbSubUrl) {
				                    subA.css("color", "#323232");
				                }
								
	                            subLi.append(subA);
	                            subUl.append(subLi);
	                        });

	                        // 서브 메뉴가 다 추가되면, 이를 부모 li에 추가
	                        lnbLi.append(subUl);
							
							// hover 이벤트 현재 사용 x
							lnbLi.hover(function() {
								subUl.stop(true, true).slideDown(200);
							},function() {
			                    subUl.stop(true, true).slideUp(0);
							});
							
							// click 이벤트
							lnbLi.click(function () {
							    // 현재 클릭된 lnbLi의 subUl 상태를 토글
							    $(this).find(subUl).stop(true, true).slideToggle(200);
							    
							    // 다른 lnbLi의 subUl은 닫기
								$(this).siblings(lnbLi).find(".subUl").stop(true, true).slideUp(200);
							});
							
						},
						error: function(request, status, error){
							alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
						}
					});
				}
				lnbUl.append(lnbLi);
	        });
			
	    },
		error: function(request, status, error){
			alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
		}
	});
}*/

function setLnbMob() {
    $.ajax({
        url: 'common/lnb',
        method: 'GET',
        dataType: 'json',
        success: function (data) {
            var lnbUl = $('.lnb_mob');

            $.each(data, function (index, item) {
                var lnbLi = $('<li></li>');
                var lnbA = $('<a></a>');

                if (item.ctLnbUrl != '') {
                    lnbA.attr('href', item.ctLnbUrl).text(item.ctLnbName);
                    if (currentPath === item.ctLnbUrl || currentPath === '/' + item.ctLnbUrl) {
                        lnbA.css("color", "#323232");
                    }
                } else {
                    lnbA.text(item.ctLnbName).css("cursor", "default");
                }

                lnbLi.append(lnbA);

                if (item.ctLnbSubYn == 'Y') {
                    $.ajax({
                        url: 'common/lnbSub/' + item.ctLnbId,
                        method: 'GET',
                        dataType: 'json',
                        success: function (subData) {
                            var subUl = $('<ul class="subUl"></ul>'); // 추가: 클래스 subUl 설정

                            $.each(subData, function (subIndex, subItem) {
                                var subLi = $('<li></li>');
                                var subA = $('<a></a>');

                                subA.attr('href', subItem.ctLnbSubUrl).text(subItem.ctLnbSubName);
                                if (currentPath == subItem.ctLnbSubUrl) {
                                    subA.css("color", "#323232");
                                }

                                subLi.append(subA);
                                subUl.append(subLi);
                            });

                            lnbLi.append(subUl); // 서브 메뉴 추가
                        },
                        error: function (request, status, error) {
                            alert("code:" + request.status + "\n" + "message:" + request.responseText + "\n" + "error:" + error);
                        }
                    });
                }

                lnbUl.append(lnbLi);
            });

            // 이벤트 위임으로 click 이벤트 연결
            lnbUl.on('click', 'li', function (e) {
                e.stopPropagation(); // 이벤트 전파 방지
                var subUl = $(this).find('.subUl');

                // 현재 클릭된 li의 subUl 토글
                if (subUl.length) {
                    subUl.stop(true, true).slideToggle(200);

                    // 다른 li의 subUl 닫기
                    $(this).siblings().find('.subUl').stop(true, true).slideUp(200);
                }
            });
        },
        error: function (request, status, error) {
            alert("code:" + request.status + "\n" + "message:" + request.responseText + "\n" + "error:" + error);
        }
    });
}

// 햄버거 메뉴 클릭
$('.header_hamburger').click(function() {
	if ($('.header_hamburger span').text() === "☰") {
        // 메뉴 열기
        $('.header_lnb_mob').stop(true, true).slideDown(300);
        $('.header_hamburger span').text("X");
    } else {
        // 메뉴 닫기
        $('.header_lnb_mob').stop(true, true).slideUp(300);
		$('.lnb_mob .subUl').stop(true, true).slideUp(300);
        $('.header_hamburger span').text("☰");
    }
});

// 미디어 쿼리
function mediaQuery() {
    if (window.matchMedia("(min-width: 600px)").matches) {
        // 500px 이하일 때 실행할 코드
        $('.header_lnb_mob').css("display","none");
		$('.lnb_mob .subUl').stop(true, true).slideUp(300);
		$('.header_hamburger span').text("☰");
    }
}

// icon Event
function iconEvent() {
	$('.header_icon span').hover(function() {
		$('.header_icon span').css("cursor","pointer");
	});
	$('.header_icon span').click(function() {
		location.href='/';
	});
}


function asdclick(url) {
	alert(url);
	$('.content').load(url);
}

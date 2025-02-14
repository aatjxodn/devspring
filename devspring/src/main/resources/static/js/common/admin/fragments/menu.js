// DOM이 로드된 후
$(document).ready(function() {
	setLnbMob();
});

// 화면 크기 변경 시 실행
$(window).on('resize', function() {
    mediaQuery();
});

// 현재 URL
var currentPath = window.location.pathname;
var userAuthority = 'ADMIN';

// 모바일 lnb 설정
function setLnbMob() {
    $.ajax({
        url: 'common/lnb/' + userAuthority,
        method: 'GET',
        dataType: 'json',
        success: function (data) {
			
            var lnbUl = $('.menu-lnbUl');

            $.each(data, function (index, item) {
				
                var lnbLi = $('<li></li>');
                var lnbA = $('<a></a>');

                if (item.ctLnbUrl != '') {
                    lnbA.attr('href', item.ctLnbUrl).text(item.ctLnbName);
                    if (currentPath === item.ctLnbUrl || currentPath === '/' + item.ctLnbUrl) {
                        lnbA.css("color", "#0b52a5");
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
                            var subUl = $('<ul class="menu-lnbSubUl"></ul>'); // 추가: 클래스 subUl 설정

                            $.each(subData, function (subIndex, subItem) {
                                var subLi = $('<li></li>');
                                var subA = $('<a></a>');

                                subA.attr('href', subItem.ctLnbSubUrl).text(subItem.ctLnbSubName);
                                if (currentPath == subItem.ctLnbSubUrl) {
                                    subA.css("color", "#0b52a5");
                                }

                                subLi.append(subA);
                                subUl.append(subLi);
                            });

                            lnbLi.append(subUl); // 서브 메뉴 추가
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

                lnbUl.append(lnbLi);
            });

            // 이벤트 위임으로 click 이벤트 연결
            lnbUl.on('click', 'li', function (e) {
                e.stopPropagation(); // 이벤트 전파 방지
                var subUl = $(this).find('.menu-lnbSubUl');

                // 현재 클릭된 li의 subUl 토글
                if (subUl.length) {
                    subUl.stop(true, true).slideToggle(200);

                    // 다른 li의 subUl 닫기
                    $(this).siblings().find('.menu-lnbSubUl').stop(true, true).slideUp(200);
                }
            });
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

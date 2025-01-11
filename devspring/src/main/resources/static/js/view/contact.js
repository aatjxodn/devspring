$(document).ready(function() {
    initMap();
});

function initMap() {
    var mapContainer = document.getElementById('kakaomap'), // 지도를 표시할 div
        mapOption = {
            center: new kakao.maps.LatLng(37.323620, 127.457555),
            level: getMapLevel() // 초기 확대 수준 설정
        };

    var map = new kakao.maps.Map(mapContainer, mapOption); // 지도 생성

    // 지도에 마커 추가
    var markerPosition = new kakao.maps.LatLng(37.323620, 127.457555); // 마커 위치
    var marker = new kakao.maps.Marker({
        position: markerPosition
    });
    marker.setMap(map); // 지도에 마커 표시

    // 윈도우 크기가 변경될 때마다 확대 수준 변경
    $(window).resize(function() {
        map.setLevel(getMapLevel()); // 확대 수준 변경
    });
}

// 화면 크기에 맞는 확대 수준을 반환하는 함수
function getMapLevel() {
    var width = window.innerWidth;

    if (width < 600) {
        return 4; // 작은 화면에서는 좀 더 확대된 수준
    } else if (width < 1200) {
        return 3; // 중간 크기 화면에서는 보통 수준
    } else {
        return 3; // 큰 화면에서는 더 축소된 수준
    }
}
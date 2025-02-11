// DOM이 로드된 후
$(document).ready(function() {
	$('#footer div span').hover(function() {
		$('#footer div span').css("cursor","pointer");
	});
	$('#footer div span').click(function() {
		location.href='/';
	});
});

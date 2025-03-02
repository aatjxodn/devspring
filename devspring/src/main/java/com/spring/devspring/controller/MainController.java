package com.spring.devspring.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	
	@Value("${kakao.api.key}")
    private String kakaoApiKey;
	
	// root
	@GetMapping("/")
	public String main() {
		return "view/user/main/main";
	}
	// Information about us
	@GetMapping("/about")
	public String about() {
		return "view/user/sub/about";
	}
	// Service service1
	@GetMapping("/service1")
	public String service1() {
		return "view/user/sub/service1";
	}
	// Service service2
	@GetMapping("/service2")
	public String service2() {
		return "view/user/sub/service2";
	}
	// Service service3
	@GetMapping("/service3")
	public String service3() {
		return "view/user/sub/service3";
	}
	// Service service4
	@GetMapping("/service4")
	public String service4() {
		return "view/user/sub/service4";
	}
	// Contact mail
	@GetMapping("/email")
	public String email() {
		return "view/user/sub/email";
	}
	// Contact contact
	@GetMapping("/location")
	public String location(ModelMap model) {
		model.addAttribute("KakaoAppKey", this.kakaoApiKey);
		return "view/user/sub/location";
	}
	
	
	// Admin -----------------------------------------------------------------------------------------------------------------
	// Admin
	@GetMapping("/admin")
	public String admin() {
		return "view/admin/main/login";
	}
	// Admin Main
	@GetMapping("/adminMain")
	public String adminMain() {
		return "view/admin/main/admin";
	}
	// Admin Main
	@GetMapping("/userList")
	public String adminNew() {
		return "view/admin/sub/userList";
	}
	// test board
	@GetMapping("/board")
	public String board() {
		return "view/user/sub/board";
	}
	// Admin Notice
	@GetMapping("/notice")
	public String adminNotice() {
		return "view/admin/sub/notice";
	}
	// Admin Notice
	@GetMapping("/noticeWrite")
	public String adminNoticeWrite() {
		return "view/admin/sub/noticeWrite";
	}
	
	
	
	// test -----------------------------------------------------------------------------------------------------------------
	// test
	@GetMapping("/adminTest")
	public String adminTest() {
		return "view/admin/sub/test";
	}

}

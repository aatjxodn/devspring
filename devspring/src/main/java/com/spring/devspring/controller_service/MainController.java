package com.spring.devspring.controller_service;

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
	public String Main() {
		return "view/user/main/main";
	}
	// Information about us
	@GetMapping("/about")
	public String About() {
		return "view/user/sub/about";
	}
	// Service service1
	@GetMapping("/service1")
	public String Service1() {
		return "view/user/sub/service1";
	}
	// Service service2
	@GetMapping("/service2")
	public String Service2() {
		return "view/user/sub/service2";
	}
	// Service service3
	@GetMapping("/service3")
	public String Service3() {
		return "view/user/sub/service3";
	}
	// Service service4
	@GetMapping("/service4")
	public String Service4() {
		return "view/user/sub/service4";
	}
	// Contact mail
	@GetMapping("/email")
	public String Email() {
		return "view/user/sub/email";
	}
	// Contact contact
	@GetMapping("/location")
	public String Location(ModelMap model) {
		model.addAttribute("KakaoAppKey", this.kakaoApiKey);
		return "view/user/sub/location";
	}
	// test board
	@GetMapping("/board")
	public String Board() {
		return "view/user/sub/board";
	}
	// Admin
	@GetMapping("/admin")
	public String Admin() {
		return "view/admin/main/login";
	}
	// Admin Main
	@GetMapping("/adminMain")
	public String AdminMain() {
		return "view/admin/main/admin";
	}
	// Admin Main
	@GetMapping("/userList")
	public String adminNew() {
		return "view/admin/sub/userList";
	}

}

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
		return "view/main";
	}
	
	// information about us
	@GetMapping("/company")
	public String company() {
		return "view/company";
	}
	
	// Service service1
	@GetMapping("/service1")
	public String Service1() {
		return "view/service1";
	}
	// Service service2
	@GetMapping("/service2")
	public String Service2() {
		return "view/service2";
	}
	// Service service3
	@GetMapping("/service3")
	public String Service3() {
		return "view/service3";
	}
	// Service service4
	@GetMapping("/service4")
	public String Service4() {
		return "view/service4";
	}
	
	// contact mail
	@GetMapping("/mail")
	public String Mail() {
		return "view/mail";
	}
	// contact contact
	@GetMapping("/contact")
	public String Contact(ModelMap model) {
		model.addAttribute("KakaoAppKey", this.kakaoApiKey);
		return "view/contact";
	}
	
	// test board
	@GetMapping("/board")
	public String Board() {
		return "view/board";
	}

}

package com.spring.devspring.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.devspring.dto.LnbDTO;
import com.spring.devspring.dto.LnbSubDTO;
import com.spring.devspring.service.CommonService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/common")
@RequiredArgsConstructor
public class CommonController {
	
	private final CommonService commonService;
	
	// lnb 조회
	@GetMapping("/lnb/{userAuthority}")
	@ResponseBody
	public List<LnbDTO> getLnb(@PathVariable("userAuthority") String userAuthority) {
		return this.commonService.getLnb(userAuthority);
	}
	
	// lnb Sub 조회
	@GetMapping("/lnbSub/{id}")
	@ResponseBody
	public List<LnbSubDTO> getLnbSub(@PathVariable("id") String id) {
		return this.commonService.getLnbSub(id);
	}

}

package com.spring.devspring.controller_service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.devspring.dto.LnbDTO;
import com.spring.devspring.dto.LnbSubDTO;
import com.spring.devspring.mapper.CommonMapper;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/common")
@RequiredArgsConstructor
public class CommonController {
	
	private final CommonService commonService;
	
	// lnb 조회
	@GetMapping("/lnb")
	@ResponseBody
	public List<LnbDTO> getLnbList() {
		return this.commonService.getLnbList();
	}
	
	// lnb Sub 조회
	@GetMapping("/lnbSub/{id}")
	@ResponseBody
	public List<LnbSubDTO> getLnbSubList(@PathVariable("id") String id) {
		return this.commonService.getLnbSubList(id);
	}

}

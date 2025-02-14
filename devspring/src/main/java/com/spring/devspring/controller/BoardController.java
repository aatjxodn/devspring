package com.spring.devspring.controller;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.devspring.service.BoardService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {
	
	private final BoardService BoardService;
	
	@GetMapping("/boards")
	@ResponseBody
	public LinkedHashMap<String, Object> getBoardList(@RequestParam(required = false) Map<String, Object> params) {
		return this.BoardService.getBoardList(params);
	}

}

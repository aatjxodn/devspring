package com.spring.devspring.controller;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.devspring.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	private final BoardService BoardService;
	
	public BoardController(BoardService BoardService) {
        this.BoardService = BoardService;
    }
	
	@GetMapping("/boardList")
	@ResponseBody
	public LinkedHashMap<String, Object> getBoardList(@RequestParam(required=false) Map<String, Object> params) {
		return this.BoardService.getBoardList(params);
	}

}

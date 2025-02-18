package com.spring.devspring.controller;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.spring.devspring.service.NoticeService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/notice")
@RequiredArgsConstructor
public class NoticeController {
	
	private final NoticeService noticeService;
	
	// notice 조회
	@GetMapping("/notices")
	@ResponseBody
	public LinkedHashMap<String, Object> getNotices(@RequestParam(required = false) Map<String, Object> params) {
		return this.noticeService.getNotices(params);
	}
	
	// notice 다중 파일 업로드
	@PostMapping("/fileUpload")
	@ResponseBody
	public void getFileUpload(@RequestParam("files") List<MultipartFile> files) throws IOException {
		for (MultipartFile multipartFile : files) {
			this.noticeService.getFileUpload(multipartFile);
        }
	}

}

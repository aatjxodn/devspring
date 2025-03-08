package com.spring.devspring.controller;

import java.io.IOException;
import java.security.Principal;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.multipart.MultipartFile;

import com.spring.devspring.dto.NoticeDTO;
import com.spring.devspring.dto.NoticeFileDTO;
import com.spring.devspring.service.NoticeService;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/notice")
@RequiredArgsConstructor
public class NoticeController {
	
	private final NoticeService noticeService;
	
	// notices 조회
	@ResponseStatus(HttpStatus.OK)
	@GetMapping("/notices")
	@ResponseBody
	public LinkedHashMap<String, Object> getNotices(@RequestParam(required = false) Map<String, Object> params) {
		return this.noticeService.getNotices(params);
	}
	
	// notice 조회
	@ResponseStatus(HttpStatus.OK)
	@GetMapping("/{ctNoticeIdx}")
	public String getNotice(@PathVariable("ctNoticeIdx") int ctNoticeIdx, Model model) {
		
		NoticeDTO notice = this.noticeService.getNotice(ctNoticeIdx);
		List<NoticeFileDTO> noticeFile = this.noticeService.getNoticeFile(ctNoticeIdx);
		
		model.addAttribute("notice", notice);
		model.addAttribute("noticeFile", noticeFile);
		return "view/admin/sub/noticeDetails";
	}
	
	// notice 등록
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("/notice")
	@ResponseBody
	public ResponseEntity<NoticeDTO> getNoticeInsert(@RequestBody NoticeDTO params, HttpServletRequest request) {
	    NoticeDTO insertedNotice = noticeService.getNoticeInsert(params, request);
	    if (insertedNotice != null) {
	        return ResponseEntity.status(HttpStatus.CREATED).body(insertedNotice);
	    }
	    return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	}
	
	// notice 파일 업로드
	@PostMapping("/fileUpload")
	@ResponseBody
	public void getFileUpload(@RequestParam("files") List<MultipartFile> files, @RequestParam("ctNoticeIdx") int ctNoticeIdx) throws IOException {
		for (MultipartFile multipartFile : files) {
			this.noticeService.getFileUpload(multipartFile, ctNoticeIdx);
        }
	}
	
	// notice 이미지 업로드
    @PostMapping("/imageUpload")
    @ResponseBody
    public ResponseEntity<?> getImageUpload(@RequestParam("file") MultipartFile file) throws Exception{
		return this.noticeService.getImageUpload(file);
    }

    // notice 이미지 삭제
    @PostMapping("/imageDelete")
    @ResponseBody
    public void getImageDelete(@RequestParam("file") String file) throws Exception{
    	this.noticeService.getImageDelete(file);
    }

}

package com.spring.devspring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.devspring.dto.MailDTO;
import com.spring.devspring.service.EmailService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/mail")
@RequiredArgsConstructor
public class EmailController {

	private final EmailService emailService;

    @PostMapping("/sendEmail")
    @ResponseBody
    public void getSendEmail(@RequestBody MailDTO params) {
    	this.emailService.getSendEmail(params);
    }
}
package com.spring.devspring.controller_service;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.devspring.dto.MailDTO;

@Controller
@RequestMapping("/mail")
public class EmailController {

	private final EmailService emailService;

    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }

    @PostMapping("/sendEmail")
    @ResponseBody
    public void getSendEmail(@RequestBody MailDTO params) {
    	this.emailService.getSendEmail(params);
    }
}
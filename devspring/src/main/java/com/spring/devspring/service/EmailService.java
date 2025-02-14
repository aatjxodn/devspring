package com.spring.devspring.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import com.spring.devspring.dto.MailDTO;
import com.spring.devspring.exception.CustomException;
import com.spring.devspring.exception.ErrorCode;

import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class EmailService {

	private final JavaMailSender mailSender;
	
	@Value("${spring.mail.username}")
    private String senderEmail;
	
	@Value("${mail.receiver}")
    private String receiverEmail;

    // mail 전송
    public void getSendEmail(MailDTO params) {
    	
    	try {
    		
    		MimeMessage message = this.mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);

            helper.setFrom(this.senderEmail);  // 보낸 사람 (SMTP 인증 계정)
            helper.setTo(this.receiverEmail);  // 받는 사람 (SMTP 인증 계정)
            helper.setSubject(params.getSubject());  // 이메일 제목
            helper.setText(
                "Name: " + params.getName() + "\n" +
                "Email: " + params.getEmail() + "\n\n" +
                "Message:\n" + params.getContent()
            );
            helper.setReplyTo(params.getEmail());  // 응답 시 사용자의 이메일로 답장 가능

            this.mailSender.send(message);
            
    	} catch (Exception e) {
            throw new CustomException(ErrorCode.INTERNAL_SERVER_ERROR);
    	}
    }
}
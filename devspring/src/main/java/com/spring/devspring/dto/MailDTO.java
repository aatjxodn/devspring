package com.spring.devspring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MailDTO {
	
	private String name;
    private String subject;
    private String email;
    private String content;
    
}
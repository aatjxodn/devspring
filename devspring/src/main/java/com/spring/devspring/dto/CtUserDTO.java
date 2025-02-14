package com.spring.devspring.dto;

import java.time.LocalDateTime;

import org.springframework.security.crypto.password.PasswordEncoder;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.spring.devspring.user.UserRole;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CtUserDTO {
	
	private int ctUserIdx;
	private String ctUserId;
	private String ctUserPwd;
	private String ctUserPwdNewConfirm;
	private String ctUserName;
	private String ctUserEmail;
	private String ctUserPhoneNumber;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm", timezone = "Asia/Seoul")
	private LocalDateTime ctUserCreateTime;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm", timezone = "Asia/Seoul")
	private LocalDateTime ctUserUpdateTime;
	
	private UserRole ctUserAuthority;

    public static CtUserDTO createUser(CtUserParaDTO ctUserParaDTO, PasswordEncoder passwordEncoder){
    	
    	CtUserDTO user = new CtUserDTO();
        
        user.setCtUserId(ctUserParaDTO.getCtUserId());
        user.setCtUserPwd(passwordEncoder.encode(ctUserParaDTO.getCtUserPwd()));
        user.setCtUserName(ctUserParaDTO.getCtUserName());
        user.setCtUserEmail(ctUserParaDTO.getCtUserEmail());
        user.setCtUserPhoneNumber(ctUserParaDTO.getCtUserPhoneNumber());
        user.setCtUserCreateTime(LocalDateTime.now());
        user.setCtUserUpdateTime(LocalDateTime.now());
        user.setCtUserAuthority(UserRole.ADMIN);
        
        return user;
    }
    
    public static CtUserDTO passwordUpdateUser(CtUserParaDTO ctUserParaDTO, PasswordEncoder passwordEncoder){
    	
    	CtUserDTO user = new CtUserDTO();
        
        user.setCtUserId(ctUserParaDTO.getCtUserId());
        user.setCtUserPwd(passwordEncoder.encode(ctUserParaDTO.getCtUserPwd()));
        user.setCtUserPwdNewConfirm(passwordEncoder.encode(ctUserParaDTO.getCtUserPwdNewConfirm()));
        
        user.setCtUserUpdateTime(LocalDateTime.now());
        
        return user;
    }
	
}
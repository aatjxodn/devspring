package com.spring.devspring.dto;

import java.time.LocalDateTime;

import org.springframework.security.crypto.password.PasswordEncoder;

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
	private String ctUserName;
	private String ctUserEmail;
	private String ctUserPhoneNumber;
	
	private LocalDateTime ctUserCreateTime;
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
	
}
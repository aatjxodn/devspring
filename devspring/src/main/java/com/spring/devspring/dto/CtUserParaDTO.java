package com.spring.devspring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CtUserParaDTO {
	
    private String ctUserId;
    private String ctUserPwd;
    private String ctUserPwdNewConfirm;
    private String ctUserName;
    private String ctUserEmail;
    private String ctUserPhoneNumber;
    private String ctUserCreateTime;
    private String ctUserUpdateTime;
    private String ctUserAuthority;
	
}
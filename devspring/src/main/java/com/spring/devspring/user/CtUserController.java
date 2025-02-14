package com.spring.devspring.user;

import lombok.RequiredArgsConstructor;

import java.security.Principal;
import java.util.HashMap;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.devspring.dto.CtUserDTO;
import com.spring.devspring.dto.CtUserParaDTO;

import jakarta.servlet.http.HttpServletRequest;

@RequestMapping("/user")
@Controller
@RequiredArgsConstructor
public class CtUserController {

    private final CtUserService djsUserService;
    private final PasswordEncoder passwordEncoder;
    
    // 사용자 - 세션 확인
    @GetMapping(value="/session")
    @ResponseBody
    public HashMap<String, String> getSessionInfo(Principal principal, HttpServletRequest request) {
        return this.djsUserService.getSessionInfo(principal, request);
    }

    // 사용자 - 회원가입
    @PostMapping(value="/signup")
    @ResponseBody
    public void getInsertUser(@RequestBody(required = false) CtUserParaDTO ctUserParaDto){
        CtUserDTO user = CtUserDTO.createUser(ctUserParaDto, passwordEncoder);
        this.djsUserService.getInsertUser(user);
    }
    
    // 사용자 - 비밀번호 변경
    @PatchMapping(value="/user")
    @ResponseBody
    public void getUpdatePassword(@RequestBody(required = false) CtUserParaDTO ctUserParaDto) {
    	CtUserDTO user = CtUserDTO.passwordUpdateUser(ctUserParaDto, passwordEncoder);
        this.djsUserService.getUpdatePassword(user);
    }
    
    
}
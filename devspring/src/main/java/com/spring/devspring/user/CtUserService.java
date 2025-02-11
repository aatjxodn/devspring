package com.spring.devspring.user;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.security.Principal;
import java.time.LocalDateTime;
import java.util.HashMap;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.spring.devspring.dto.CtUserDTO;
import com.spring.devspring.mapper.CtUserMapper;

@Slf4j
@Service
@RequiredArgsConstructor
public class CtUserService implements UserDetailsService {

    private final CtUserMapper ctUserMapper;
    
    public void saveMember(CtUserDTO ctUserDto){
    	
//    	CtUserDTO findByDjsUserId = ctUserMapper.findByCtUserId(ctUserDTO.getCtUserId());
//    	
//        if(findByDjsUserId != null){
//            throw new IllegalStateException("이미 가입된 회원입니다.");
//        }
    	
        ctUserMapper.insertUser(ctUserDto);
    }

    // 사용자 - login
    public UserDetails loadUserByUsername(String ctUserId) throws UsernameNotFoundException {

    	CtUserDTO ctUser = ctUserMapper.findByCtUserId(ctUserId);
        
        if(ctUser == null){
            throw new UsernameNotFoundException(ctUserId);
        }
        
        log.info("djsUser : " + ctUser.getCtUserId());

        return User.builder()
                .username(ctUser.getCtUserId())
                .password(ctUser.getCtUserPwd())
                .roles(ctUser.getCtUserAuthority().toString())
                .build();
    }

    // 사용자 - 세션 확인
//	public HashMap<String, String> getSessionInfo(Principal principal, HttpServletRequest request) {
//		
//		HashMap<String, String> result = new HashMap<>();
//		
//		HttpSession session = null;
//		
//		if (principal != null) {
//			
//			session = request.getSession();
//			
//			if (session.getAttribute("djsUserId") != null) {
//				
//				result.put("djsUserId", session.getAttribute("djsUserId").toString());
//				result.put("djsUserPwd", session.getAttribute("djsUserPwd").toString());
//				result.put("djsUserName", session.getAttribute("djsUserName").toString());
//				result.put("djsUserEmail", session.getAttribute("djsUserEmail").toString());
//				result.put("djsUserPhoneNumber", session.getAttribute("djsUserPhoneNumber").toString());
//				result.put("djsUserAuthority", session.getAttribute("djsUserAuthority").toString());
//				
//			} else {
//				
//				CtUserDTO djsUser = this.ctUserMapper.findByCtUserId(principal.getName());
//				
//				session.setAttribute("djsUserId", djsUser.getDjsUserId());
//				session.setAttribute("djsUserPwd", djsUser.getDjsUserPwd());
//				session.setAttribute("djsUserName", djsUser.getDjsUserName());
//				session.setAttribute("djsUserEmail", djsUser.getDjsUserEmail());
//				session.setAttribute("djsUserPhoneNumber", djsUser.getDjsUserPhoneNumber());
//				session.setAttribute("djsUserAuthority", djsUser.getUserRole().toString());
//				
//				result.put("djsUserId", session.getAttribute("djsUserId").toString());
//				result.put("djsUserPwd", session.getAttribute("djsUserPwd").toString());
//				result.put("djsUserName", session.getAttribute("djsUserName").toString());
//				result.put("djsUserEmail", session.getAttribute("djsUserEmail").toString());
//				result.put("djsUserPhoneNumber", session.getAttribute("djsUserPhoneNumber").toString());
//				result.put("djsUserAuthority", session.getAttribute("djsUserAuthority").toString());
//			}
//		}
//		
//		return result;
//	}

}

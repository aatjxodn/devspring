package com.spring.devspring.user;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.security.Principal;
import java.util.HashMap;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.spring.devspring.dto.CtUserDTO;
import com.spring.devspring.exception.CustomException;
import com.spring.devspring.exception.ErrorCode;
import com.spring.devspring.mapper.CtUserMapper;

@Slf4j
@Service
@RequiredArgsConstructor
public class CtUserService implements UserDetailsService {

    private final CtUserMapper ctUserMapper;
    
    // 사용자 - 회원가입
    public void getInsertUser(CtUserDTO ctUserDto){
    	
    	CtUserDTO ctUser = ctUserMapper.findByCtUserId(ctUserDto.getCtUserId());
    	
        if(ctUser != null){
        	log.info("이미 가입된 사용자입니다.");
            throw new IllegalStateException("이미 가입된 사용자입니다.");
        }
    	
        ctUserMapper.insertUser(ctUserDto);
    }

    // 사용자 - login
    public UserDetails loadUserByUsername(String ctUserId) throws UsernameNotFoundException {

    	CtUserDTO ctUser = ctUserMapper.findByCtUserId(ctUserId);
        
        if(ctUser == null){
        	log.info("로그인 ID가 없습니다.");
            throw new UsernameNotFoundException(ctUserId);
        }
        
        log.info("ctUser : " + ctUser.getCtUserId());

        return User.builder()
                .username(ctUser.getCtUserId())
                .password(ctUser.getCtUserPwd())
                .roles(ctUser.getCtUserAuthority().toString())
                .build();
    }

    // 사용자 - 세션 확인
	public HashMap<String, String> getSessionInfo(Principal principal, HttpServletRequest request) {
		
		HashMap<String, String> result = new HashMap<>();
		
		HttpSession session = null;
		
		if (principal != null) {
			
			session = request.getSession();
			
			if (session.getAttribute("ctUserId") != null) {
				
				result.put("ctUserId", session.getAttribute("ctUserId").toString());
				result.put("ctUserPwd", session.getAttribute("ctUserPwd").toString());
				result.put("ctUserName", session.getAttribute("ctUserName").toString());
				result.put("ctUserEmail", session.getAttribute("ctUserEmail").toString());
				result.put("ctUserPhoneNumber", session.getAttribute("ctUserPhoneNumber").toString());
				result.put("ctUserAuthority", session.getAttribute("ctUserAuthority").toString());
				
			} else {
				
				CtUserDTO ctUser = this.ctUserMapper.findByCtUserId(principal.getName());
				
				session.setAttribute("ctUserId", ctUser.getCtUserId());
				session.setAttribute("ctUserPwd", ctUser.getCtUserPwd());
				session.setAttribute("ctUserName", ctUser.getCtUserName());
				session.setAttribute("ctUserEmail", ctUser.getCtUserEmail());
				session.setAttribute("ctUserPhoneNumber", ctUser.getCtUserPhoneNumber());
				session.setAttribute("ctUserAuthority", ctUser.getCtUserAuthority().toString());
				
				result.put("ctUserId", session.getAttribute("ctUserId").toString());
				result.put("ctUserPwd", session.getAttribute("ctUserPwd").toString());
				result.put("ctUserName", session.getAttribute("ctUserName").toString());
				result.put("ctUserEmail", session.getAttribute("ctUserEmail").toString());
				result.put("ctUserPhoneNumber", session.getAttribute("ctUserPhoneNumber").toString());
				result.put("ctUserAuthority", session.getAttribute("ctUserAuthority").toString());
			}
		}
		
		return result;
	}

	// 사용자 - 비밀번호 변경
	public void getUpdatePassword(CtUserDTO ctUserDto) {
		
		CtUserDTO ctUser = this.ctUserMapper.findByCtUserIdAndCtUserPwd(ctUserDto.getCtUserId(), ctUserDto.getCtUserPwd());
		
		if (ctUser == null) {
			throw new CustomException("[비밀번호 변경 - 사용자를 찾을 수 없습니다.]", ErrorCode.Internal_Server_Error);
		}
		
		try {
			ctUser.setCtUserPwd(ctUserDto.getCtUserPwdNewConfirm());
			this.ctUserMapper.updatePassword(ctUserDto);
		} catch (Exception e) {
			throw new CustomException("[비밀번호 변경 - 변경에 실패했습니다.]", ErrorCode.Internal_Server_Error);
		}
	}

}

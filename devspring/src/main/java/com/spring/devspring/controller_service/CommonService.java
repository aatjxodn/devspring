package com.spring.devspring.controller_service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.spring.devspring.config.CustomAuthenticationEntryPoint;
import com.spring.devspring.config.CustomException;
import com.spring.devspring.config.CustomLoginFailHandler;
import com.spring.devspring.config.CustomLoginSuccessHandler;
import com.spring.devspring.config.CustomLogoutSuccessHandler;
import com.spring.devspring.config.ErrorCode;
import com.spring.devspring.dto.LnbDTO;
import com.spring.devspring.dto.LnbSubDTO;
import com.spring.devspring.mapper.CommonMapper;
import com.spring.devspring.user.CtUserService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class CommonService {
	
	private final CommonMapper CommonMapper;

	// lnb 조회
	public List<LnbDTO> getLnbList() {
		try {
			return this.CommonMapper.selectLnbList();
		} catch (Exception e) {
			throw new CustomException(ErrorCode.INTERNAL_SERVER_ERROR);
		}
	}
	
	// lnb Sub 조회
	public List<LnbSubDTO> getLnbSubList(String id) {
		try {
			return this.CommonMapper.selectLnbSubList(id);
		} catch (Exception e) {
			throw new CustomException(ErrorCode.INTERNAL_SERVER_ERROR);
		}
	}

	

}

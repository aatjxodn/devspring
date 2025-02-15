package com.spring.devspring.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.spring.devspring.dto.LnbDTO;
import com.spring.devspring.dto.LnbSubDTO;
import com.spring.devspring.exception.CustomException;
import com.spring.devspring.exception.ErrorCode;
import com.spring.devspring.mapper.CommonMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class CommonService {
	
	private final CommonMapper CommonMapper;

	// lnb 조회
	public List<LnbDTO> getLnb(String userAuthority) {
		try {
			return this.CommonMapper.selectLnbList(userAuthority);
		} catch (Exception e) {
			throw new CustomException("[Lnb 조회 error 발생]", ErrorCode.Internal_Server_Error);
		}
	}
	
	// lnb Sub 조회
	public List<LnbSubDTO> getLnbSub(String id) {
		try {
			return this.CommonMapper.selectLnbSubList(id);
		} catch (Exception e) {
			throw new CustomException("[Lnb Sub 조회 error 발생]", ErrorCode.Internal_Server_Error);
		}
	}

	

}

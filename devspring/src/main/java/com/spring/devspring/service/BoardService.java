package com.spring.devspring.service;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.devspring.dto.PagingDTO;
import com.spring.devspring.exception.CustomException;
import com.spring.devspring.exception.ErrorCode;
import com.spring.devspring.mapper.BoardMapper;

@Service
public class BoardService {
	
	@Autowired
	private final BoardMapper BoardMapper;
	
	public BoardService(BoardMapper BoardMapper) {
        this.BoardMapper = BoardMapper;
    }

	public LinkedHashMap<String, Object> getBoardList(Map<String, Object> params) {
		PagingDTO page = new PagingDTO();
		LinkedHashMap<String, Object> map = new LinkedHashMap<>();
		
		String dd = (String) params.get("nowPage"); // params에서 dd 값 가져오기
	    int nowPage = 1;
	    
	    try {
	        if (dd != null && !dd.isEmpty()) {
	            nowPage = Integer.parseInt(dd); // 문자열을 정수로 변환
	        }
	    } catch (NumberFormatException e) {
	    	throw new CustomException("[boards 조회 error 발생]", ErrorCode.Internal_Server_Error);
	    }
	    
	    int selectBoardListTotal = this.BoardMapper.selectBoardListTotal();
		
		page.setNowPage(nowPage);
		page.setPagesLimit(page, selectBoardListTotal);
		
		map.put("page", page);
		map.put("selectBoardList", this.BoardMapper.selectBoardList(page.getBegin(), page.getEnd()));
		map.put("selectBoardListTotal", selectBoardListTotal);
		
		return map;
	}
	
}

package com.spring.devspring.service;

import java.io.File;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.spring.devspring.dto.NoticeFileDTO;
import com.spring.devspring.dto.PagingDTO;
import com.spring.devspring.exception.CustomException;
import com.spring.devspring.exception.ErrorCode;
import com.spring.devspring.mapper.NoticeMapper;
import com.spring.devspring.mapper.NoticeFileMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class NoticeService {
	
    @Value("${notice.file.dir}")
    private String noticeFileDir;
    
    @Value("${notice.image.dir}")
    private String noticeImageDir;
	
    private final NoticeMapper noticeMapper;
    private final NoticeFileMapper noticeFileMapper;
	
	public LinkedHashMap<String, Object> getNotices(Map<String, Object> params) {
		
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
	    
	    int selectBoardListTotal = this.noticeMapper.selectBoardListTotal();
		
		page.setNowPage(nowPage);
		page.setPagesLimit(page, selectBoardListTotal);
		
		map.put("page", page);
		map.put("selectBoardList", this.noticeMapper.selectBoardList(page.getBegin(), page.getEnd()));
		map.put("selectBoardListTotal", selectBoardListTotal);
		
		return map;
	}

    public void getFileUpload(MultipartFile files) throws IOException {
    	
        if (files.isEmpty()) {
            throw new CustomException("[Notice 파일 para가 없습니다.]", ErrorCode.Bad_Request);
        }

        // 원래 파일 이름 추출
        String origName = files.getOriginalFilename();
        // 확장자 추출(ex : .png)
        String extension = origName.substring(origName.lastIndexOf("."));
        // 파일 이름으로 쓸 랜덤 uuid와 확장자 결합
        String savedName = UUID.randomUUID().toString() + extension;
        // 파일을 불러올 때 사용할 파일 경로
        String savedPath = noticeFileDir + savedName;

        // 파일 엔티티 생성
        NoticeFileDTO file = NoticeFileDTO.builder()
                .orgNm(origName)
                .savedNm(savedName)
                .savedPath(savedPath)
                .build();

        // 실제로 로컬에 uuid를 파일명으로 저장
        files.transferTo(new File(savedPath));

        // 데이터베이스에 파일 정보 저장 
        this.noticeFileMapper.save(file);
    }

}

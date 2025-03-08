package com.spring.devspring.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.Principal;
import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.spring.devspring.dto.NoticeDTO;
import com.spring.devspring.dto.NoticeFileDTO;
import com.spring.devspring.dto.PagingDTO;
import com.spring.devspring.exception.CustomException;
import com.spring.devspring.exception.ErrorCode;
import com.spring.devspring.mapper.NoticeMapper;

import groovyjarjarantlr4.v4.parse.ANTLRParser.throwsSpec_return;
import jakarta.servlet.http.HttpServletRequest;

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
	
    // notices 조회
	public LinkedHashMap<String, Object> getNotices(Map<String, Object> params) {
		
		PagingDTO noticePage = new PagingDTO();
		LinkedHashMap<String, Object> map = new LinkedHashMap<>();
		
		int nowPage = Integer.parseInt(params.get("nowPage").toString()); // params에서 dd 값 가져오기
	    
	    int selectBoardListTotal = this.noticeMapper.count();
	    
	    noticePage.setNumPerPage(50);
	    noticePage.setNowPage(nowPage);
	    noticePage.setPagesLimit(noticePage, selectBoardListTotal);
		
		map.put("noticePage", noticePage);
		map.put("noticeList", this.noticeMapper.findAll(noticePage.getBegin(), noticePage.getEnd()));
		
		return map;
	}
	
	// notice 조회
	public NoticeDTO getNotice(int ctNoticeIdx) {
		return this.noticeMapper.findByCtNoticeIdx(ctNoticeIdx);
	}
	
	// notice 등록
	public NoticeDTO getNoticeInsert(NoticeDTO notice, HttpServletRequest request) {
		
		notice.setCtNoticeAuthor(request.getSession().getAttribute("ctUserName").toString());
		
        int result = noticeMapper.insertNotice(notice); // 삽입 실행 (결과는 1 또는 0)
        if (result == 0) {
            throw new CustomException("[notice 등록에 실패했습니다.]", ErrorCode.Internal_Server_Error);
        }
        return notice;
    }

	// notice 파일 업로드
    public void getFileUpload(MultipartFile files, int ctNoticeIdx) throws IOException {
    	
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
        		.ctNoticeIdx(ctNoticeIdx)
                .ctNoticeFileOriginalName(origName)
                .ctNoticeFileSavedName(savedName)
                .ctNoticeFileSavedPath(savedPath)
                .ctNoticeFileCreateTime(LocalDateTime.now())
                .build();

        // 실제로 로컬에 uuid를 파일명으로 저장
        files.transferTo(new File(savedPath));

        // 데이터베이스에 파일 정보 저장 
        this.noticeFileMapper.save(file);
    }

    // notice 이미지 업로드
	public ResponseEntity<?> getImageUpload(MultipartFile file) {
		try {
            // 업로드 파일의 이름
            String originalFileName = file.getOriginalFilename();
            // 업로드 파일의 확장자
            String fileExtension = originalFileName.substring(originalFileName.lastIndexOf("."));
            // 업로드 된 파일이 중복될 수 있어서 파일 이름 재설정
            String reFileName = UUID.randomUUID().toString() + fileExtension;
            // 업로드 경로에 파일명을 변경하여 저장
            file.transferTo(new File(noticeImageDir, reFileName));
            // 파일이름을 재전송
            return ResponseEntity.ok(reFileName);
            
        }catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body("업로드 에러");
        }
		
	}

	// notice 이미지 삭제
	public void getImageDelete(String file) {
        try {
            Path path = Paths.get(noticeImageDir, file);
            Files.delete(path);
        }catch (Exception e) {
            e.printStackTrace();
        }
	}

	// noticeFile 상세정보
	public List<NoticeFileDTO> getNoticeFile(int ctNoticeIdx) {
		return this.noticeFileMapper.findByCtNoticeIdx(ctNoticeIdx);
	}


}

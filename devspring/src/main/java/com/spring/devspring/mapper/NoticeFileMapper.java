package com.spring.devspring.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import com.spring.devspring.dto.NoticeFileDTO;

@Mapper
public interface NoticeFileMapper {
	// notice 저장
	void save(NoticeFileDTO file);
	// 파일 상세정보
	List<NoticeFileDTO> findByCtNoticeIdx(int ctNoticeIdx);
}

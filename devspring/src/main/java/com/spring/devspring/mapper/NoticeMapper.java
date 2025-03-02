package com.spring.devspring.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.spring.devspring.dto.NoticeDTO;

@Mapper
public interface NoticeMapper {
	
	// notices 조회
	List<NoticeDTO> findAll(@Param("begin") int begin,@Param("end") int end);
	// notice count 조회
	int count();
	// notice 조회
	NoticeDTO findByCtNoticeIdx(int ctNoticeIdx);
	// notice 등록
	void insertNotice(NoticeDTO params);

}

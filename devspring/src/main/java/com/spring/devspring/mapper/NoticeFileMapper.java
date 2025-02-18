package com.spring.devspring.mapper;

import org.apache.ibatis.annotations.Mapper;
import com.spring.devspring.dto.NoticeFileDTO;

@Mapper
public interface NoticeFileMapper {
	// notice file save
	void save(NoticeFileDTO file);
}

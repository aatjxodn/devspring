package com.spring.devspring.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.spring.devspring.dto.BoardDTO;

@Mapper
public interface NoticeMapper {
	
	// board 조회
	List<BoardDTO> selectBoardList(@Param("begin") int begin,@Param("end") int end);
	// board count 조회
	int selectBoardListTotal();

}

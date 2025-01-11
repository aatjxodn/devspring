package com.spring.devspring.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.spring.devspring.dto.LnbDTO;
import com.spring.devspring.dto.LnbSubDTO;

@Mapper
public interface CommonMapper {

	// lnb 조회
	List<LnbDTO> selectLnbList();
	// lnb Sub 조회
	List<LnbSubDTO> selectLnbSubList(String id);

}

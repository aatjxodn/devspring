package com.spring.devspring.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.spring.devspring.dto.CtUserDTO;

@Mapper
public interface CtUserMapper {
	
	CtUserDTO findByCtUserId(@Param("ctUserId") String ctUserId);

	CtUserDTO save(CtUserDTO djsUser);

	void insertUser(CtUserDTO ctUserDTO);

}

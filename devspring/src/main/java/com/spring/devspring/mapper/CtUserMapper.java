package com.spring.devspring.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.spring.devspring.dto.CtUserDTO;

@Mapper
public interface CtUserMapper {
	
	CtUserDTO findByCtUserId(@Param("ctUserId") String ctUserId);

	CtUserDTO save(CtUserDTO djsUser);

	void insertUser(CtUserDTO ctUserDTO);

	void updatePassword(CtUserDTO ctUserDto);

	CtUserDTO findByCtUserIdAndCtUserPwd(@Param("ctUserId") String ctUserId,@Param("ctUserPwd") String ctUserPwd);

}

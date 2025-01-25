package com.spring.devspring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BoardDTO {
	
	private int roNum;
	private int ctBoardIdx;
	
	private String ctBoardId;
	private String ctBoardSubject;
	private String ctBoardName;
	private String ctBoardCreateDate;
	
}
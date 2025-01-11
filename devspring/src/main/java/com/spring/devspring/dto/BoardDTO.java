package com.spring.devspring.dto;

public class BoardDTO {
	
	private int roNum;
	private int ctBoardIdx;
	
	private String ctBoardId;
	private String ctBoardSubject;
	private String ctBoardName;
	private String ctBoardCreateDate;
	
	public int getRoNum() {
		return roNum;
	}
	public void setRoNum(int roNum) {
		this.roNum = roNum;
	}
	public int getCtBoardIdx() {
		return ctBoardIdx;
	}
	public void setCtBoardIdx(int ctBoardIdx) {
		this.ctBoardIdx = ctBoardIdx;
	}
	public String getCtBoardId() {
		return ctBoardId;
	}
	public void setCtBoardId(String ctBoardId) {
		this.ctBoardId = ctBoardId;
	}
	public String getCtBoardSubject() {
		return ctBoardSubject;
	}
	public void setCtBoardSubject(String ctBoardSubject) {
		this.ctBoardSubject = ctBoardSubject;
	}
	public String getCtBoardName() {
		return ctBoardName;
	}
	public void setCtBoardName(String ctBoardName) {
		this.ctBoardName = ctBoardName;
	}
	public String getCtBoardCreateDate() {
		return ctBoardCreateDate;
	}
	public void setCtBoardCreateDate(String ctBoardCreateDate) {
		this.ctBoardCreateDate = ctBoardCreateDate;
	}
	
}
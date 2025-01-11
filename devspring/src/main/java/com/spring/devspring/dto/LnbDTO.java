package com.spring.devspring.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class LnbDTO {
	
	private int ctLnbIdx;
	private String ctLnbId;
	private String ctLnbName;
	private String ctLnbSubYn;
	private String ctLnbUrl;
	private String ctLnbUseYn;
	
	public int getCtLnbIdx() {
		return ctLnbIdx;
	}
	public void setCtLnbIdx(int ctLnbIdx) {
		this.ctLnbIdx = ctLnbIdx;
	}
	public String getCtLnbId() {
		return ctLnbId;
	}
	public void setCtLnbId(String ctLnbId) {
		this.ctLnbId = ctLnbId;
	}
	public String getCtLnbName() {
		return ctLnbName;
	}
	public void setCtLnbName(String ctLnbName) {
		this.ctLnbName = ctLnbName;
	}
	public String getCtLnbSubYn() {
		return ctLnbSubYn;
	}
	public void setCtLnbSubYn(String ctLnbSubYn) {
		this.ctLnbSubYn = ctLnbSubYn;
	}
	public String getCtLnbUrl() {
		return ctLnbUrl;
	}
	public void setCtLnbUrl(String ctLnbUrl) {
		this.ctLnbUrl = ctLnbUrl;
	}
	public String getCtLnbUseYn() {
		return ctLnbUseYn;
	}
	public void setCtLnbUseYn(String ctLnbUseYn) {
		this.ctLnbUseYn = ctLnbUseYn;
	}
	
	
}
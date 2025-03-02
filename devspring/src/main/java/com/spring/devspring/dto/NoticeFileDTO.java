package com.spring.devspring.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class NoticeFileDTO {
    
    private int ctNoticeFileIdx;
    private int ctNoticeIdx;
    private String ctNoticeFileOriginalName;
    private String ctNoticeFileSavedName;
    private String ctNoticeFileSavedPath;
    
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm", timezone = "Asia/Seoul")
    private LocalDateTime ctNoticeFileCreateTime;

    @Builder
    public NoticeFileDTO(int ctNoticeIdx, String ctNoticeFileOriginalName, String ctNoticeFileSavedName, String ctNoticeFileSavedPath, LocalDateTime ctNoticeFileCreateTime) {
        this.ctNoticeIdx = ctNoticeIdx;
        this.ctNoticeFileOriginalName = ctNoticeFileOriginalName;
        this.ctNoticeFileSavedName = ctNoticeFileSavedName;
        this.ctNoticeFileSavedPath = ctNoticeFileSavedPath;
        this.ctNoticeFileCreateTime = LocalDateTime.now();
    }
}
package com.spring.devspring.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class NoticeFileDTO {
    
    private Long id;
    private String orgNm;
    private String savedNm;
    private String savedPath;

    @Builder
    public NoticeFileDTO(Long id, String orgNm, String savedNm, String savedPath) {
        this.id = id;
        this.orgNm = orgNm;
        this.savedNm = savedNm;
        this.savedPath = savedPath;
    }
}
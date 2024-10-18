package com.sklee.entity;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class Board {
    private int bno; // 게시글 호 (PK)
    private String btitle; // 게시글 제목
    private String bcontent; // 게시번글 내용
    private String bdate; // 작성 날짜 (포맷팅된 문자열)
    private String bip; // 작성자 IP
    private int blike; // 좋아요 수
    private int bcount; // 조회 수             
    private String bfile; // 첨부 파일
    private int commentCount; // 댓글 개수
    private Member member; // 작성자 정보 (Member 객체로 매핑)
    
}

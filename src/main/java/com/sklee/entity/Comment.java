package com.sklee.entity;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Comment {
    private int cno; // 댓글 번호
    private int bno; // 게시글 번호
    private int mno; // 댓글 작성자
    private String mname; // 작성자명
    private String mid; // 작성자ID
    private int clike; // 좋아요 수
    private String comment; // 댓글 내용
    private LocalDateTime cdate; // 작성 날짜
}

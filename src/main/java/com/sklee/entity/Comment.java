package com.sklee.entity;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Comment {
    private int cno; // 댓글 번호
    private Board board; // 게시글 번호 (외래키)
    private Member member; // 회원 번호 (외래키)
    private int clike; // 좋아요 수
    private String ccomment; // 댓글 내용
    private LocalDateTime cdate; // 작성 날짜
}

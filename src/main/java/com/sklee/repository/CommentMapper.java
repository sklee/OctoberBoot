package com.sklee.repository;

import com.sklee.entity.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CommentMapper {

    // 특정 게시글 댓글 목록 조회
    List<Comment> findCommentsByBoardId(@Param("bno") int bno);

    // 댓글 저장
    void insertComment(Comment comment);

    // 댓글 삭제
    int deleteComment(@Param("cno") int cno, @Param("mid") String mid);

}

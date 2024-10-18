
package com.sklee.repository;

import java.util.List;
import java.util.Optional;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.sklee.entity.Board;

@Mapper
public interface BoardMapper {

    // 게시글 목록 조회
//    List<Board> findAll();

    // 게시글 상세 조회
//    Optional<Board> findById(@Param("bno") int bno);

    // 게시글 목록 조회 (MB)
    List<Board> findAll();

    // 특정 게시글 조회 (MB)
    Optional<Board> findById(@Param("bno") int bno);

    // 게시글 등록
    int insertBoard(Board board);

    // 게시글 수정
    int updateBoard(@Param("btitle") String title, @Param("bcontent") String content, @Param("bno") int bno);

    // 게시글 삭제
    int deleteBoard(@Param("bno") int bno, @Param("mid") String mid);

    // 댓글 등록
    int insertComment(@Param("bno") int bno, @Param("comment") String comment);
}

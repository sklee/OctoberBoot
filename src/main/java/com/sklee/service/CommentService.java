package com.sklee.service;

import java.util.List;

import com.sklee.entity.Comment;
import com.sklee.entity.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sklee.repository.CommentMapper;
import com.sklee.util.Util;


@Service
public class CommentService {

    @Autowired
    private CommentMapper commentMapper;

    @Autowired
    private Util util;

    // 댓글 목록 조회
    public List<Comment> findCommentsByBoardId(int bno) {
        return commentMapper.findCommentsByBoardId(bno);
    }

    // 댓글 저장
    public void saveComment(Comment comment) {
        commentMapper.insertComment(comment);
    }

    // 댓글 삭제
    public int deleteComment(int cno) {
        if(util.getSession().getAttribute("mid") != null) {
            return commentMapper.deleteComment(cno, util.getSession().getAttribute("mid").toString());
        } else {
            return 0;
        }
    }
}

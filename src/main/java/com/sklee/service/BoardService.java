package com.sklee.service;

import java.util.List;
import java.util.Optional;

import com.sklee.entity.Comment;
import com.sklee.entity.Member;
import com.sklee.repository.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sklee.entity.Board;
import com.sklee.repository.BoardMapper;
import com.sklee.util.Util;

@Service
public class BoardService {

    @Autowired
    private BoardMapper boardMapper;

    @Autowired
    private MemberMapper memberMapper;

    @Autowired
    private Util util;

    // 글쓰기
    public int write(Board board) {
        if (util.getSession().getAttribute("mid") != null) {
            Optional<Member> member = memberMapper.findByMid(String.valueOf(util.getSession().getAttribute("mid")));
            board.setMember(member.get());
            board.setBip(util.getIP());
            return boardMapper.insertBoard(board);
        } else {
            return 0;
        }
    }

    // 게시글 목록 가져오기                 `
    public List<Board> list() {
        return boardMapper.findAll();
    }

    // 게시글 상세보기
    public Optional<Board> detail(int bno) {
        return boardMapper.findById(bno);
    }

    // 게시글 삭제
    public int delete(int bno) {
        if (util.getSession().getAttribute("mid") != null) {
            return boardMapper.deleteBoard(bno, util.getSession().getAttribute("mid").toString());
        } else {
            return 0;
        }
    }

    // 게시글 수정
    public Optional<Board> update(int bno) {
        return boardMapper.findById(bno);
    }

    public void update(String btitle, String bcontent, int bno) {
        boardMapper.updateBoard(btitle, bcontent, bno);
    }

    // 댓글 작성
//    public int comment(int bno, String ccomment) {
//        if (util.getSession().getAttribute("mid") != null) {
//            Optional<Member> member = memberMapper.findByMid(String.valueOf(util.getSession().getAttribute("mid")));
//            Optional<Board> board = boardMapper.findById(bno);
//            if(board.isPresent()) {
//                Comment comment = new Comment();
//                comment.setComment(ccomment);
//                comment.setMember(member.get());
//                comment.setBoard(board.get());
//                return 1;
//            }
//        }
//        return 0;
//    }

}


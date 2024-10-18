
package com.sklee.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sklee.entity.Board;
import com.sklee.service.BoardService;

@Controller
public class BoardController {

    @Autowired
    private BoardService boardService;

    // 메인 페이지 및 게시판 페이지 이동
    @GetMapping({ "/", "/index" })
    public String index() {
        return "index";
    }

    // 게시판 목록
    @GetMapping("/board")
    public String board(Model model) {
        List<Board> list = boardService.list();
        model.addAttribute("list", list);
        return "board";
    }               

    // 글쓰기
    @PostMapping("/write")
    public String write(@RequestParam("title") String title, @RequestParam("content") String content) {
        Board board = new Board();
        board.setBtitle(title);
        board.setBcontent(content);
        boardService.write(board);          
        return "redirect:/board";
    }

    // 상세 보기
    @GetMapping("/detail")
    public String detail(@RequestParam("bno") int bno, Model model) {
        Optional<Board> board = boardService.detail(bno);
        model.addAttribute("detail", board.orElse(null));
        return "detail";
    }

    // 글 수정
    @GetMapping("/update")
    public String update(@RequestParam("bno") int bno, Model model) {
        Optional<Board> board = boardService.update(bno);
        model.addAttribute("update", board.orElse(null));
        return "update";
    }

    @PostMapping("/update")
    public String update(@RequestParam("btitle") String btitle, @RequestParam("bcontent") String bcontent, @RequestParam("bno") int bno) {
        boardService.update(btitle, bcontent, bno);
        return "redirect:/detail?bno=" + bno;
    }

    // 글 삭제
    @GetMapping("/delete")
    public String delete(@RequestParam("bno") int bno) {
        boardService.delete(bno);
        return "redirect:/board";
    }

    // 댓글 작성
    @PostMapping("/comment")
    public String comment(@RequestParam("bno") int bno, @RequestParam("comment") String comment, RedirectAttributes redirect) {
        boardService.comment(bno, comment);
        redirect.addAttribute("bno", bno);
        return "redirect:/detail";
    }
//
//    // 댓글 삭제
//    @GetMapping("/cdelete")
//    public String cdelete(@RequestParam("bno") int bno, @RequestParam("cno") int cno, RedirectAttributes redirect) {
//        boardService.cdelete(cno);
//        redirect.addAttribute("bno", bno);
//        return "redirect:/detail";
//    }
}

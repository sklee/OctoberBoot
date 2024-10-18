package com.sklee.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sklee.service.MemberService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    // 회원가입 페이지
    @GetMapping("/join")
    public String join() {
        return "join";
    }

    // 회원가입 처리
    @PostMapping("/join")
    public String join(@RequestParam("id") String id, @RequestParam("pw") String pw, @RequestParam("name") String name) {
        int result = memberService.join(id, pw, name);
        return result == 1 ? "redirect:/board" : "redirect:/join";
    }

    // 로그인 페이지
    @GetMapping("/login")
    public String login() {
        return "login";
    }

    // 로그인 처리
    @PostMapping("/login")
    public String login(@RequestParam("id") String id, @RequestParam("pw") String pw) {
        int result = memberService.login(id, pw);
        return result == 1 ? "redirect:/board" : "redirect:/login";
    }

    // 로그아웃 처리
    @GetMapping("/logout")
    public String logout(HttpServletRequest request) {
        memberService.logout();
        return "redirect:/board";
    }
}


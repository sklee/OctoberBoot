package com.sklee.service;

import java.util.Optional;

import com.sklee.repository.MemberMapper;
import org.springframework.stereotype.Service;

import com.sklee.entity.Member;
import com.sklee.util.Util;

@Service
public class MemberService {

    private final MemberMapper memberMapper;
    private final Util util;

    public MemberService(MemberMapper memberMapper, Util util) {
        this.memberMapper = memberMapper;
        this.util = util;
    }

    // 회원가입
    public int join(String id, String pw, String name) {
        boolean checkUser = memberMapper.existsByMid(id);
        if (checkUser) {
            return 0; // 중복된 회원 존재
        }

        Member member = new Member();
        member.setMid(id);
        member.setMpw(pw); // 비밀번호 암호화 없이 그대로 저장
        member.setMname(name);
//        member.setRole("USER");
        return memberMapper.insertMember(member);
    }

    // 로그인
    public int login(String id, String pw) {
        Optional<Member> result = memberMapper.findByMidAndMpw(id, pw);
        if (result.isPresent()) {
            // 세션 설정
            util.getSession().setAttribute("mid", id);
            util.getSession().setAttribute("mname", result.get().getMname());
            return 1;
        }
        return 0; // 아이디 또는 비밀번호 불일치
    }

    // 로그아웃
    public void logout() {
        if (util.getSession().getAttribute("mid") != null) {
            util.getSession().removeAttribute("mid");
        }
        if (util.getSession().getAttribute("mname") != null) {
            util.getSession().removeAttribute("mname");
        }
        util.getSession().invalidate();
    }
}


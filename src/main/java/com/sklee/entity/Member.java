package com.sklee.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Member {
    private int mno; // 회원 번호 (PK)
    private String mid; // 회원 아이디 (unique)
    private String mname; // 회원 이름 (unique)
    private String mpw; // 비밀번호 (암호화 적용됨)
//    private String role; // 회원 권한 (예: ROLE_ADMIN, ROLE_USER)
}


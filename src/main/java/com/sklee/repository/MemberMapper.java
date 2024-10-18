package com.sklee.repository;

import com.sklee.entity.Member;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Optional;

@Mapper
public interface MemberMapper {

    // 회원 정보 조회 by mid
    Optional<Member> findByMid(@Param("mid") String mid);

    // 회원 정보 조회 by mid와 mpw
    Optional<Member> findByMidAndMpw(@Param("mid") String mid, @Param("mpw") String mpw);

    // 회원 중복 여부 확인
    boolean existsByMid(String mid);

    // 회원 등록
    int insertMember(Member member);
}

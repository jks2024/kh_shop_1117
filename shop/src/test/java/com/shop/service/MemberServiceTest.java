package com.shop.service;

import com.shop.dto.MemberFromDto;
import com.shop.entity.Member;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.annotation.Rollback;

import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@Transactional
@Rollback(value = false)
class MemberServiceTest {
    @Autowired
    MemberService memberService;
    @Autowired
    PasswordEncoder passwordEncoder;
    public Member createMember() {
        MemberFromDto memberFromDto = new MemberFromDto();
        memberFromDto.setEmail("jks2024@gmail.com");
        memberFromDto.setName("곰돌이사육사");
        memberFromDto.setAddress("경기도수원시");
        memberFromDto.setPassword("sphb8250");
        return Member.createMember(memberFromDto, passwordEncoder);
    }
    @Test
    @DisplayName("회원가입테스트")
    public void saveMemberTest() {
        Member member = createMember();
        Member savedMember = memberService.saveMember(member);
        assertEquals(member.getEmail(), savedMember.getEmail());
        assertEquals(member.getName(), savedMember.getName());
        assertEquals(member.getAddress(), savedMember.getAddress());
        assertEquals(member.getPassword(), savedMember.getPassword());
        assertEquals(member.getRole(), savedMember.getRole());
    }
}
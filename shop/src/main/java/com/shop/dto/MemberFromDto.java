package com.shop.dto;

import lombok.Getter;
import lombok.Setter;

// 회원 가입화면으로 부터 넘어오는 가입 정보를 담을 dto 객체
@Getter
@Setter
public class MemberFromDto {
    private String name;
    private String email;
    private String password;
    private String address;
}

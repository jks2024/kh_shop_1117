package com.shop.entity;

import com.shop.constant.Role;
import com.shop.dto.MemberFromDto;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;

@Entity
@Table(name="member")
@Getter @Setter
@ToString
public class Member {
    @Id
    @Column(name="member_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @Column(unique = true) // 유일한 값이 와야 함
    private String email;
    private String password;
    private String address;
    @Enumerated(EnumType.STRING) // DB에 저장될 때 문자열로 저장 됨
    private Role role;

    public static Member createMember(MemberFromDto memberFromDto, PasswordEncoder passwordEncoder) {
        Member member = new Member();
        member.setName(memberFromDto.getName());
        member.setEmail(memberFromDto.getEmail());
        member.setAddress(memberFromDto.getAddress());
        // entity 바로 값을 넣지 말고 암호화 이후에 값을 넣어 줌
        String password = passwordEncoder.encode(memberFromDto.getPassword());
        member.setPassword(password);
        member.setRole(Role.USER);
        return member;
    }
}

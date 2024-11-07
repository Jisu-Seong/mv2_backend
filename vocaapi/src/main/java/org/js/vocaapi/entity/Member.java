package org.js.vocaapi.entity;

import org.js.vocaapi.dto.JoinRequestDTO;

import jakarta.persistence.*;
import lombok.*;
import java.util.*;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString(exclude = "memberRoleList")
public class Member {
    @Id
    private String email;

    private String pw;
    private String nickname;
    private boolean social;

    private String imageUrl;

    @ElementCollection(fetch = FetchType.LAZY)
    @Builder.Default
    private List<MemberRole> memberRoleList = new ArrayList<>();

    public void addRole(MemberRole memberRole) {
        memberRoleList.add(memberRole);
    }

    public void clearRole() {
        memberRoleList.clear();
    }

    public void changeNickname(String nickname) {
        this.nickname = nickname;
    }

    public void changePw(String pw) {
        this.pw = pw;
    }

    public void changeSocial(boolean social) {
        this.social = social;
    }

    public static Member toMember(JoinRequestDTO joinRequestDTO, PasswordEncoder passwordEncoder) {
        Member member = Member.builder()
                .email(joinRequestDTO.getEmail())
                .pw(passwordEncoder.encode(joinRequestDTO.getPassword()))
                .build();
        member.addRole(MemberRole.USER);
        return member;
    }

    public UsernamePasswordAuthenticationToken toAuthentication() {
        return new UsernamePasswordAuthenticationToken(email, pw);
    }

}

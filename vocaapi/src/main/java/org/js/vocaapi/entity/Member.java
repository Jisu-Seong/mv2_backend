package org.js.vocaapi.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.js.vocaapi.dto.member.JoinRequestDTO;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;
import java.util.*;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString(exclude = "memberRoleList")
public class Member {
    @Id
    private String email;
    
    @NotNull
    private String password;
    
    @NotNull
    private String nickname;
    
    private boolean social;
    
    private String profileImgUrl;
    
    @ElementCollection(fetch = FetchType.LAZY)
    private List<MemberRole> memberRoleList;
    
    @CreationTimestamp
    private LocalDateTime joinTimeStamp;
    
    @UpdateTimestamp
    private LocalDateTime updateTimeStamp;

    private boolean isModified;
    
    @Builder
    public Member(String email, String password, String nickname) {
        this.email = email;
        this.password = password;
        this.nickname = nickname;
        this.memberRoleList = new ArrayList<>();
    }

    public void addRole(MemberRole memberRole) {
        memberRoleList.add(memberRole);
    }

    public void clearRole() {
        memberRoleList.clear();
    }

    public void changeNickname(String nickname) {
        this.nickname = nickname;
    }

    public void changePassword(String password) {
        this.password = password;
    }

    public void changeSocial(boolean social) {
        this.social = social;
    }

    public void changeProfileImgUrl(String url) {
        this.profileImgUrl = url;
    }

    public void changeIsModified(boolean isModified) {
        this.isModified = isModified;
    }

    public static Member toMember(JoinRequestDTO joinRequestDTO, PasswordEncoder passwordEncoder) {
        Member member = Member.builder()
                .email(joinRequestDTO.getEmail())
                .password(passwordEncoder.encode(joinRequestDTO.getPassword()))
                .nickname(joinRequestDTO.getNickname())
                .build();
        member.addRole(MemberRole.USER);
        return member;
    }

    public UsernamePasswordAuthenticationToken toAuthentication() {
        return new UsernamePasswordAuthenticationToken(email, password);
    }

}

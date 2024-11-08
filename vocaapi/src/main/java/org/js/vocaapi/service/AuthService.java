package org.js.vocaapi.service;

import org.js.vocaapi.dto.member.JoinRequestDTO;
import org.js.vocaapi.entity.Member;
import org.js.vocaapi.repository.MemberRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@Transactional
@RequiredArgsConstructor
@Log4j2
public class AuthService {
    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    public String signin(JoinRequestDTO joinRequestDTO) {
        int memberCnt = memberRepository.countExistEmail(joinRequestDTO.getEmail());
        
        if (memberCnt == 0) {
            int nicknameCnt = memberRepository.countExistNickname(joinRequestDTO.getNickname());
            
            if (nicknameCnt == 0) {
                Member member = Member.toMember(joinRequestDTO, passwordEncoder);
                memberRepository.save(member);
                log.info(joinRequestDTO.getEmail() + " 님이 회원가입하였습니다.");
                return "SIGNIN_SUCCESS";
            }

            return "SIGNIN_FAIL__ALREADY EXISTING NICKNAME";
            
        } else {
            return "SIGNIN_FAIL__ALREADY EXISTING EMAIL";
        }
    }
}

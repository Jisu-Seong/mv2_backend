package org.js.vocaapi.security;

import java.util.stream.Collectors;

import org.js.vocaapi.dto.member.MemberDTO;
import org.js.vocaapi.entity.Member;
import org.js.vocaapi.repository.MemberRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final MemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("-------------------loadUserByUsername--------------------------");

        Member member = memberRepository.getWithRoles(username);
        if (member == null) {
            throw new UsernameNotFoundException("Not Found");
        }

        MemberDTO memberDTO = new MemberDTO(member.getEmail(), member.getPassword(), member.getNickname(), member.isSocial(),
                member.getMemberRoleList().stream()
                        .map(memberRole -> memberRole.name()).collect(Collectors.toList()));

        log.info(memberDTO);
        return memberDTO;
    }

}
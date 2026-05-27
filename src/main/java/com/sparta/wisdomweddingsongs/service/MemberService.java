package com.sparta.wisdomweddingsongs.service;

import com.sparta.wisdomweddingsongs.dto.MemberLoginRequestDto;
import com.sparta.wisdomweddingsongs.dto.MemberResponseDto;
import com.sparta.wisdomweddingsongs.dto.MemberSignupRequestDto;
import com.sparta.wisdomweddingsongs.entity.Member;
import com.sparta.wisdomweddingsongs.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    @Transactional
    public MemberResponseDto signup(MemberSignupRequestDto requestDto) {

        if (memberRepository.existsByEmail(requestDto.getEmail())) {
            throw new IllegalArgumentException("이미 가입된 이메일입니다.");
        }
        Member member = new Member(
                requestDto.getEmail(),
                requestDto.getPassword(),
                requestDto.getName(),
                requestDto.getRole()
        );

        Member savedMember = memberRepository.save(member);

        return new MemberResponseDto(savedMember);
    }
    @Transactional(readOnly = true)
    public MemberResponseDto login(MemberLoginRequestDto requestDto) {

        Member member = memberRepository.findByEmail(requestDto.getEmail())
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 이메일입니다."));

        if (!member.getPassword().equals(requestDto.getPassword())) {
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
        }

        return new MemberResponseDto(member);
    }
}

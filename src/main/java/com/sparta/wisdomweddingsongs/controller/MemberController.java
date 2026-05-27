package com.sparta.wisdomweddingsongs.controller;

import com.sparta.wisdomweddingsongs.dto.MemberLoginRequestDto;
import com.sparta.wisdomweddingsongs.dto.MemberResponseDto;
import com.sparta.wisdomweddingsongs.dto.MemberSignupRequestDto;
import com.sparta.wisdomweddingsongs.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/members")
@RequiredArgsConstructor

public class MemberController {

    private final MemberService memberService;

    // 회원가입
    @PostMapping("/signup")
    public ResponseEntity<MemberResponseDto> signup(
            @RequestBody MemberSignupRequestDto requestDto
    ) {

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(memberService.signup(requestDto));
    }

    // 로그인
    @PostMapping("/login")
    public ResponseEntity<MemberResponseDto>
    login(@RequestBody MemberLoginRequestDto requestDto){


        return ResponseEntity.ok(memberService.login(requestDto));
    }
}

package com.sparta.wisdomweddingsongs.dto;

import lombok.Getter;

@Getter
public class MemberSignupRequestDto {
    private String email;
    private String password;
    private String name;
    private String role;
}

package com.sparta.wisdomweddingsongs.dto;

import lombok.Getter;

import java.time.LocalDate;

@Getter
public class MemberSignupRequestDto {
    private String email;
    private String password;
    private String name;
    private String role;
    private LocalDate birthDate;
}

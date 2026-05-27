package com.sparta.wisdomweddingsongs.dto;

import com.sparta.wisdomweddingsongs.entity.Member;
import lombok.Getter;

@Getter
public class MemberResponseDto {

    private Long id;
    private String email;
    private String name;
    private String role;

    public MemberResponseDto(Member member) {
        this.id = member.getId();
        this.email = member.getEmail();
        this.name = member.getName();
        this.role = member.getRole();
    }

}

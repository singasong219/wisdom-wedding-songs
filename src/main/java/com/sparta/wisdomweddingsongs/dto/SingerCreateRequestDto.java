package com.sparta.wisdomweddingsongs.dto;

import lombok.Getter;

@Getter
public class SingerCreateRequestDto {
    private String singerName;
    private String genre;
    private Integer price;
    private String phoneNumber;
}

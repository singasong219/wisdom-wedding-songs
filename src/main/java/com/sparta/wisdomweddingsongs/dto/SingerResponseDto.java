package com.sparta.wisdomweddingsongs.dto;

import com.sparta.wisdomweddingsongs.entity.Singer;
import lombok.Getter;

@Getter
public class SingerResponseDto {

    private Long id;
    private String singerName;
    private String genre;
    private Integer price;
    private String phoneNumber;

    public SingerResponseDto(Singer singer) {
        this.id = singer.getId();
        this.singerName = singer.getSingerName();
        this.genre = singer.getGenre();
        this.price = singer.getPrice();
        this.phoneNumber = singer.getPhoneNumber();
    }
}

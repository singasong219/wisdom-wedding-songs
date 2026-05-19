package com.sparta.wisdomweddingsongs.dto;

import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
public class SongRequestCreateDto {

        private String applicantName;

        private String applicantPhone;

        private String applicantType;

        private LocalDate weddingDate;

        private LocalTime weddingTime;

        private String weddingPlace;

        private String songTitle;

        private String specialRequest;

        private String password;
}

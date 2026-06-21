package com.sparta.wisdomweddingsongs.dto;


import com.sparta.wisdomweddingsongs.entity.SongRequest;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Getter
public class SongRequestResponseDto {

    private Long id;

    private String applicantName;

    private String applicantEmail;

    private String applicantPhone;

    private String applicantType;

    private LocalDate weddingDate;

    private LocalTime weddingTime;

    private String weddingPlace;

    private String songTitle;

    private String specialRequest;

    private String status;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    public SongRequestResponseDto(SongRequest songRequest) {
        this.id = songRequest.getId();
        this.applicantName = songRequest.getApplicantName();
        this.applicantEmail = songRequest.getApplicantEmail();
        this.applicantPhone = songRequest.getApplicantPhone();
        this.applicantType = songRequest.getApplicantType();
        this.weddingDate = songRequest.getWeddingDate();
        this.weddingTime = songRequest.getWeddingTime();
        this.weddingPlace = songRequest.getWeddingPlace();
        this.songTitle = songRequest.getSongTitle();
        this.specialRequest = songRequest.getSpecialRequest();
        this.status = songRequest.getStatus().name();
        this.createdAt = songRequest.getCreatedAt();
        this.updatedAt = songRequest.getUpdatedAt();
    }
}

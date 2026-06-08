package com.sparta.wisdomweddingsongs.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "song_request")

public class SongRequest {

    public SongRequest(
            String applicantName,
            String applicantPhone,
            String applicantType,
            LocalDate weddingDate,
            LocalTime weddingTime,
            String weddingPlace,
            String songTitle,
            String specialRequest,
            String password
    ) {
        this.applicantName = applicantName;
        this.applicantPhone = applicantPhone;
        this.applicantType = applicantType;
        this.weddingDate = weddingDate;
        this.weddingTime = weddingTime;
        this.weddingPlace = weddingPlace;
        this.songTitle = songTitle;
        this.specialRequest = specialRequest;
        this.status = SongRequestStatus.REQUESTED;
        this.password = password;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }
    public void update(
            String applicantType,
            String weddingPlace,
            String songTitle
    ) {
        this.applicantType = applicantType;
        this.weddingPlace = weddingPlace;
        this.songTitle = songTitle;
    }

    public void updateStatus(SongRequestStatus status) {
        this.status = status;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String applicantName;

    @Column(nullable = false)
    private String applicantPhone;

    @Column(nullable = false)
    private String applicantType;

    @Column(nullable = false)
    private LocalDate weddingDate;

    @Column(nullable = false)
    private LocalTime weddingTime;

    @Column(nullable = false)
    private String weddingPlace;

    @Column(nullable = false)
    private String songTitle;

    @Column(columnDefinition = "TEXT")
    private String specialRequest;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private SongRequestStatus status;

    @Column(nullable = false)
    private String password;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}

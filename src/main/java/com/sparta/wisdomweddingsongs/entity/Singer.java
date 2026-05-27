package com.sparta.wisdomweddingsongs.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "singers")
public class Singer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String singerName;

    @Column(nullable = false)
    private String genre;

    @Column(nullable = false)
    private Integer price;

    @Column(nullable = false)
    private String phoneNumber;

    public Singer(String singerName, String genre, Integer price, String phoneNumber) {
        this.singerName = singerName;
        this.genre = genre;
        this.price = price;
        this.phoneNumber = phoneNumber;
    }

    public void update(String singerName, String genre, Integer price, String phoneNumber) {
        this.singerName = singerName;
        this.genre = genre;
        this.price = price;
        this.phoneNumber = phoneNumber;
    }
    private String videoUrl;

    public void updateVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }


}

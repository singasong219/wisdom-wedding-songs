package com.sparta.wisdomweddingsongs.controller;


import com.sparta.wisdomweddingsongs.dto.SongRequestCreateDto;
import com.sparta.wisdomweddingsongs.dto.SongRequestDeleteDto;
import com.sparta.wisdomweddingsongs.dto.SongRequestResponseDto;
import com.sparta.wisdomweddingsongs.service.SongRequestService;
import com.sparta.wisdomweddingsongs.dto.SongRequestStatusUpdateDto;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;

@RestController
@RequestMapping("/song-requests")
@RequiredArgsConstructor
public class SongRequestController {

    private final SongRequestService songRequestService;

    @PostMapping
    public ResponseEntity<SongRequestResponseDto> createSongRequest(
            @RequestBody SongRequestCreateDto requestCreateDto
    ) {

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(songRequestService.createSongRequest(requestCreateDto));
    }

    // 축가 신청 목록 조회
    @GetMapping
    public ResponseEntity<List<SongRequestResponseDto>> getSongRequests() {
        return ResponseEntity.ok(songRequestService.getSongRequests());
    }

    // 축가 신청 단건 조회
    @GetMapping("/{id}")
    public ResponseEntity<SongRequestResponseDto> getSongRequests(@PathVariable Long id) {

        return ResponseEntity.ok(songRequestService.getSongRequest(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<SongRequestResponseDto> updateSongRequest(
            @PathVariable Long id,
            @RequestBody SongRequestCreateDto requestCreateDto
    ) {
        return ResponseEntity.ok(songRequestService.updateSongRequest(id, requestCreateDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSongRequest(
            @PathVariable Long id,
            @RequestBody SongRequestDeleteDto requestDto
    ) {
        songRequestService.deleteSongRequest(id, requestDto);

        return ResponseEntity.noContent().build();
    }


    @PatchMapping("/{id}/status")
    public ResponseEntity<SongRequestResponseDto> updateStatus(
            @PathVariable long id,
            @RequestBody SongRequestStatusUpdateDto requestStatusUpdateDto
    ) {

        return ResponseEntity.ok(
                songRequestService.updateStatus(id, requestStatusUpdateDto)
        );
    }
}
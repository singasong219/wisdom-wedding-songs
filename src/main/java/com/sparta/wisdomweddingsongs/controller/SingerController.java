package com.sparta.wisdomweddingsongs.controller;

import com.sparta.wisdomweddingsongs.dto.SingerCreateRequestDto;
import com.sparta.wisdomweddingsongs.dto.SingerResponseDto;
import com.sparta.wisdomweddingsongs.dto.SingerUpdateRequestDto;
import com.sparta.wisdomweddingsongs.service.SingerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/singers")
@RequiredArgsConstructor
public class SingerController {

    private final SingerService singerService;

    @PostMapping
    public ResponseEntity<SingerResponseDto> createSinger(@RequestBody SingerCreateRequestDto requestDto) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(singerService.createSinger(requestDto));
    }

    @GetMapping
    public ResponseEntity<List<SingerResponseDto>> getSingers() {
        return ResponseEntity.ok(singerService.getSingers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SingerResponseDto> getSinger(@PathVariable Long id) {
        return ResponseEntity.ok(singerService.getSinger(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<SingerResponseDto> updateSinger(
            @PathVariable Long id,
            @RequestBody SingerUpdateRequestDto requestDto
    ) {
        return ResponseEntity.ok(singerService.updateSinger(id, requestDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSinger(@PathVariable Long id) {
        singerService.deleteSinger(id);

        return ResponseEntity.noContent().build();
    }
}

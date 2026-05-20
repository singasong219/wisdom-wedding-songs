package com.sparta.wisdomweddingsongs.service;

import com.sparta.wisdomweddingsongs.dto.SingerCreateRequestDto;
import com.sparta.wisdomweddingsongs.dto.SingerResponseDto;
import com.sparta.wisdomweddingsongs.dto.SingerUpdateRequestDto;
import com.sparta.wisdomweddingsongs.entity.Singer;
import com.sparta.wisdomweddingsongs.repository.SingerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SingerService {

    private final SingerRepository singerRepository;

    @Transactional
    public SingerResponseDto createSinger(SingerCreateRequestDto requestDto) {
        Singer singer = new Singer(
                requestDto.getSingerName(),
                requestDto.getGenre(),
                requestDto.getPrice(),
                requestDto.getPhoneNumber()
        );

        Singer savedSinger = singerRepository.save(singer);

        return new SingerResponseDto(savedSinger);
    }

    @Transactional(readOnly = true)
    public List<SingerResponseDto> getSingers() {
        return singerRepository.findAll()
                .stream()
                .map(SingerResponseDto::new)
                .toList();
    }

    @Transactional(readOnly = true)
    public SingerResponseDto getSinger(Long id) {
        Singer singer = findSinger(id);

        return new SingerResponseDto(singer);
    }

    @Transactional
    public SingerResponseDto updateSinger(Long id, SingerUpdateRequestDto requestDto) {
        Singer singer = findSinger(id);

        singer.update(
                requestDto.getSingerName(),
                requestDto.getGenre(),
                requestDto.getPrice(),
                requestDto.getPhoneNumber()
        );

        return new SingerResponseDto(singer);
    }

    @Transactional
    public void deleteSinger(Long id) {
        Singer singer = findSinger(id);

        singerRepository.delete(singer);
    }

    private Singer findSinger(Long id) {
        return singerRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 가수를 찾을 수 없습니다."));
    }
}


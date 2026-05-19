package com.sparta.wisdomweddingsongs.service;

import com.sparta.wisdomweddingsongs.dto.SongRequestCreateDto;
import com.sparta.wisdomweddingsongs.dto.SongRequestDeleteDto;
import com.sparta.wisdomweddingsongs.dto.SongRequestResponseDto;
import com.sparta.wisdomweddingsongs.entity.SongRequest;
import com.sparta.wisdomweddingsongs.repository.SongRequestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SongRequestService {

    private final SongRequestRepository songRequestRepository;

    public SongRequestResponseDto createSongRequest(SongRequestCreateDto songRequestCreateDto) {

        SongRequest songRequest = new SongRequest(
                songRequestCreateDto.getApplicantName(),
                songRequestCreateDto.getApplicantPhone(),
                songRequestCreateDto.getApplicantType(),
                songRequestCreateDto.getWeddingDate(),
                songRequestCreateDto.getWeddingTime(),
                songRequestCreateDto.getWeddingPlace(),
                songRequestCreateDto.getSongTitle(),
                songRequestCreateDto.getSpecialRequest(),
                songRequestCreateDto.getPassword()
        );
        SongRequest savedSongRequest = songRequestRepository.save(songRequest);

        return new SongRequestResponseDto(savedSongRequest);
    }

    @Transactional(readOnly = true)
    public List<SongRequestResponseDto> getSongRequests() {
        return songRequestRepository.findAll()
                .stream()
                .map(SongRequestResponseDto::new)
                .toList();

    }

    public SongRequestResponseDto getSongRequest(Long id) {
        SongRequest songRequest = songRequestRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 신청이 없습니다."));

        return new SongRequestResponseDto(songRequest);
    }

    public SongRequestResponseDto updateSongRequest(
            Long id,
            SongRequestCreateDto requestCreateDto
    ) {
        SongRequest songRequest = songRequestRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 신청이 없습니다."));


        if (!songRequest.getPassword().equals(requestCreateDto.getPassword())) {
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
        }

        songRequest.update(
                requestCreateDto.getApplicantType(),
                requestCreateDto.getWeddingPlace(),
                requestCreateDto.getSongTitle()
        );

        return new SongRequestResponseDto(songRequest);
    }


    public void deleteSongRequest(Long id, SongRequestDeleteDto requestDto) {

        SongRequest songRequest = songRequestRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 신청이 없습니다."));

        if (!songRequest.getPassword().equals(requestDto.getPassword())) {
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
        }

        songRequestRepository.delete(songRequest);
    }
}

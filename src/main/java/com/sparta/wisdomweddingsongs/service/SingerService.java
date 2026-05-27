package com.sparta.wisdomweddingsongs.service;

import com.sparta.wisdomweddingsongs.dto.SingerCreateRequestDto;
import com.sparta.wisdomweddingsongs.dto.SingerResponseDto;
import com.sparta.wisdomweddingsongs.dto.SingerUpdateRequestDto;
import com.sparta.wisdomweddingsongs.entity.Singer;
import com.sparta.wisdomweddingsongs.repository.SingerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

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
    @Transactional
    public String uploadSingerVideo(Long singerId, MultipartFile file) throws IOException {

        // 1. singerId로 가수 조회
        Singer singer = singerRepository.findById(singerId)
                .orElseThrow(() -> new IllegalArgumentException("가수를 찾을 수 없습니다."));

        // 2. uploads 폴더 경로 생성
        String uploadDir = System.getProperty("user.dir") + "/uploads/";

        // 3. uploads 폴더 없으면 생성
        File dir = new File(uploadDir);

        if (!dir.exists()) {
            dir.mkdirs();
        }

        // 4. 저장할 파일 이름 생성
        String fileName = UUID.randomUUID() + "-" + file.getOriginalFilename();

        // 5. 실제 저장
        String filePath = uploadDir + fileName;

        // 6. 파일 저장
        file.transferTo(new File(filePath));

        // 7. DB에 저장할 videoUrl 생성
        String videoUrl = "/uploads/" + fileName;

        // 8. Singer 엔티티에 저장
        singer.updateVideoUrl(videoUrl);

        // 9. videoUfl 반환
        return videoUrl;
    }
}


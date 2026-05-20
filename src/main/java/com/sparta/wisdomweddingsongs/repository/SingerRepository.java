package com.sparta.wisdomweddingsongs.repository;

import com.sparta.wisdomweddingsongs.entity.Singer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SingerRepository extends JpaRepository<Singer, Long> {
}

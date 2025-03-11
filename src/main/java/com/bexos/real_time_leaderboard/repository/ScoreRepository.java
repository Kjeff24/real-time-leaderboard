package com.bexos.real_time_leaderboard.repository;

import com.bexos.real_time_leaderboard.model.Score;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScoreRepository extends JpaRepository<Score, Long> {
}

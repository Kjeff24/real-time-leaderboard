package com.bexos.real_time_leaderboard.repository;

import com.bexos.real_time_leaderboard.model.Score;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ScoreRepository extends JpaRepository<Score, Long> {

    @Query("SELECT s FROM Score s ORDER BY s.score DESC LIMIT ?1")
    List<Score> findTopScores(int limit);

    Optional<Score> findByUserId(UUID userId);
}

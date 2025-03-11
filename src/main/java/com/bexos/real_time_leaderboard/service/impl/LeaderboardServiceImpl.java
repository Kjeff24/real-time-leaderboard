package com.bexos.real_time_leaderboard.service.impl;

import com.bexos.real_time_leaderboard.model.Score;
import com.bexos.real_time_leaderboard.model.User;
import com.bexos.real_time_leaderboard.repository.ScoreRepository;
import com.bexos.real_time_leaderboard.service.LeaderboardService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@EnableCaching
@RequiredArgsConstructor
public class LeaderboardServiceImpl implements LeaderboardService {
    private final ScoreRepository scoreRepository;

    /**
     * {@inheritDoc}
     */
    @Cacheable(value = "leaderboard")
    public List<Score> getTopScores(int limit) {
        return scoreRepository.findTopScores(limit);
    }

    /**
     * {@inheritDoc}
     */
    @Transactional
    @CacheEvict(value = "leaderboard", allEntries = true)
    public void updateScore(UUID userId, int newScore) {
        Optional<Score> existingScore = scoreRepository.findByUserId(userId);

        if (existingScore.isPresent()) {
            Score score = existingScore.get();
            score.setScore(newScore);
            scoreRepository.save(score);
        } else {
            Score score = Score.builder()
                    .user(User.builder().id(userId).build())
                    .score(newScore)
                    .build();
            scoreRepository.save(score);
        }
    }
}

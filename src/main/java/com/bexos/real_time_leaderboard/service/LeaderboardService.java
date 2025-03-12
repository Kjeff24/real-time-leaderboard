package com.bexos.real_time_leaderboard.service;

import com.bexos.real_time_leaderboard.dto.ScoreRequest;
import com.bexos.real_time_leaderboard.model.Score;

import java.util.List;
import java.util.UUID;

public interface LeaderboardService {
    /**
     * Updates the user's score. If the user already has a score, it updates it.
     * Otherwise, it creates a new entry.
     * Invalidates the leaderboard cache to refresh data.
     *
     * @param userId User's ID
     * @param newScore New score to be updated
     */
    void updateScore(UUID userId, int newScore);

    /**
     * Retrieves the top N users with the highest scores.
     * Caches the result in Redis for improved performance.
     *
     * @param limit Number of top scores to retrieve
     * @return List of top scores
     */
    List<Score> getTopScores(int limit);

    Score addScore(ScoreRequest request);
}

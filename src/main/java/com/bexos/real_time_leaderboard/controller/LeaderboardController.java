package com.bexos.real_time_leaderboard.controller;

import com.bexos.real_time_leaderboard.dto.ScoreRequest;
import com.bexos.real_time_leaderboard.dto.ScoreResponse;
import com.bexos.real_time_leaderboard.service.LeaderboardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/leaderboard")
@RequiredArgsConstructor
public class LeaderboardController {
    private final LeaderboardService leaderboardService;

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public ScoreResponse addScore(@RequestBody ScoreRequest request) {
        return leaderboardService.addScore(request);
    }

    /**
     * Retrieves the top N scores for the leaderboard.
     *
     * @param limit Number of top scores to return (default is 10)
     * @return List of top scores
     */
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ScoreResponse> getTopScores(@RequestParam(defaultValue = "10") int limit) {
        return leaderboardService.getTopScores(limit);
    }

    /**
     * Updates or adds a user's score.
     *
     * @param userId   User ID
     * @param newScore New score value
     */
    @PostMapping("/{userId}")
    @ResponseStatus(HttpStatus.CREATED)
    public void updateScore(@PathVariable UUID userId, @RequestParam int newScore) {
        leaderboardService.updateScore(userId, newScore);
    }
}

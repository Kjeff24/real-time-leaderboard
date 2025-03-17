package com.bexos.real_time_leaderboard.service.impl;

import com.bexos.real_time_leaderboard.dto.ScoreRequest;
import com.bexos.real_time_leaderboard.dto.ScoreResponse;
import com.bexos.real_time_leaderboard.handler.NotFoundException;
import com.bexos.real_time_leaderboard.mapper.ScoreMapper;
import com.bexos.real_time_leaderboard.model.Game;
import com.bexos.real_time_leaderboard.model.Score;
import com.bexos.real_time_leaderboard.model.User;
import com.bexos.real_time_leaderboard.repository.GameRepository;
import com.bexos.real_time_leaderboard.repository.ScoreRepository;
import com.bexos.real_time_leaderboard.repository.UserRepository;
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
    private final UserRepository userRepository;
    private final GameRepository gameRepository;
    private final ScoreMapper scoreMapper;

    /**
     * {@inheritDoc}
     */
    @Cacheable(value = "leaderboard")
    public List<ScoreResponse> getTopScores(int limit) {
        return scoreRepository.findTopScores(limit)
                .stream()
                .map(scoreMapper::toScoreResponse)
                .toList();
    }

    public ScoreResponse addScore(ScoreRequest request) {
        Game game = gameRepository.findById(request.gameId())
                .orElseThrow(() -> new NotFoundException("Game not found"));
        User user = userRepository.findById(request.userId())
                .orElseThrow(() -> new NotFoundException("User not found"));

        Score score = Score.builder()
                .game(game)
                .user(user)
                .score(request.score())
                .build();

        return scoreMapper.toScoreResponse(scoreRepository.save(score));
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

package com.bexos.real_time_leaderboard.mapper;

import com.bexos.real_time_leaderboard.dto.ScoreResponse;
import com.bexos.real_time_leaderboard.model.Score;
import org.springframework.stereotype.Service;

@Service
public class ScoreMapper {
    public ScoreResponse toScoreResponse(Score score) {
        return ScoreResponse.builder()
                .id(score.getId())
                .gameId(score.getGame().getId())
                .userId(score.getUser().getId())
                .email(score.getUser().getEmail())
                .score(score.getScore())
                .build();
    }
}

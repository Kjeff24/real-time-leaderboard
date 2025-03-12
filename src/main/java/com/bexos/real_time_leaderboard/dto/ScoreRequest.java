package com.bexos.real_time_leaderboard.dto;

import java.util.UUID;

public record ScoreRequest(
        UUID gameId,
        UUID userId,
        long score
) {
}

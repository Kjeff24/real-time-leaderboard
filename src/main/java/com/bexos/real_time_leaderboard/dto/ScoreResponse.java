package com.bexos.real_time_leaderboard.dto;

import lombok.Builder;

import java.util.UUID;

@Builder
public record ScoreResponse(
        UUID id,
        UUID gameId,
        UUID userId,
        String email,
        long score
) {
}

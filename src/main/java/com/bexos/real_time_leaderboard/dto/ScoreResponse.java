package com.bexos.real_time_leaderboard.dto;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Builder
@Data
public class ScoreResponse {
    UUID id;
    UUID gameId;
    UUID userId;
    String email;
    long score;
}

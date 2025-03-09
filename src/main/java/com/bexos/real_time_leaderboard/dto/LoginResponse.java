package com.bexos.real_time_leaderboard.dto;

import lombok.Builder;

@Builder
public record LoginResponse (
        String token
) {
}

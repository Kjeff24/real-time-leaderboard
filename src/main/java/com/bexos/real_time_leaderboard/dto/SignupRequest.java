package com.bexos.real_time_leaderboard.dto;

public record SignupRequest(
        String firstName,
        String lastName,
        String email,
        String password
) {
}

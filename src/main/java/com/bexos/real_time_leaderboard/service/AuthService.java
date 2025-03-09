package com.bexos.real_time_leaderboard.service;

import com.bexos.real_time_leaderboard.dto.LoginRequest;
import com.bexos.real_time_leaderboard.dto.LoginResponse;
import com.bexos.real_time_leaderboard.dto.SignupRequest;

public interface AuthService {
    LoginResponse register(SignupRequest request);

    LoginResponse authenticate(LoginRequest request);
}

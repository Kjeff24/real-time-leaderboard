package com.bexos.real_time_leaderboard.controller;

import com.bexos.real_time_leaderboard.dto.LoginRequest;
import com.bexos.real_time_leaderboard.dto.LoginResponse;
import com.bexos.real_time_leaderboard.dto.SignupRequest;
import com.bexos.real_time_leaderboard.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.OK)
    public LoginResponse register(
            @RequestBody SignupRequest request
    ) {
        return authService.register(request);
    }

    @PostMapping("/authenticate")
    @ResponseStatus(HttpStatus.OK)
    public LoginResponse register(
            @RequestBody LoginRequest request
    ) {
        return authService.authenticate(request);
    }
}

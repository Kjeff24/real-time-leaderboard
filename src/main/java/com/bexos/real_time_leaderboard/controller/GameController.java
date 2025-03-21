package com.bexos.real_time_leaderboard.controller;

import com.bexos.real_time_leaderboard.dto.GameRequest;
import com.bexos.real_time_leaderboard.model.Game;
import com.bexos.real_time_leaderboard.service.GameService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/game")
@RequiredArgsConstructor
public class GameController {
    private final GameService gameService;

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public Game addScore(@RequestBody GameRequest request) {
        return gameService.createGame(request);
    }

}

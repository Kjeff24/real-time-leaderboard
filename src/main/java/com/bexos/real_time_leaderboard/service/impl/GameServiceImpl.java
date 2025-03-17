package com.bexos.real_time_leaderboard.service.impl;

import com.bexos.real_time_leaderboard.dto.GameRequest;
import com.bexos.real_time_leaderboard.model.Game;
import com.bexos.real_time_leaderboard.repository.GameRepository;
import com.bexos.real_time_leaderboard.service.GameService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GameServiceImpl implements GameService {
    private final GameRepository gameRepository;

    public Game createGame(GameRequest request) {
        return gameRepository.save(Game.builder()
                .title(request.title())
                .build());
    }
}

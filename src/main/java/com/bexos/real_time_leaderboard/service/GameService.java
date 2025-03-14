package com.bexos.real_time_leaderboard.service;

import com.bexos.real_time_leaderboard.dto.GameRequest;
import com.bexos.real_time_leaderboard.model.Game;

public interface GameService {
    Game createGame(GameRequest request);
}

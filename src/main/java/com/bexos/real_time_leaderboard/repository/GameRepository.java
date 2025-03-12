package com.bexos.real_time_leaderboard.repository;

import com.bexos.real_time_leaderboard.model.Game;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface GameRepository extends JpaRepository<Game, UUID> {
}

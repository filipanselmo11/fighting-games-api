package com.fighting_games.api.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fighting_games.api.domain.jogo.Jogo;

public interface JogoRepository extends JpaRepository<Jogo, UUID> {
    
}

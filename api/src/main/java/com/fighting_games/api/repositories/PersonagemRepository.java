package com.fighting_games.api.repositories;

import java.util.UUID;


import org.springframework.data.jpa.repository.JpaRepository;


import com.fighting_games.api.domain.personagem.Personagem;


public interface PersonagemRepository extends JpaRepository<Personagem, UUID> {
}

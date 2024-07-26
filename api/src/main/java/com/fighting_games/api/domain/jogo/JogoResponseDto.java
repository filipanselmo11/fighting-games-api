package com.fighting_games.api.domain.jogo;

import java.util.UUID;

public record JogoResponseDto(UUID id, String nome, String descricao, String img) {
    public JogoResponseDto(Jogo jogo) {
        this(jogo.getId(), jogo.getNome(), jogo.getDescricao(), jogo.getImg());
    }
}

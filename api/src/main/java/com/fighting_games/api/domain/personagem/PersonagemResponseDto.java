package com.fighting_games.api.domain.personagem;

import java.util.UUID;

public record PersonagemResponseDto(UUID id, String nome, String imgUrl, String data) {
    public PersonagemResponseDto(Personagem personagem) {
        this(personagem.getId(), personagem.getNome(), personagem.getImgUrl(), personagem.getData().toString());
    }
}
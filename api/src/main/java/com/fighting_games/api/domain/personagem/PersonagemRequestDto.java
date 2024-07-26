package com.fighting_games.api.domain.personagem;

public record PersonagemRequestDto (
    String nome,
    String img,
    String descricao
) {
    
}

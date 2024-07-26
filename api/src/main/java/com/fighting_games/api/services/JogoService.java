package com.fighting_games.api.services;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.client.ResourceAccessException;

import com.fighting_games.api.domain.jogo.Jogo;
import com.fighting_games.api.domain.jogo.JogoRequestDto;
import com.fighting_games.api.domain.jogo.JogoResponseDto;
import com.fighting_games.api.domain.personagem.Personagem;
import com.fighting_games.api.repositories.JogoRepository;
import com.fighting_games.api.repositories.PersonagemRepository;

public class JogoService {
    
    @Autowired
    private PersonagemRepository personagemRepository;

    @Autowired
    private JogoRepository jogoRepository;

    public Jogo criarJogo(UUID personagemId, JogoRequestDto data) {
        Personagem personagem = personagemRepository.findById(personagemId).orElseThrow(() -> new IllegalStateException("Personagem not found"));
        Jogo jogo = new Jogo();
        jogo.setNome(data.nome());
        jogo.setImg(data.img());
        jogo.setDescricao(data.descricao());
        jogo.setPersonagem(personagem);

        jogoRepository.save(jogo);

        return jogo;
    }

    public Page<JogoResponseDto> getJogos(@PageableDefault(size=10, sort={"nome"}) Pageable paginacao) {
        return jogoRepository.findAll(paginacao).map(JogoResponseDto::new);
    }

    public JogoResponseDto getJogoId(UUID id) {
        Jogo jogo = jogoRepository.findById(id).orElseThrow(() -> new ResourceAccessException("Jogo com o id: " + id + "não foi encontrado"));

        return new JogoResponseDto(jogo);
    }
}

package com.fighting_games.api.services;


import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Service;

import com.fighting_games.api.domain.jogo.Jogo;
import com.fighting_games.api.domain.personagem.Personagem;
import com.fighting_games.api.domain.personagem.PersonagemRequestDto;
import com.fighting_games.api.domain.personagem.PersonagemResponseDto;
import com.fighting_games.api.exceptions.ResourceNotFoundException;
import com.fighting_games.api.repositories.JogoRepository;
import com.fighting_games.api.repositories.PersonagemRepository;

@Service
public class PersonagemService {
    
    @Autowired
    private JogoRepository jogoRepository;

    @Autowired
    private PersonagemRepository personagemRepository;

    public Personagem criarPersonagem(UUID jogoId, PersonagemRequestDto data) {
        Jogo jogo = jogoRepository.findById(jogoId).orElseThrow(() -> new IllegalArgumentException("Jogo not found"));
        Personagem personagem = new Personagem();
        personagem.setNome(data.nome());
        personagem.setImg(data.img());
        personagem.setDescricao(data.descricao());
        personagem.setJogo(jogo);

        personagemRepository.save(personagem);

        return personagem;
    }

    public Page<PersonagemResponseDto> getPersonagens(@PageableDefault(size=10, sort={"nome"}) Pageable paginacao) {
        return personagemRepository.findAll(paginacao).map(PersonagemResponseDto::new);
    }

    public PersonagemResponseDto getPersonagemId(UUID id) {
        Personagem personagem = personagemRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Personagem com o id: " + id + "não foi encotrado"));

        return new PersonagemResponseDto(personagem);
    }

}

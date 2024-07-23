package com.fighting_games.api.services;

import java.sql.Date;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Service;

import com.fighting_games.api.domain.personagem.Personagem;
import com.fighting_games.api.domain.personagem.PersonagemRequestDto;
import com.fighting_games.api.domain.personagem.PersonagemResponseDto;
import com.fighting_games.api.repositories.PersonagemRepository;

@Service
public class PersonagemService {
    
    @Autowired
    private PersonagemRepository personagemRepository;

    public Personagem criarPersonagem(PersonagemRequestDto data) {
        Personagem personagem = new Personagem();
        personagem.setNome(data.nome());
        personagem.setImg(data.img());
        personagem.setData(new Date(data.data()));

        personagemRepository.save(personagem);

        return personagem;
    }

    public Page<PersonagemResponseDto> getPersonagens(@PageableDefault(size=10, sort={"nome"}) Pageable paginacao) {
        return personagemRepository.findAll(paginacao).map(PersonagemResponseDto::new);
    }

}

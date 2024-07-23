package com.fighting_games.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fighting_games.api.domain.personagem.Personagem;
import com.fighting_games.api.domain.personagem.PersonagemRequestDto;
import com.fighting_games.api.domain.personagem.PersonagemResponseDto;
import com.fighting_games.api.services.PersonagemService;


@RestController
@RequestMapping("/api/personagens")
public class PersonagemController {
    
    @Autowired
    private PersonagemService personagemService;

    @PostMapping
    public ResponseEntity<Personagem> criarPersonagem(@RequestBody PersonagemRequestDto body) {
        Personagem personagem =  this.personagemService.criarPersonagem(body);
        return ResponseEntity.ok(personagem);
    }

    @GetMapping
    public ResponseEntity<Page<PersonagemResponseDto>> getPersonagens(@PageableDefault(size=10, sort={"nome"}) Pageable paginacao) {
        Page<PersonagemResponseDto> personagens = personagemService.getPersonagens(paginacao);
        return ResponseEntity.ok(personagens);
    }
}

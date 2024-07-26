package com.fighting_games.api.controllers;

import java.util.UUID;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fighting_games.api.domain.jogo.Jogo;
import com.fighting_games.api.domain.jogo.JogoRequestDto;
import com.fighting_games.api.domain.jogo.JogoResponseDto;
import com.fighting_games.api.services.JogoService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/api/jogos")
public class JogoController {
    
    @Autowired
    private JogoService jogoService;

    @PostMapping
    public ResponseEntity<Jogo> criarJogo(@PathVariable UUID personagemId, @RequestBody JogoRequestDto body) {
        Jogo jogo = this.jogoService.criarJogo(personagemId, body);
        return ResponseEntity.ok(jogo);
    }

    @GetMapping
    public ResponseEntity<Page<JogoResponseDto>> getJogos(@PageableDefault(size=10, sort={"nome"}) Pageable paginacao) {
        Page<JogoResponseDto> jogos = this.jogoService.getJogos(paginacao);
        return ResponseEntity.ok(jogos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<JogoResponseDto> getJogoId(@PathVariable UUID id) {
        JogoResponseDto jogo = jogoService.getJogoId(id);
        return ResponseEntity.ok(jogo);
    }
}

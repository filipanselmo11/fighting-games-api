package com.fighting_games.api.domain.jogo;

import java.util.UUID;

import com.fighting_games.api.domain.personagem.Personagem;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "jogo")
@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Jogo {
    @Id
    @GeneratedValue
    private UUID id;
    private String nome;
    private String descricao;
    private String img;

    @ManyToOne
    @JoinColumn(name = "personagem_id")
    private Personagem personagem;
}

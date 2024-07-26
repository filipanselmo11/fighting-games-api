package com.fighting_games.api.domain.personagem;

import java.sql.Date;
import java.util.UUID;

import com.fighting_games.api.domain.jogo.Jogo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Table(name = "personagem")
@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Personagem {
    @Id
    @GeneratedValue
    private UUID id;
    private String nome;
    private String img;
    private String descricao;

    @OneToOne
    @JoinColumn(name = "jogo_id")
    private Jogo jogo;
}

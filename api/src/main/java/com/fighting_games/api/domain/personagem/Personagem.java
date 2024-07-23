package com.fighting_games.api.domain.personagem;

import java.sql.Date;
import java.util.UUID;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
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
    private String imgUrl;
    private Date data;
}

CREATE TABLE jogo(
    id UUID DEFAULT gen_random_uuid() PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    descricao VARCHAR(255) NOT NULL,
    personagem_id UUID,
    FOREIGN KEY (personagem_id) REFERENCES personagem(id) ON DELETE CASCADE
);
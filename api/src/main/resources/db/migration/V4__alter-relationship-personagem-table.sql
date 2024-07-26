
ALTER TABLE personagem ADD COLUMN jogo_id UUID;

ALTER TABLE personagem ADD CONSTRAINT fk_jogo FOREIGN KEY (jogo_id) REFERENCES jogo(id);

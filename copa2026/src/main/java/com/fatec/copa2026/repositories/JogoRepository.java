package com.fatec.copa2026.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fatec.copa2026.entities.Jogo;
import com.fatec.copa2026.enums.Fase;

import java.util.List;

public interface JogoRepository extends JpaRepository<Jogo, Long> {
    List<Jogo> findByFase(Fase fase);
}

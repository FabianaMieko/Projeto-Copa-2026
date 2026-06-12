package com.fatec.copa2026.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fatec.copa2026.entities.ItemAgenda;

import java.util.List;


public interface ItemAgendaRepository extends JpaRepository<ItemAgenda, Long> {
    List<ItemAgenda> findByNomeTorcedor(String nomeTorcedor);
}

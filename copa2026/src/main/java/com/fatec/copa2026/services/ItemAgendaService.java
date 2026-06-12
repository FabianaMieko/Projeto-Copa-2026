package com.fatec.copa2026.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fatec.copa2026.entities.ItemAgenda;
import com.fatec.copa2026.entities.Jogo;
import com.fatec.copa2026.repositories.ItemAgendaRepository;
import com.fatec.copa2026.repositories.JogoRepository;

import jakarta.persistence.EntityNotFoundException;


@Service
public class ItemAgendaService {

    @Autowired
    private ItemAgendaRepository itemAgendaRepository;

    @Autowired
    private JogoRepository jogoRepository;

    public List<ItemAgenda> findByTorcedor(String nomeTorcedor){
        return itemAgendaRepository.findByNomeTorcedor(nomeTorcedor);
    }

    public ItemAgenda findById(Long id){
        return itemAgendaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Item da agenda não encontrado."));
    }

    public ItemAgenda save(ItemAgenda item, Long jogoId){
        Jogo j = jogoRepository.findById(jogoId)
                .orElseThrow(() -> new EntityNotFoundException("Jogo não encontrado."));

        item.setJogo(j);
        return itemAgendaRepository.save(item);
    }

    public void deleteById(Long id){
        if(itemAgendaRepository.existsById(id)){
            itemAgendaRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException("Item da agenda não encontrado.");
        }
    }
}

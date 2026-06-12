package com.fatec.copa2026.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fatec.copa2026.entities.Jogo;
import com.fatec.copa2026.enums.Fase;
import com.fatec.copa2026.repositories.JogoRepository;

import jakarta.persistence.EntityNotFoundException;


@Service
public class JogoService {

    @Autowired
    private JogoRepository jogoRepository;

    public List<Jogo> findAll(){
        return jogoRepository.findAll();
    }

    public List<Jogo> findByFase(Fase fase){
        return jogoRepository.findByFase(fase);
    }

    public Jogo findById(Long id){
        return jogoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Jogo não encontrado."));
    }

    public Jogo save(Jogo jogo){
        return jogoRepository.save(jogo);
    }

    public Jogo update(Jogo jogoAtualizado, Long id){
        Jogo j = jogoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Jogo não encontrado."));

        j.setTimeMandante(jogoAtualizado.getTimeMandante());
        j.setTimeVisitante(jogoAtualizado.getTimeVisitante());
        j.setSede(jogoAtualizado.getSede());
        j.setDataHora(jogoAtualizado.getDataHora());
        j.setFase(jogoAtualizado.getFase());
        j.setGrupo(jogoAtualizado.getGrupo());

        return jogoRepository.save(j);
    }

    public void deleteById(Long id){
        if(jogoRepository.existsById(id)){
            jogoRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException("Jogo não encontrado.");
        }
    }

}

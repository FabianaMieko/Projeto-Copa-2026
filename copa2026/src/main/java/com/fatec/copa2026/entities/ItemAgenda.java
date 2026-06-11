package com.fatec.copa2026.entities;

import java.io.Serializable;

import com.fatec.copa2026.enums.ModoAssistir;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="TBL_ITEM_AGENDA")
public class ItemAgenda implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomeTorcedor;

    @ManyToOne
    @JoinColumn(name = "jogo_id")
    private Jogo jogo;

    @Enumerated(EnumType.STRING)
    private ModoAssistir modoAssistir;


    private String observacoes;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeTorcedor() {
        return nomeTorcedor;
    }

    public void setNomeTorcedor(String nomeTorcedor) {
        this.nomeTorcedor = nomeTorcedor;
    }

    public Jogo getJogo() {
        return jogo;
    }

    public void setJogo(Jogo jogo) {
        this.jogo = jogo;
    }

    public ModoAssistir getModoAssistir() {
        return modoAssistir;
    }

    public void setModoAssistir(ModoAssistir modoAssistir) {
        this.modoAssistir = modoAssistir;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ItemAgenda other = (ItemAgenda) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }
    
}

package com.provasubstitutiva.fiap.domain.model;

import com.provasubstitutiva.fiap.domain.model.constant.DiasDaSemanaEnum;

import java.time.LocalTime;

public class Horario {

    private Long id;
    private DiasDaSemanaEnum diaDaSemana;
    private LocalTime inicio;
    private LocalTime fim;
    private Long idEstabelecimento;

    public Horario() {
    }

    public Horario(Long id, DiasDaSemanaEnum diaDaSemana, LocalTime inicio, LocalTime fim, Long idEstabelecimento) {
        this.id = id;
        this.diaDaSemana = diaDaSemana;
        this.inicio = inicio;
        this.fim = fim;
        this.idEstabelecimento = idEstabelecimento;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public DiasDaSemanaEnum getDiaDaSemana() {
        return diaDaSemana;
    }

    public void setDiaDaSemana(DiasDaSemanaEnum diaDaSemana) {
        this.diaDaSemana = diaDaSemana;
    }

    public LocalTime getInicio() {
        return inicio;
    }

    public void setInicio(LocalTime inicio) {
        this.inicio = inicio;
    }

    public LocalTime getFim() {
        return fim;
    }

    public void setFim(LocalTime fim) {
        this.fim = fim;
    }

    public Long getIdEstabelecimento() {
        return idEstabelecimento;
    }

    public void setIdEstabelecimento(Long idEstabelecimento) {
        this.idEstabelecimento = idEstabelecimento;
    }
}

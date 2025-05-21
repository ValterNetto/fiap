package com.provasubstitutiva.fiap.application.usecase.agendamento.impl;

import com.provasubstitutiva.fiap.application.usecase.agendamento.BuscarAgendamentosPorProfissionalEDia;
import com.provasubstitutiva.fiap.domain.model.Agendamento;

import java.time.LocalDate;
import java.util.List;

public class BuscarAgendamentosPorProfissionalEDiaImpl {

    private final BuscarAgendamentosPorProfissionalEDia buscarAgendamentosPorProfissionalEDia;

    public BuscarAgendamentosPorProfissionalEDiaImpl(BuscarAgendamentosPorProfissionalEDia buscarAgendamentosPorProfissionalEDia) {
        this.buscarAgendamentosPorProfissionalEDia = buscarAgendamentosPorProfissionalEDia;
    }

    public List<Agendamento> buscarAgendamentos(Long idProfissional, LocalDate data) {
        return buscarAgendamentosPorProfissionalEDia.buscarAgendamentos(idProfissional, data);
    }
}

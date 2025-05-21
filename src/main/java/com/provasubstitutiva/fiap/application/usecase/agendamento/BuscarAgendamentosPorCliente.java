package com.provasubstitutiva.fiap.application.usecase.agendamento;

import com.provasubstitutiva.fiap.domain.model.Agendamento;

import java.util.List;

public interface BuscarAgendamentosPorCliente {

    List<Agendamento> buscarAgendamentos(Long idCliente);
}

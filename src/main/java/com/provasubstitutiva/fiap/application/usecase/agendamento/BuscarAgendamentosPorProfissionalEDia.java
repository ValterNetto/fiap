package com.provasubstitutiva.fiap.application.usecase.agendamento;

import com.provasubstitutiva.fiap.domain.model.Agendamento;

import java.time.LocalDate;
import java.util.List;

public interface BuscarAgendamentosPorProfissionalEDia {
    List<Agendamento> buscarAgendamentos(Long idProfissional, LocalDate data);
}

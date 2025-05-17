package com.provasubstitutiva.fiap.application.usecase.agendamento.impl;

import com.provasubstitutiva.fiap.application.usecase.agendamento.CancelarAgendamento;
import com.provasubstitutiva.fiap.domain.model.Agendamento;

public class CancelarAgendamentoImpl {
    private final CancelarAgendamento cancelarAgendamento;

    public CancelarAgendamentoImpl(CancelarAgendamento cancelarAgendamento) {
        this.cancelarAgendamento = cancelarAgendamento;
    }

    public Agendamento cancelar(Long idAgendamento) {
        return cancelarAgendamento.cancelar(idAgendamento);
    }
}

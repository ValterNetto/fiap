package com.provasubstitutiva.fiap.application.usecase.agendamento;

import com.provasubstitutiva.fiap.domain.model.Agendamento;

public interface CancelarAgendamento {
    Agendamento cancelar(Long idAgendamento);
}

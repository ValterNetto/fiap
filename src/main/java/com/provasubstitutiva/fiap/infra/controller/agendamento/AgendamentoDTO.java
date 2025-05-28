package com.provasubstitutiva.fiap.infra.controller.agendamento;

import com.provasubstitutiva.fiap.domain.model.Agendamento;
import com.provasubstitutiva.fiap.domain.model.constant.StatusEnum;

import java.time.LocalDate;
import java.time.LocalTime;

public record AgendamentoDTO(
        Long id,
        Long idProfissional,
        Long idEstabelecimento,
        Long idCliente,
        Long idServico,
        StatusEnum status,
        LocalDate data,
        LocalTime horaInicio,
        LocalTime horaTermino
) {

    public AgendamentoDTO(Agendamento agendamento) {
        this(
        agendamento.getId(),
        agendamento.getIdProfissional(),
        agendamento.getIdEstabelecimento(),
        agendamento.getIdCliente(),
        agendamento.getIdServico(),
        agendamento.getStatus(),
        agendamento.getData(),
        agendamento.getHoraInicio(),
        agendamento.getHoraTermino()
        );
    }
}

package com.provasubstitutiva.fiap.application.usecase.notificacao.impl;

import com.provasubstitutiva.fiap.application.usecase.agendamento.BuscarAgendamentoPorId;
import com.provasubstitutiva.fiap.application.usecase.cliente.BuscarClientePorId;
import com.provasubstitutiva.fiap.application.usecase.notificacao.EnviarEmailNotificandoAgendamento;
import com.provasubstitutiva.fiap.application.usecase.profissional.BuscarProfissionalPorId;
import com.provasubstitutiva.fiap.domain.model.Agendamento;
import com.provasubstitutiva.fiap.domain.model.Cliente;
import com.provasubstitutiva.fiap.domain.model.Profissional;

import java.util.NoSuchElementException;
import java.util.Objects;

public class EnviarEmailNotificandoAgendamentoImpl {

    private final EnviarEmailNotificandoAgendamento enviarEmailNotificandoAgendamento;
    private final BuscarAgendamentoPorId buscarAgendamentoPorId;
    private final BuscarProfissionalPorId buscarProfissionalPorId;
    private final BuscarClientePorId buscarClientePorId;

    public EnviarEmailNotificandoAgendamentoImpl(EnviarEmailNotificandoAgendamento enviarEmailNotificandoAgendamento, BuscarAgendamentoPorId buscarAgendamentoPorId, BuscarProfissionalPorId buscarProfissionalPorId, BuscarClientePorId buscarClientePorId) {
        this.enviarEmailNotificandoAgendamento = enviarEmailNotificandoAgendamento;
        this.buscarAgendamentoPorId = buscarAgendamentoPorId;
        this.buscarProfissionalPorId = buscarProfissionalPorId;
        this.buscarClientePorId = buscarClientePorId;
    }

    public void enviarEmailNotificandoAgendamento(Long idAgendamento) {
        Agendamento agendamento = buscarAgendamentoPorId.buscarAgendamentoPorId(idAgendamento);
        if(Objects.isNull(agendamento)) {
            throw new NoSuchElementException("Não foi possível encontrar o agendamento");
        }

        Profissional profissional = buscarProfissionalPorId.buscarPorId(agendamento.getIdProfissional());
        Cliente cliente = buscarClientePorId.buscarClientePorId(agendamento.getIdCliente());

        enviarEmailNotificandoAgendamento.enviarEmailNotificandoOAgendamento(
                cliente.getEmail(),
                profissional.getEmail()
        );
    }
}

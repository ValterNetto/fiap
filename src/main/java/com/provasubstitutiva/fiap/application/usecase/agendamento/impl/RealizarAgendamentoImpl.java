package com.provasubstitutiva.fiap.application.usecase.agendamento.impl;

import com.provasubstitutiva.fiap.application.usecase.agendamento.BuscarAgendamentosPorProfissionalEDia;
import com.provasubstitutiva.fiap.application.usecase.agendamento.RealizarAgendamento;
import com.provasubstitutiva.fiap.application.usecase.cliente.BuscarClientePorId;
import com.provasubstitutiva.fiap.application.usecase.estabelecimento.BuscarEstabelecimentoPorId;
import com.provasubstitutiva.fiap.application.usecase.horario.BuscarHorarioPorDia;
import com.provasubstitutiva.fiap.application.usecase.notificacao.EnviarEmailNotificandoAgendamento;
import com.provasubstitutiva.fiap.application.usecase.profissional.BuscarProfissionalPorId;
import com.provasubstitutiva.fiap.application.usecase.servico.BuscarServicoPorId;
import com.provasubstitutiva.fiap.domain.model.*;
import com.provasubstitutiva.fiap.domain.model.constant.DiasDaSemanaEnum;
import com.provasubstitutiva.fiap.domain.model.constant.StatusEnum;
import lombok.AllArgsConstructor;

import java.util.NoSuchElementException;
import java.util.Objects;

public class RealizarAgendamentoImpl {
    private final RealizarAgendamento realizarAgendamento;
    private final BuscarClientePorId buscarClientePorId;
    private final BuscarProfissionalPorId buscarProfissionalPorId;
    private final BuscarEstabelecimentoPorId buscarEstabelecimentoPorId;
    private final BuscarServicoPorId buscarServicoPorId;
    private final BuscarHorarioPorDia buscarHorarioPorDia;
    private final BuscarAgendamentosPorProfissionalEDia buscarAgendamentosPorProfissionalEDia;

    public RealizarAgendamentoImpl(RealizarAgendamento realizarAgendamento, BuscarClientePorId buscarClientePorId, BuscarProfissionalPorId buscarProfissionalPorId, BuscarEstabelecimentoPorId buscarEstabelecimentoPorId, BuscarServicoPorId buscarServicoPorId, BuscarHorarioPorDia buscarHorarioPorDia, BuscarAgendamentosPorProfissionalEDia buscarAgendamentosPorProfissionalEDia) {
        this.realizarAgendamento = realizarAgendamento;
        this.buscarClientePorId = buscarClientePorId;
        this.buscarProfissionalPorId = buscarProfissionalPorId;
        this.buscarEstabelecimentoPorId = buscarEstabelecimentoPorId;
        this.buscarServicoPorId = buscarServicoPorId;
        this.buscarHorarioPorDia = buscarHorarioPorDia;
        this.buscarAgendamentosPorProfissionalEDia = buscarAgendamentosPorProfissionalEDia;
    }

    public Agendamento realizarAgendamento(Agendamento agendamento) {
        if (Objects.isNull(buscarClientePorId.buscarClientePorId(agendamento.getIdCliente()))) {
            throw new NoSuchElementException("Cliente não encontrato");
        }

        Profissional profissional = buscarProfissionalPorId.buscarPorId(agendamento.getIdProfissional());
        if (Objects.isNull(profissional)) {
            throw new NoSuchElementException("Profissional não encontrado");
        }

        Estabelecimento estabelecimento = buscarEstabelecimentoPorId.buscarEstabelecimentoPorId(agendamento.getIdEstabelecimento());
        if (Objects.isNull(estabelecimento)) {
            throw new NoSuchElementException("Estabelecimento não encontrado");
        }

        Servico servico = buscarServicoPorId.buscarServicoPorId(agendamento.getIdServico());
        if (Objects.isNull(servico)) {
            throw new NoSuchElementException("Serviço não encontrado");
        }

        if (!profissional.getIdEstabelecimento().equals(estabelecimento.getId())
        || !servico.getIdEstabelecimento().equals(estabelecimento.getId())) {
            throw new IllegalStateException("O profissional ou o serviço não está vinculado ao estabelecimento fornecido");
        }

        if(!haDisponibilidadeDeDataEHorario(agendamento, estabelecimento)) {
            throw new IllegalStateException("Há um conflito com o horário de inicio e/ou término do agendamento");
        }

        agendamento.setStatus(StatusEnum.AGENDADO);
        return realizarAgendamento.agendar(agendamento);
    }

    private boolean haDisponibilidadeDeDataEHorario(Agendamento agendamento, Estabelecimento estabelecimento) {
        String dayOfWeek = agendamento.getData().getDayOfWeek().toString();
        Horario horarioDoEstabelecimento = buscarHorarioPorDia.buscarHorarioPorDia(estabelecimento.getId(), DiasDaSemanaEnum.valueOf(dayOfWeek));
        if (Objects.nonNull(horarioDoEstabelecimento) &&
                (agendamento.getHoraInicio().isBefore(horarioDoEstabelecimento.getInicio())
        || agendamento.getHoraTermino().isAfter(horarioDoEstabelecimento.getFim()))) {
            return false;
        }
        return buscarAgendamentosPorProfissionalEDia.buscarAgendamentos(
                agendamento.getIdProfissional(),
                agendamento.getData())
                .stream()
                .noneMatch(agendamentoExistente ->
                        agendamento.getHoraInicio().isBefore(agendamentoExistente.getHoraTermino())
                        && agendamento.getHoraTermino().isAfter(agendamentoExistente.getHoraInicio()));
    }
}

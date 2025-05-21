package com.provasubstitutiva.fiap.application.usecase.avaliacao.impl;

import com.provasubstitutiva.fiap.application.usecase.agendamento.BuscarAgendamentosPorCliente;
import com.provasubstitutiva.fiap.application.usecase.avaliacao.AvaliarProfissional;
import com.provasubstitutiva.fiap.application.usecase.cliente.BuscarClientePorId;
import com.provasubstitutiva.fiap.application.usecase.estabelecimento.BuscarEstabelecimentoPorId;
import com.provasubstitutiva.fiap.application.usecase.profissional.BuscarProfissionalPorId;
import com.provasubstitutiva.fiap.domain.model.Avaliacao;
import com.provasubstitutiva.fiap.domain.model.constant.StatusEnum;

import java.util.NoSuchElementException;
import java.util.Objects;

public class AvaliarProfissionalImpl {

    private final AvaliarProfissional avaliarProfissional;
    private final BuscarClientePorId buscarClientePorId;
    private final BuscarProfissionalPorId buscarProfissionalPorId;
    private final BuscarAgendamentosPorCliente buscarAgendamentosPorCliente;


    public AvaliarProfissionalImpl(AvaliarProfissional avaliarProfissional, BuscarClientePorId buscarClientePorId, BuscarProfissionalPorId buscarProfissionalPorId, BuscarAgendamentosPorCliente buscarAgendamentosPorCliente) {
        this.avaliarProfissional = avaliarProfissional;
        this.buscarClientePorId = buscarClientePorId;
        this.buscarProfissionalPorId = buscarProfissionalPorId;
        this.buscarAgendamentosPorCliente = buscarAgendamentosPorCliente;
    }

    public Avaliacao avaliarProfissional(Avaliacao avaliacao) {
        if(Objects.isNull(buscarClientePorId.buscarClientePorId(avaliacao.getIdCliente()))
                || Objects.isNull(buscarProfissionalPorId.buscarPorId(avaliacao.getIdProfissional()))) {
            throw new NoSuchElementException("Cliente e/ou profissional não encontrado(s)");
        }
        if (!jaFrequentouOLugar(avaliacao.getIdCliente(), avaliacao.getIdProfissional())){
            throw new IllegalStateException("O cliente não pode avaliar um profissional ao qual nunca tenha concluido " +
                    "um agendamento");
        }
        return avaliarProfissional.avaliarProfissional(avaliacao);
    }

    private boolean jaFrequentouOLugar(Long idCliente, Long idProfissional) {
        return buscarAgendamentosPorCliente.buscarAgendamentos(idCliente)
                .stream()
                .anyMatch(agendamento -> agendamento.getIdProfissional().equals(idProfissional)
                        && agendamento.getStatus().equals(StatusEnum.CONCLUIDO));
    }
}

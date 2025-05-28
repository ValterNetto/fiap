package com.provasubstitutiva.fiap.application.usecase.avaliacao.impl;

import com.provasubstitutiva.fiap.application.usecase.agendamento.BuscarAgendamentosPorCliente;
import com.provasubstitutiva.fiap.application.usecase.avaliacao.AvaliarEstabelecimento;
import com.provasubstitutiva.fiap.application.usecase.cliente.BuscarClientePorId;
import com.provasubstitutiva.fiap.application.usecase.estabelecimento.BuscarEstabelecimentoPorId;
import com.provasubstitutiva.fiap.domain.model.Avaliacao;
import com.provasubstitutiva.fiap.domain.model.constant.StatusEnum;

import java.util.NoSuchElementException;
import java.util.Objects;

public class AvaliarEstabelecimentoImpl {

    private final AvaliarEstabelecimento avaliarEstabelecimento;
    private final BuscarClientePorId buscarClientePorId;
    private final BuscarEstabelecimentoPorId buscarEstabelecimentoPorId;
    private final BuscarAgendamentosPorCliente buscarAgendamentosPorCliente;

    public AvaliarEstabelecimentoImpl(AvaliarEstabelecimento avaliarEstabelecimento, BuscarClientePorId buscarClientePorId, BuscarEstabelecimentoPorId buscarEstabelecimentoPorId, BuscarAgendamentosPorCliente buscarAgendamentosPorCliente) {
        this.avaliarEstabelecimento = avaliarEstabelecimento;
        this.buscarClientePorId = buscarClientePorId;
        this.buscarEstabelecimentoPorId = buscarEstabelecimentoPorId;
        this.buscarAgendamentosPorCliente = buscarAgendamentosPorCliente;
    }

    public Avaliacao fazerAvaliacao(Avaliacao avaliacao) {
        if(Objects.isNull(buscarClientePorId.buscarClientePorId(avaliacao.getIdCliente()))
        || Objects.isNull(buscarEstabelecimentoPorId.buscarEstabelecimentoPorId(avaliacao.getIdEstabelecimento()))) {
            throw new NoSuchElementException("Cliente e/ou estabelecimento não encontrado(s)");
        }
        if (!jaFrequentouOLugar(avaliacao.getIdCliente(), avaliacao.getIdEstabelecimento())){
            throw new IllegalStateException("O cliente não pode avaliar um estabelecimento ao qual nunca tenha concluido " +
                    "um agendamento");
        }
        avaliacao.setIdProfissional(null);
        return avaliarEstabelecimento.fazerAvaliacao(avaliacao);
    }

    private boolean jaFrequentouOLugar(Long idCliente, Long idEstabelecimento) {
        return buscarAgendamentosPorCliente.buscarAgendamentos(idCliente)
                .stream()
                .anyMatch(agendamento -> agendamento.getIdEstabelecimento().equals(idEstabelecimento)
                && agendamento.getStatus().equals(StatusEnum.CONCLUIDO));
    }
}

package com.provasubstitutiva.fiap.application.usecase.avaliacao.impl;

import com.provasubstitutiva.fiap.application.usecase.avaliacao.BuscarAvaliacoesPorIdCliente;
import com.provasubstitutiva.fiap.domain.model.Avaliacao;

import java.util.List;

public class BuscarAvaliacoesPorIdClienteImpl {

    private final BuscarAvaliacoesPorIdCliente buscarAvaliacoesPorIdCliente;

    public BuscarAvaliacoesPorIdClienteImpl(BuscarAvaliacoesPorIdCliente buscarAvaliacoesPorIdCliente) {
        this.buscarAvaliacoesPorIdCliente = buscarAvaliacoesPorIdCliente;
    }

    public List<Avaliacao> buscarAvaliacaoPorIdCliente(Long idCliente) {
        return buscarAvaliacoesPorIdCliente.buscarAvaliacoesPorIdCliente(idCliente);
    }
}

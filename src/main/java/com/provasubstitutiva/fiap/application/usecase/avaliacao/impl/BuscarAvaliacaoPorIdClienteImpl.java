package com.provasubstitutiva.fiap.application.usecase.avaliacao.impl;

import com.provasubstitutiva.fiap.application.usecase.avaliacao.BuscarAvaliacaoPorIdCliente;
import com.provasubstitutiva.fiap.domain.model.Avaliacao;

import java.util.List;

public class BuscarAvaliacaoPorIdClienteImpl {

    private final BuscarAvaliacaoPorIdCliente buscarAvaliacaoPorIdCliente;

    public BuscarAvaliacaoPorIdClienteImpl(BuscarAvaliacaoPorIdCliente buscarAvaliacaoPorIdCliente) {
        this.buscarAvaliacaoPorIdCliente = buscarAvaliacaoPorIdCliente;
    }

    public List<Avaliacao> buscarAvaliacaoPorIdCliente(Long idCliente) {
        return buscarAvaliacaoPorIdCliente.buscarAvaliacoesPorIdCliente(idCliente);
    }
}

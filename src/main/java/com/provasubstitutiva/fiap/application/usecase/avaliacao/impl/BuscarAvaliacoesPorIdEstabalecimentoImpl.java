package com.provasubstitutiva.fiap.application.usecase.avaliacao.impl;

import com.provasubstitutiva.fiap.application.usecase.avaliacao.BuscarAvaliacoesPorIdEstabelecimento;
import com.provasubstitutiva.fiap.domain.model.Avaliacao;

import java.util.List;

public class BuscarAvaliacoesPorIdEstabalecimentoImpl {

    private final BuscarAvaliacoesPorIdEstabelecimento buscarAvaliacoesPorIdEstabelecimento;

    public BuscarAvaliacoesPorIdEstabalecimentoImpl(BuscarAvaliacoesPorIdEstabelecimento buscarAvaliacoesPorIdEstabelecimento) {
        this.buscarAvaliacoesPorIdEstabelecimento = buscarAvaliacoesPorIdEstabelecimento;
    }

    public List<Avaliacao> buscarporIdEstabelecimento(Long idEstabelecimento) {
        return buscarAvaliacoesPorIdEstabelecimento.buscarPorIdEstabelecimento(idEstabelecimento);
    }
}

package com.provasubstitutiva.fiap.application.usecase.avaliacao.impl;

import com.provasubstitutiva.fiap.application.usecase.avaliacao.BuscarPorIdEstabelecimento;
import com.provasubstitutiva.fiap.domain.model.Avaliacao;

import java.util.List;

public class BuscarPorIdEstabalecimentoImpl {

    private final BuscarPorIdEstabelecimento buscarPorIdEstabelecimento;

    public BuscarPorIdEstabalecimentoImpl(BuscarPorIdEstabelecimento buscarPorIdEstabelecimento) {
        this.buscarPorIdEstabelecimento = buscarPorIdEstabelecimento;
    }

    public List<Avaliacao> buscarporIdEstabelecimento(Long idEstabelecimento) {
        return buscarPorIdEstabelecimento.buscarPorIdEstabelecimento(idEstabelecimento);
    }
}

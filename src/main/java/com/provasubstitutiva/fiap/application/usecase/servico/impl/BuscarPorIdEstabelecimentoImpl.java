package com.provasubstitutiva.fiap.application.usecase.servico.impl;

import com.provasubstitutiva.fiap.application.usecase.servico.BuscarPorIdEstabelecimento;
import com.provasubstitutiva.fiap.domain.model.Servico;

import java.util.List;

public class BuscarPorIdEstabelecimentoImpl {

    private final BuscarPorIdEstabelecimento buscarPorIdEstabelecimento;

    public BuscarPorIdEstabelecimentoImpl(BuscarPorIdEstabelecimento buscarPorIdEstabelecimento) {
        this.buscarPorIdEstabelecimento = buscarPorIdEstabelecimento;
    }

    public List<Servico> buscarPorIdEstabelecimento(Long id) {
        return buscarPorIdEstabelecimento.buscarPorIdEstabelecimento(id);
    }
}

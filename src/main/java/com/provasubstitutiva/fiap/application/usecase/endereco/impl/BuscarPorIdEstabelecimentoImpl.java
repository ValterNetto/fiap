package com.provasubstitutiva.fiap.application.usecase.endereco.impl;

import com.provasubstitutiva.fiap.application.usecase.endereco.BuscarEnderecoPorIdEstabelecimento;
import com.provasubstitutiva.fiap.domain.model.Endereco;

public class BuscarPorIdEstabelecimentoImpl {

    private final BuscarEnderecoPorIdEstabelecimento buscarEnderecoPorIdEstabelecimento;

    public BuscarPorIdEstabelecimentoImpl(BuscarEnderecoPorIdEstabelecimento buscarEnderecoPorIdEstabelecimento) {
        this.buscarEnderecoPorIdEstabelecimento = buscarEnderecoPorIdEstabelecimento;
    }

    public Endereco buscarPorIdEstabelecimento(Long idEstabelecimento) {
        return buscarEnderecoPorIdEstabelecimento.buscarPorIdEstabelecimento(idEstabelecimento);
    }
}

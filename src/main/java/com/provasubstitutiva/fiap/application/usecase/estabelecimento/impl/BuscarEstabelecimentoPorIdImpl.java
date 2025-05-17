package com.provasubstitutiva.fiap.application.usecase.estabelecimento.impl;

import com.provasubstitutiva.fiap.application.usecase.estabelecimento.BuscarEstabelecimentoPorId;
import com.provasubstitutiva.fiap.domain.model.Estabelecimento;

public class BuscarEstabelecimentoPorIdImpl {

    private final BuscarEstabelecimentoPorId estabelecimentoPorId;

    public BuscarEstabelecimentoPorIdImpl(BuscarEstabelecimentoPorId estabelecimentoPorId) {
        this.estabelecimentoPorId = estabelecimentoPorId;
    }

    public Estabelecimento buscarEstabelecimentoPorId(Long id) {
        return buscarEstabelecimentoPorId(id);
    }
}

package com.provasubstitutiva.fiap.application.usecase.endereco.impl;

import com.provasubstitutiva.fiap.application.usecase.endereco.BuscarEnderecoPorId;
import com.provasubstitutiva.fiap.domain.model.Endereco;

public class BuscarEnderecoPorIdImpl {

    private final BuscarEnderecoPorId buscarEnderecoPorId;

    public BuscarEnderecoPorIdImpl(BuscarEnderecoPorId buscarEnderecoPorId) {
        this.buscarEnderecoPorId = buscarEnderecoPorId;
    }

    public Endereco buscarEnderecoPorId(Long id) {
        return buscarEnderecoPorId.buscarEnderecoPorId(id);
    }
}

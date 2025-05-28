package com.provasubstitutiva.fiap.application.usecase.endereco.impl;

import com.provasubstitutiva.fiap.application.usecase.endereco.BuscarEnderecoPorId;
import com.provasubstitutiva.fiap.domain.model.Endereco;

import java.util.NoSuchElementException;
import java.util.Objects;

public class BuscarEnderecoPorIdImpl {

    private final BuscarEnderecoPorId buscarEnderecoPorId;

    public BuscarEnderecoPorIdImpl(BuscarEnderecoPorId buscarEnderecoPorId) {
        this.buscarEnderecoPorId = buscarEnderecoPorId;
    }

    public Endereco buscarEnderecoPorId(Long id) {
        Endereco endereco = buscarEnderecoPorId.buscarEnderecoPorId(id);
        if(Objects.isNull(endereco)) {
            throw new NoSuchElementException("Não foi possível encontrar o endereço");
        }
        return endereco;
    }
}

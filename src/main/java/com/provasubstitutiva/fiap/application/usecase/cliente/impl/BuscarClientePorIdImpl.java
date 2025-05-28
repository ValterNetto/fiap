package com.provasubstitutiva.fiap.application.usecase.cliente.impl;

import com.provasubstitutiva.fiap.application.usecase.cliente.BuscarClientePorId;
import com.provasubstitutiva.fiap.domain.model.Cliente;

import java.util.NoSuchElementException;
import java.util.Objects;

public class BuscarClientePorIdImpl {

    private final BuscarClientePorId buscarClientePorId;

    public BuscarClientePorIdImpl(BuscarClientePorId buscarClientePorId) {
        this.buscarClientePorId = buscarClientePorId;
    }

    public Cliente buscarClientePorId(Long id) {
        Cliente cliente = buscarClientePorId.buscarClientePorId(id);
        if (Objects.isNull(cliente)) {
            throw new NoSuchElementException("Não foi possível encontrar o cliente");
        }
        return cliente;
    }
}

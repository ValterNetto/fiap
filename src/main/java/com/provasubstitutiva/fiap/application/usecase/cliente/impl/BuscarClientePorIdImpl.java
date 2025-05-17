package com.provasubstitutiva.fiap.application.usecase.cliente.impl;

import com.provasubstitutiva.fiap.application.usecase.cliente.BuscarClientePorId;
import com.provasubstitutiva.fiap.domain.model.Cliente;

public class BuscarClientePorIdImpl {

    private final BuscarClientePorId buscarClientePorId;

    public BuscarClientePorIdImpl(BuscarClientePorId buscarClientePorId) {
        this.buscarClientePorId = buscarClientePorId;
    }

    public Cliente buscarClientePorId(Long id) {
        return buscarClientePorId.buscarClientePorId(id);
    }
}

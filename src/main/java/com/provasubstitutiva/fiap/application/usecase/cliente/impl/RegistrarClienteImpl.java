package com.provasubstitutiva.fiap.application.usecase.cliente.impl;

import com.provasubstitutiva.fiap.application.usecase.cliente.RegistrarCliente;
import com.provasubstitutiva.fiap.domain.model.Cliente;

public class RegistrarClienteImpl {

    private final RegistrarCliente registrarCliente;

    public RegistrarClienteImpl(RegistrarCliente registrarCliente) {
        this.registrarCliente = registrarCliente;
    }

    public Cliente registrarCliente(Cliente cliente) {
        return registrarCliente.registrarCliente(cliente);
    }
}

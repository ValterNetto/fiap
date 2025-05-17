package com.provasubstitutiva.fiap.application.usecase.cliente.impl;

import com.provasubstitutiva.fiap.application.usecase.cliente.VerTodosOsClientes;
import com.provasubstitutiva.fiap.domain.model.Cliente;

import java.util.List;

public class VerTodosOsClientesImpl {

    private final VerTodosOsClientes verTodosOsClientes;

    public VerTodosOsClientesImpl(VerTodosOsClientes verTodosOsClientes) {
        this.verTodosOsClientes = verTodosOsClientes;
    }

    public List<Cliente> verTodosOsClientes() {
        return verTodosOsClientes.verTodosOsClientes();
    }
}

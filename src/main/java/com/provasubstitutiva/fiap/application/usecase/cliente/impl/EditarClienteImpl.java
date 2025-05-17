package com.provasubstitutiva.fiap.application.usecase.cliente.impl;

import com.provasubstitutiva.fiap.application.usecase.cliente.EditarCliente;
import com.provasubstitutiva.fiap.domain.model.Cliente;

public class EditarClienteImpl {

    private final EditarCliente editarCliente;

    public EditarClienteImpl(EditarCliente editarCliente) {
        this.editarCliente = editarCliente;
    }

    public Cliente editar(Cliente cliente) {
        return editarCliente.editarCliente(cliente);
    }
}

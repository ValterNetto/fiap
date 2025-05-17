package com.provasubstitutiva.fiap.application.usecase.cliente.impl;

import com.provasubstitutiva.fiap.application.usecase.cliente.ExcluirCliente;

public class ExcluirClienteImpl {

    private final ExcluirCliente excluirCliente;

    public ExcluirClienteImpl(ExcluirCliente excluirCliente) {
        this.excluirCliente = excluirCliente;
    }

    public void excluirCliente(Long id) {
        excluirCliente.excluirCliente(id);
    }
}

package com.provasubstitutiva.fiap.application.usecase.cliente;

import com.provasubstitutiva.fiap.domain.model.Cliente;

public interface BuscarClientePorId {
    Cliente buscarClientePorId(Long id);
}

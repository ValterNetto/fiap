package com.provasubstitutiva.fiap.infra.controller.cliente;

import com.provasubstitutiva.fiap.domain.model.Cliente;

public record ClienteDTO(
        Long id,
        String nome,
        String email
) {
    public ClienteDTO(Cliente cliente) {
        this(cliente.getId(), cliente.getNome(), cliente.getEmail());
    }
}

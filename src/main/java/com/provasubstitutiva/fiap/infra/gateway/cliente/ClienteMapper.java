package com.provasubstitutiva.fiap.infra.gateway.cliente;

import com.provasubstitutiva.fiap.domain.model.Cliente;
import com.provasubstitutiva.fiap.infra.persistence.cliente.ClienteEntity;

public class ClienteMapper {

    public Cliente toDomain(ClienteEntity in) {
        return new Cliente(
                in.getId(),
                in.getNome(),
                in.getEmail()
        );
    }

    public ClienteEntity toEntity(Cliente in) {
        return new ClienteEntity(
                in.getId(),
                in.getNome(),
                in.getEmail()
        );
    }
}

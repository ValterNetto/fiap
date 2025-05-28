package com.provasubstitutiva.fiap.infra.gateway.cliente;

import com.provasubstitutiva.fiap.application.usecase.cliente.BuscarClientePorId;
import com.provasubstitutiva.fiap.application.usecase.cliente.EditarCliente;
import com.provasubstitutiva.fiap.application.usecase.cliente.RegistrarCliente;
import com.provasubstitutiva.fiap.domain.model.Cliente;
import com.provasubstitutiva.fiap.infra.persistence.cliente.ClienteRepository;
import lombok.AllArgsConstructor;

public class ClienteJPAAdapter implements
        BuscarClientePorId,
        EditarCliente,
        RegistrarCliente {

    private final ClienteRepository repository;
    private final ClienteMapper mapper;

    public ClienteJPAAdapter(ClienteRepository repository, ClienteMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Cliente buscarClientePorId(Long id) {
        return repository.findById(id).map(mapper::toDomain).orElse(null);
    }

    @Override
    public Cliente editarCliente(Cliente cliente) {
        return mapper.toDomain(repository.save(mapper.toEntity(cliente)));
    }

    @Override
    public Cliente registrarCliente(Cliente cliente) {
        return mapper.toDomain(repository.save(mapper.toEntity(cliente)));
    }
}

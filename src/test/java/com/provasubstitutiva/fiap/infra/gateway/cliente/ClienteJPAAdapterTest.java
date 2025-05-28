package com.provasubstitutiva.fiap.infra.gateway.cliente;

import com.provasubstitutiva.fiap.domain.model.Cliente;
import com.provasubstitutiva.fiap.infra.persistence.cliente.ClienteEntity;
import com.provasubstitutiva.fiap.infra.persistence.cliente.ClienteRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ClienteJPAAdapterTest {

    private ClienteRepository repository;
    private ClienteMapper mapper;
    private ClienteJPAAdapter adapter;

    private Cliente clienteDomain;
    private ClienteEntity clienteEntity;

    @BeforeEach
    void setup() {
        repository = mock(ClienteRepository.class);
        mapper = mock(ClienteMapper.class);
        adapter = new ClienteJPAAdapter(repository, mapper);

        clienteDomain = new Cliente(1L, "Joana", "joana@email.com");
        clienteEntity = new ClienteEntity();
    }

    @Test
    void testBuscarClientePorIdExiste() {
        when(repository.findById(1L)).thenReturn(Optional.of(clienteEntity));
        when(mapper.toDomain(clienteEntity)).thenReturn(clienteDomain);

        Cliente result = adapter.buscarClientePorId(1L);

        assertNotNull(result);
        assertEquals(clienteDomain, result);
    }

    @Test
    void testBuscarClientePorIdNaoExiste() {
        when(repository.findById(1L)).thenReturn(Optional.empty());

        Cliente result = adapter.buscarClientePorId(1L);

        assertNull(result);
    }

    @Test
    void testEditarCliente() {
        when(mapper.toEntity(clienteDomain)).thenReturn(clienteEntity);
        when(repository.save(clienteEntity)).thenReturn(clienteEntity);
        when(mapper.toDomain(clienteEntity)).thenReturn(clienteDomain);

        Cliente result = adapter.editarCliente(clienteDomain);

        assertNotNull(result);
        assertEquals(clienteDomain, result);
    }

    @Test
    void testRegistrarCliente() {
        when(mapper.toEntity(clienteDomain)).thenReturn(clienteEntity);
        when(repository.save(clienteEntity)).thenReturn(clienteEntity);
        when(mapper.toDomain(clienteEntity)).thenReturn(clienteDomain);

        Cliente result = adapter.registrarCliente(clienteDomain);

        assertNotNull(result);
        assertEquals(clienteDomain, result);
    }
}

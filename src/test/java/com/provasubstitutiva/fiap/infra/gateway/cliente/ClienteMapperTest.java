package com.provasubstitutiva.fiap.infra.gateway.cliente;

import com.provasubstitutiva.fiap.domain.model.Cliente;
import com.provasubstitutiva.fiap.infra.persistence.cliente.ClienteEntity;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClienteMapperTest {

    private final ClienteMapper mapper = new ClienteMapper();

    @Test
    void testToDomain() {
        ClienteEntity entity = new ClienteEntity(1L, "Lucas", "lucas@email.com");

        Cliente domain = mapper.toDomain(entity);

        assertEquals(entity.getId(), domain.getId());
        assertEquals(entity.getNome(), domain.getNome());
        assertEquals(entity.getEmail(), domain.getEmail());
    }

    @Test
    void testToEntity() {
        Cliente domain = new Cliente(2L, "Mariana", "mariana@email.com");

        ClienteEntity entity = mapper.toEntity(domain);

        assertEquals(domain.getId(), entity.getId());
        assertEquals(domain.getNome(), entity.getNome());
        assertEquals(domain.getEmail(), entity.getEmail());
    }
}

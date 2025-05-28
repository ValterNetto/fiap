package com.provasubstitutiva.fiap.infra.persistence.cliente;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClienteEntityTest {

    @Test
    void testAllArgsConstructorAndGetters() {
        ClienteEntity entity = new ClienteEntity(
                1L,
                "Carla Silva",
                "carla@email.com"
        );

        assertEquals(1L, entity.getId());
        assertEquals("Carla Silva", entity.getNome());
        assertEquals("carla@email.com", entity.getEmail());
    }

    @Test
    void testSettersAndNoArgsConstructor() {
        ClienteEntity entity = new ClienteEntity();

        entity.setId(2L);
        entity.setNome("Bruno Costa");
        entity.setEmail("bruno@email.com");

        assertEquals(2L, entity.getId());
        assertEquals("Bruno Costa", entity.getNome());
        assertEquals("bruno@email.com", entity.getEmail());
    }
}

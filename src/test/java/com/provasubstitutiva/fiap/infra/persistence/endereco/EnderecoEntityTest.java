package com.provasubstitutiva.fiap.infra.persistence.endereco;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EnderecoEntityTest {

    @Test
    void testAllArgsConstructorAndGetters() {
        EnderecoEntity entity = new EnderecoEntity(
                1L,
                "Rua das Palmeiras",
                "12345-678",
                "45A",
                -23.5505,
                -46.6333,
                10L
        );

        assertEquals(1L, entity.getId());
        assertEquals("Rua das Palmeiras", entity.getLogradouro());
        assertEquals("12345-678", entity.getCep());
        assertEquals("45A", entity.getNumero());
        assertEquals(-23.5505, entity.getLatitude());
        assertEquals(-46.6333, entity.getLongitude());
        assertEquals(10L, entity.getIdEstabelecimento());
    }

    @Test
    void testSettersAndNoArgsConstructor() {
        EnderecoEntity entity = new EnderecoEntity();

        entity.setId(2L);
        entity.setLogradouro("Avenida Brasil");
        entity.setCep("98765-432");
        entity.setNumero("1000");
        entity.setLatitude(-22.9068);
        entity.setLongitude(-43.1729);
        entity.setIdEstabelecimento(20L);

        assertEquals(2L, entity.getId());
        assertEquals("Avenida Brasil", entity.getLogradouro());
        assertEquals("98765-432", entity.getCep());
        assertEquals("1000", entity.getNumero());
        assertEquals(-22.9068, entity.getLatitude());
        assertEquals(-43.1729, entity.getLongitude());
        assertEquals(20L, entity.getIdEstabelecimento());
    }
}

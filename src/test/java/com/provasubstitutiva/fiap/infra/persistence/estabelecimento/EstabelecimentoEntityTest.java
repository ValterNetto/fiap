package com.provasubstitutiva.fiap.infra.persistence.estabelecimento;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EstabelecimentoEntityTest {

    @Test
    void testAllArgsConstructorAndGetters() {
        EstabelecimentoEntity entity = new EstabelecimentoEntity(
                1L,
                "Studio Hair",
                100L,
                "contato@studiohair.com"
        );

        assertEquals(1L, entity.getId());
        assertEquals("Studio Hair", entity.getNome());
        assertEquals(100L, entity.getIdEndereco());
        assertEquals("contato@studiohair.com", entity.getEmail());
    }

    @Test
    void testSettersAndNoArgsConstructor() {
        EstabelecimentoEntity entity = new EstabelecimentoEntity();

        entity.setId(2L);
        entity.setNome("Barbearia Central");
        entity.setIdEndereco(200L);
        entity.setEmail("contato@barbearia.com");

        assertEquals(2L, entity.getId());
        assertEquals("Barbearia Central", entity.getNome());
        assertEquals(200L, entity.getIdEndereco());
        assertEquals("contato@barbearia.com", entity.getEmail());
    }
}

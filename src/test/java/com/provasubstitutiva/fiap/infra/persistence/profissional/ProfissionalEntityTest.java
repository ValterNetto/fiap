package com.provasubstitutiva.fiap.infra.persistence.profissional;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProfissionalEntityTest {

    @Test
    void testAllArgsConstructorAndGetters() {
        ProfissionalEntity entity = new ProfissionalEntity(
                1L,
                "Ana Souza",
                "ana@email.com",
                "Cabeleireira",
                120,
                10L
        );

        assertEquals(1L, entity.getId());
        assertEquals("Ana Souza", entity.getNome());
        assertEquals("ana@email.com", entity.getEmail());
        assertEquals("Cabeleireira", entity.getEspecialidade());
        assertEquals(120, entity.getTarifaPorHora());
        assertEquals(10L, entity.getIdEstabelecimento());
    }

    @Test
    void testSettersAndNoArgsConstructor() {
        ProfissionalEntity entity = new ProfissionalEntity();

        entity.setId(2L);
        entity.setNome("Carlos Lima");
        entity.setEmail("carlos@email.com");
        entity.setEspecialidade("Massagista");
        entity.setTarifaPorHora(150);
        entity.setIdEstabelecimento(20L);

        assertEquals(2L, entity.getId());
        assertEquals("Carlos Lima", entity.getNome());
        assertEquals("carlos@email.com", entity.getEmail());
        assertEquals("Massagista", entity.getEspecialidade());
        assertEquals(150, entity.getTarifaPorHora());
        assertEquals(20L, entity.getIdEstabelecimento());
    }
}

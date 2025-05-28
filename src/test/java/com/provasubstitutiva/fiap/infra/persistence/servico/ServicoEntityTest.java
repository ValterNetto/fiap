package com.provasubstitutiva.fiap.infra.persistence.servico;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ServicoEntityTest {

    @Test
    void testAllArgsConstructorAndGetters() {
        ServicoEntity entity = new ServicoEntity(
                1L,
                "Manicure",
                80,
                100L
        );

        assertEquals(1L, entity.getId());
        assertEquals("Manicure", entity.getNome());
        assertEquals(80, entity.getValor());
        assertEquals(100L, entity.getIdEstabelecimento());
    }

    @Test
    void testSettersAndNoArgsConstructor() {
        ServicoEntity entity = new ServicoEntity();

        entity.setId(2L);
        entity.setNome("Depilação");
        entity.setValor(120);
        entity.setIdEstabelecimento(200L);

        assertEquals(2L, entity.getId());
        assertEquals("Depilação", entity.getNome());
        assertEquals(120, entity.getValor());
        assertEquals(200L, entity.getIdEstabelecimento());
    }
}

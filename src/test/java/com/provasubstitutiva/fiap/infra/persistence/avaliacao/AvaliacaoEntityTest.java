package com.provasubstitutiva.fiap.infra.persistence.avaliacao;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AvaliacaoEntityTest {

    @Test
    void testAllArgsConstructorAndGetters() {
        AvaliacaoEntity entity = new AvaliacaoEntity(
                1L,
                2L,
                5,
                "Excelente serviço",
                3L,
                4L
        );

        assertEquals(1L, entity.getId());
        assertEquals(2L, entity.getIdCliente());
        assertEquals(5, entity.getEstrelas());
        assertEquals("Excelente serviço", entity.getComentario());
        assertEquals(3L, entity.getIdEstabelecimento());
        assertEquals(4L, entity.getIdProfissional());
    }

    @Test
    void testSettersAndNoArgsConstructor() {
        AvaliacaoEntity entity = new AvaliacaoEntity();

        entity.setId(10L);
        entity.setIdCliente(20L);
        entity.setEstrelas(4);
        entity.setComentario("Bom atendimento");
        entity.setIdEstabelecimento(30L);
        entity.setIdProfissional(40L);

        assertEquals(10L, entity.getId());
        assertEquals(20L, entity.getIdCliente());
        assertEquals(4, entity.getEstrelas());
        assertEquals("Bom atendimento", entity.getComentario());
        assertEquals(30L, entity.getIdEstabelecimento());
        assertEquals(40L, entity.getIdProfissional());
    }
}

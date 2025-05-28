package com.provasubstitutiva.fiap.domain.model.constant;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StatusEnumTest {

    @Test
    void deveConterTodosOsStatusEsperados() {
        assertNotNull(StatusEnum.valueOf("AGENDADO"));
        assertNotNull(StatusEnum.valueOf("CANCELADO"));
        assertNotNull(StatusEnum.valueOf("CONCLUIDO"));
    }

    @Test
    void deveTerTresValores() {
        assertEquals(3, StatusEnum.values().length);
    }

    @Test
    void nomeDosStatusDeveSerCorreto() {
        assertEquals("AGENDADO", StatusEnum.AGENDADO.name());
        assertEquals("CANCELADO", StatusEnum.CANCELADO.name());
        assertEquals("CONCLUIDO", StatusEnum.CONCLUIDO.name());
    }
}

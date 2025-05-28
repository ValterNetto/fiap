package com.provasubstitutiva.fiap.infra.controller.profissional;

import com.provasubstitutiva.fiap.domain.model.Profissional;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProfissionalDTOTest {

    @Test
    void testConstrutorComProfissional() {
        Profissional profissional = new Profissional(
                1L,
                "Ana",
                "ana@email.com",
                "Esteticista",
                200,
                5L
        );

        ProfissionalDTO dto = new ProfissionalDTO(profissional);

        assertEquals(1L, dto.id());
        assertEquals("Ana", dto.nome());
        assertEquals("ana@email.com", dto.email());
        assertEquals("Esteticista", dto.especialidade());
        assertEquals(200, dto.tarifaPorHora());
        assertEquals(5L, dto.idEstabelecimento());
    }

    @Test
    void testConstrutorDireto() {
        ProfissionalDTO dto = new ProfissionalDTO(
                2L,
                "Carlos",
                "carlos@email.com",
                "Massagista",
                180,
                8L
        );

        assertEquals(2L, dto.id());
        assertEquals("Carlos", dto.nome());
        assertEquals("carlos@email.com", dto.email());
        assertEquals("Massagista", dto.especialidade());
        assertEquals(180, dto.tarifaPorHora());
        assertEquals(8L, dto.idEstabelecimento());
    }
}

package com.provasubstitutiva.fiap.domain.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProfissionalTest {

    @Test
    void deveCriarProfissionalComTodosOsCampos() {
        Profissional profissional = new Profissional(
                1L,
                "Carla Souza",
                "carla@fiap.com",
                "Cabelereira",
                150,
                10L
        );

        assertEquals(1L, profissional.getId());
        assertEquals("Carla Souza", profissional.getNome());
        assertEquals("carla@fiap.com", profissional.getEmail());
        assertEquals("Cabelereira", profissional.getEspecialidade());
        assertEquals(150, profissional.getTarifaPorHora());
        assertEquals(10L, profissional.getIdEstabelecimento());
    }

    @Test
    void devePermitirSettersEAcessarComGetters() {
        Profissional p = new Profissional();
        p.setId(2L);
        p.setNome("Lucas");
        p.setEmail("lucas@fiap.com");
        p.setEspecialidade("Barbeiro");
        p.setTarifaPorHora(100);
        p.setIdEstabelecimento(20L);

        assertEquals(2L, p.getId());
        assertEquals("Lucas", p.getNome());
        assertEquals("lucas@fiap.com", p.getEmail());
        assertEquals("Barbeiro", p.getEspecialidade());
        assertEquals(100, p.getTarifaPorHora());
        assertEquals(20L, p.getIdEstabelecimento());
    }
}

package com.provasubstitutiva.fiap.domain.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EstabelecimentoTest {

    @Test
    void deveCriarEstabelecimentoComTodosOsCampos() {
        Estabelecimento e = new Estabelecimento(1L, "Barbearia Fiap", 100L, "contato@fiap.com");

        assertEquals(1L, e.getId());
        assertEquals("Barbearia Fiap", e.getNome());
        assertEquals(100L, e.getIdEndereco());
        assertEquals("contato@fiap.com", e.getEmail());
    }

    @Test
    void devePermitirSettersEAcessarComGetters() {
        Estabelecimento e = new Estabelecimento();
        e.setId(2L);
        e.setNome("Salão Fiap");
        e.setIdEndereco(200L);
        e.setEmail("salao@fiap.com");

        assertEquals(2L, e.getId());
        assertEquals("Salão Fiap", e.getNome());
        assertEquals(200L, e.getIdEndereco());
        assertEquals("salao@fiap.com", e.getEmail());
    }
}

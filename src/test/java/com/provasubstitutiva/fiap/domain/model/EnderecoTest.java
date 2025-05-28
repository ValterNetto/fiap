package com.provasubstitutiva.fiap.domain.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EnderecoTest {

    @Test
    void deveCriarEnderecoComTodosOsCampos() {
        Endereco endereco = new Endereco(
                1L,
                "Rua A",
                "12345-678",
                "100",
                -23.5,
                -46.6,
                10L
        );

        assertEquals(1L, endereco.getId());
        assertEquals("Rua A", endereco.getLogradouro());
        assertEquals("12345-678", endereco.getCep());
        assertEquals("100", endereco.getNumero());
        assertEquals(-23.5, endereco.getLatitude());
        assertEquals(-46.6, endereco.getLongitude());
        assertEquals(10L, endereco.getIdEstabelecimento());
    }

    @Test
    void devePermitirSettersEAcessarComGetters() {
        Endereco endereco = new Endereco();
        endereco.setId(2L);
        endereco.setLogradouro("Rua B");
        endereco.setCep("98765-432");
        endereco.setNumero("200");
        endereco.setLatitude(10.123);
        endereco.setLongitude(20.456);
        endereco.setIdEstabelecimento(99L);

        assertEquals(2L, endereco.getId());
        assertEquals("Rua B", endereco.getLogradouro());
        assertEquals("98765-432", endereco.getCep());
        assertEquals("200", endereco.getNumero());
        assertEquals(10.123, endereco.getLatitude());
        assertEquals(20.456, endereco.getLongitude());
        assertEquals(99L, endereco.getIdEstabelecimento());
    }

    @Test
    void deveRetornarTrueQuandoEnderecoEhValido() {
        Endereco endereco = new Endereco(
                1L,
                "Rua C",
                "11111-111",
                "10A",
                -20.0,
                -40.0,
                5L
        );

        assertTrue(endereco.isValid());
    }

    @Test
    void deveRetornarFalseQuandoEnderecoTemCamposNulosObrigatorios() {
        Endereco endereco = new Endereco();
        endereco.setLogradouro(null);
        endereco.setCep(null);
        endereco.setNumero(null);
        endereco.setIdEstabelecimento(null);

        assertFalse(endereco.isValid());
    }
}

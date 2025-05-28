package com.provasubstitutiva.fiap.domain.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AvaliacaoTest {

    @Test
    void deveCriarAvaliacaoValidaParaEstabelecimento() {
        Avaliacao avaliacao = new Avaliacao(1L, 2L, 5, "Ótimo", 10L, null);

        assertEquals(1L, avaliacao.getId());
        assertEquals(2L, avaliacao.getIdCliente());
        assertEquals(5, avaliacao.getEstrelas());
        assertEquals("Ótimo", avaliacao.getComentario());
        assertEquals(10L, avaliacao.getIdEstabelecimento());
        assertNull(avaliacao.getIdProfissional());
    }

    @Test
    void deveCriarAvaliacaoValidaParaProfissional() {
        Avaliacao avaliacao = new Avaliacao(1L, 2L, 4, "Bom atendimento", null, 99L);

        assertEquals(99L, avaliacao.getIdProfissional());
        assertNull(avaliacao.getIdEstabelecimento());
    }

    @Test
    void deveLancarExcecaoSeEstrelasForemMenorQueZero() {
        assertThrows(IllegalStateException.class, () ->
                new Avaliacao(1L, 2L, -1, "Ruim", 1L, null)
        );
    }

    @Test
    void deveLancarExcecaoSeEstrelasForemMaiorQueCinco() {
        assertThrows(IllegalStateException.class, () ->
                new Avaliacao(1L, 2L, 6, "Excelente demais", null, 3L)
        );
    }

    @Test
    void deveLancarExcecaoSeAvaliarEstabelecimentoEProfissionalSimultaneamente() {
        assertThrows(IllegalStateException.class, () ->
                new Avaliacao(1L, 2L, 4, "Confuso", 10L, 20L)
        );
    }

    @Test
    void devePermitirSettersEGetters() {
        Avaliacao avaliacao = new Avaliacao();
        avaliacao.setId(1L);
        avaliacao.setIdCliente(2L);
        avaliacao.setEstrelas(3);
        avaliacao.setComentario("Teste");
        avaliacao.setIdEstabelecimento(5L);
        avaliacao.setIdProfissional(null);

        assertEquals(1L, avaliacao.getId());
        assertEquals(2L, avaliacao.getIdCliente());
        assertEquals(3, avaliacao.getEstrelas());
        assertEquals("Teste", avaliacao.getComentario());
        assertEquals(5L, avaliacao.getIdEstabelecimento());
        assertNull(avaliacao.getIdProfissional());
    }
}

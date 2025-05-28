package com.provasubstitutiva.fiap.application.usecase.avaliacao.impl;

import com.provasubstitutiva.fiap.application.usecase.avaliacao.BuscarAvaliacoesPorIdEstabelecimento;
import com.provasubstitutiva.fiap.domain.model.Avaliacao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class BuscarAvaliacoesPorIdEstabalecimentoImplTest {

    private BuscarAvaliacoesPorIdEstabelecimento buscarGateway;
    private BuscarAvaliacoesPorIdEstabalecimentoImpl useCase;

    @BeforeEach
    void setUp() {
        buscarGateway = mock(BuscarAvaliacoesPorIdEstabelecimento.class);
        useCase = new BuscarAvaliacoesPorIdEstabalecimentoImpl(buscarGateway);
    }

    @Test
    void deveRetornarListaDeAvaliacoes() {
        Long id = 10L;
        List<Avaliacao> avaliacoes = List.of(new Avaliacao(), new Avaliacao());

        when(buscarGateway.buscarPorIdEstabelecimento(id)).thenReturn(avaliacoes);

        List<Avaliacao> resultado = useCase.buscarporIdEstabelecimento(id);

        assertEquals(2, resultado.size());
        verify(buscarGateway, times(1)).buscarPorIdEstabelecimento(id);
    }

    @Test
    void deveRetornarListaVaziaQuandoNaoHaAvaliacoes() {
        Long id = 10L;

        when(buscarGateway.buscarPorIdEstabelecimento(id)).thenReturn(List.of());

        List<Avaliacao> resultado = useCase.buscarporIdEstabelecimento(id);

        assertNotNull(resultado);
        assertTrue(resultado.isEmpty());
    }
}

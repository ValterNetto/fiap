package com.provasubstitutiva.fiap.application.usecase.avaliacao.impl;

import com.provasubstitutiva.fiap.application.usecase.avaliacao.BuscarAvaliacoesPorIdCliente;
import com.provasubstitutiva.fiap.domain.model.Avaliacao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class BuscarAvaliacoesPorIdClienteImplTest {

    private BuscarAvaliacoesPorIdCliente buscarAvaliacoesGateway;
    private BuscarAvaliacoesPorIdClienteImpl useCase;

    @BeforeEach
    void setUp() {
        buscarAvaliacoesGateway = mock(BuscarAvaliacoesPorIdCliente.class);
        useCase = new BuscarAvaliacoesPorIdClienteImpl(buscarAvaliacoesGateway);
    }

    @Test
    void deveRetornarListaDeAvaliacoes() {
        Long idCliente = 1L;
        List<Avaliacao> mockAvaliacoes = List.of(new Avaliacao(), new Avaliacao());

        when(buscarAvaliacoesGateway.buscarAvaliacoesPorIdCliente(idCliente)).thenReturn(mockAvaliacoes);

        List<Avaliacao> resultado = useCase.buscarAvaliacaoPorIdCliente(idCliente);

        assertEquals(2, resultado.size());
        verify(buscarAvaliacoesGateway, times(1)).buscarAvaliacoesPorIdCliente(idCliente);
    }

    @Test
    void deveRetornarListaVaziaQuandoNaoHaAvaliacoes() {
        Long idCliente = 1L;

        when(buscarAvaliacoesGateway.buscarAvaliacoesPorIdCliente(idCliente)).thenReturn(List.of());

        List<Avaliacao> resultado = useCase.buscarAvaliacaoPorIdCliente(idCliente);

        assertNotNull(resultado);
        assertTrue(resultado.isEmpty());
    }
}

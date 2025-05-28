package com.provasubstitutiva.fiap.application.usecase.servico.impl;

import com.provasubstitutiva.fiap.application.usecase.servico.BuscarPorIdEstabelecimento;
import com.provasubstitutiva.fiap.domain.model.Servico;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class BuscarPorIdEstabelecimentoImplTest {

    private BuscarPorIdEstabelecimento buscarGateway;
    private BuscarPorIdEstabelecimentoImpl useCase;

    @BeforeEach
    void setUp() {
        buscarGateway = mock(BuscarPorIdEstabelecimento.class);
        useCase = new BuscarPorIdEstabelecimentoImpl(buscarGateway);
    }

    @Test
    void deveRetornarServicosDoEstabelecimento() {
        Long id = 1L;
        Servico s1 = new Servico();
        Servico s2 = new Servico();

        when(buscarGateway.buscarPorIdEstabelecimento(id)).thenReturn(List.of(s1, s2));

        List<Servico> resultado = useCase.buscarPorIdEstabelecimento(id);

        assertEquals(2, resultado.size());
        verify(buscarGateway, times(1)).buscarPorIdEstabelecimento(id);
    }

    @Test
    void deveRetornarListaVaziaSeNaoHouverServicos() {
        Long id = 2L;

        when(buscarGateway.buscarPorIdEstabelecimento(id)).thenReturn(List.of());

        List<Servico> resultado = useCase.buscarPorIdEstabelecimento(id);

        assertNotNull(resultado);
        assertTrue(resultado.isEmpty());
        verify(buscarGateway, times(1)).buscarPorIdEstabelecimento(id);
    }
}

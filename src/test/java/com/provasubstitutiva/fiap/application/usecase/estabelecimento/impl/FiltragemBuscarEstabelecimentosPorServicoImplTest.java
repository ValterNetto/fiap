package com.provasubstitutiva.fiap.application.usecase.estabelecimento.impl;

import com.provasubstitutiva.fiap.application.usecase.estabelecimento.BuscarEstabelecimentoPorId;
import com.provasubstitutiva.fiap.application.usecase.servico.BuscarServicoPorNome;
import com.provasubstitutiva.fiap.domain.model.Estabelecimento;
import com.provasubstitutiva.fiap.domain.model.Servico;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class FiltragemBuscarEstabelecimentosPorServicoImplTest {

    private BuscarServicoPorNome buscarServicoPorNome;
    private BuscarEstabelecimentoPorId buscarEstabelecimentoPorId;
    private FiltragemBuscarEstabelecimentosPorServicoImpl useCase;

    @BeforeEach
    void setUp() {
        buscarServicoPorNome = mock(BuscarServicoPorNome.class);
        buscarEstabelecimentoPorId = mock(BuscarEstabelecimentoPorId.class);
        useCase = new FiltragemBuscarEstabelecimentosPorServicoImpl(buscarServicoPorNome, buscarEstabelecimentoPorId);
    }

    @Test
    void deveRetornarEstabelecimentosComBaseNoServico() {
        Servico servico = new Servico();
        servico.setIdEstabelecimento(10L);

        Estabelecimento estabelecimento = new Estabelecimento();
        estabelecimento.setId(10L);

        when(buscarServicoPorNome.buscarServicoPorNome("Corte")).thenReturn(List.of(servico));
        when(buscarEstabelecimentoPorId.buscarEstabelecimentoPorId(10L)).thenReturn(estabelecimento);

        List<Estabelecimento> resultado = useCase.buscarEstabelecimentosPorServico("Corte");

        assertEquals(1, resultado.size());
        assertEquals(10L, resultado.get(0).getId());
        verify(buscarServicoPorNome, times(1)).buscarServicoPorNome("Corte");
        verify(buscarEstabelecimentoPorId, times(1)).buscarEstabelecimentoPorId(10L);
    }

    @Test
    void deveRetornarListaVaziaSeNenhumServicoEncontrado() {
        when(buscarServicoPorNome.buscarServicoPorNome("Massagem")).thenReturn(List.of());

        List<Estabelecimento> resultado = useCase.buscarEstabelecimentosPorServico("Massagem");

        assertNotNull(resultado);
        assertTrue(resultado.isEmpty());
        verify(buscarServicoPorNome, times(1)).buscarServicoPorNome("Massagem");
        verifyNoInteractions(buscarEstabelecimentoPorId);
    }
}

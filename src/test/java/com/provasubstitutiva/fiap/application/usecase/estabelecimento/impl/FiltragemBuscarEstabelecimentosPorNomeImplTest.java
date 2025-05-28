package com.provasubstitutiva.fiap.application.usecase.estabelecimento.impl;

import com.provasubstitutiva.fiap.application.usecase.estabelecimento.FiltragemBuscarEstabelecimentosPorNome;
import com.provasubstitutiva.fiap.domain.model.Estabelecimento;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class FiltragemBuscarEstabelecimentosPorNomeImplTest {

    private FiltragemBuscarEstabelecimentosPorNome filtroGateway;
    private FiltragemBuscarEstabelecimentosPorNomeImpl useCase;

    @BeforeEach
    void setUp() {
        filtroGateway = mock(FiltragemBuscarEstabelecimentosPorNome.class);
        useCase = new FiltragemBuscarEstabelecimentosPorNomeImpl(filtroGateway);
    }

    @Test
    void deveRetornarListaDeEstabelecimentosPorNome() {
        String nome = "Spa";
        Estabelecimento e1 = new Estabelecimento();
        e1.setNome("Spa Zen");

        when(filtroGateway.buscarPorNome(nome)).thenReturn(List.of(e1));

        List<Estabelecimento> resultado = useCase.buscarPorNome(nome);

        assertEquals(1, resultado.size());
        assertEquals("Spa Zen", resultado.get(0).getNome());
        verify(filtroGateway, times(1)).buscarPorNome(nome);
    }

    @Test
    void deveRetornarListaVaziaQuandoNenhumNomeEncontrado() {
        String nome = "Inexistente";

        when(filtroGateway.buscarPorNome(nome)).thenReturn(List.of());

        List<Estabelecimento> resultado = useCase.buscarPorNome(nome);

        assertNotNull(resultado);
        assertTrue(resultado.isEmpty());
        verify(filtroGateway, times(1)).buscarPorNome(nome);
    }
}

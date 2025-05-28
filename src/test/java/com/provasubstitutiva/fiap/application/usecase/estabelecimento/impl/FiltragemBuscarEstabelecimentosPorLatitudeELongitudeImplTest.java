package com.provasubstitutiva.fiap.application.usecase.estabelecimento.impl;

import com.provasubstitutiva.fiap.application.usecase.endereco.FiltragemBuscarEstabelecimentosPorLatitudeELongitude;
import com.provasubstitutiva.fiap.application.usecase.estabelecimento.BuscarEstabelecimentoPorId;
import com.provasubstitutiva.fiap.domain.model.Estabelecimento;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class FiltragemBuscarEstabelecimentosPorLatitudeELongitudeImplTest {

    private FiltragemBuscarEstabelecimentosPorLatitudeELongitude filtroGateway;
    private BuscarEstabelecimentoPorId buscarGateway;
    private FiltragemBuscarEstabelecimentosPorLatitudeELongitudeImpl useCase;

    @BeforeEach
    void setUp() {
        filtroGateway = mock(FiltragemBuscarEstabelecimentosPorLatitudeELongitude.class);
        buscarGateway = mock(BuscarEstabelecimentoPorId.class);
        useCase = new FiltragemBuscarEstabelecimentosPorLatitudeELongitudeImpl(filtroGateway, buscarGateway);
    }

    @Test
    void deveBuscarEstabelecimentosDentroDoRaio() {
        double latitude = -23.55;
        double longitude = -46.63;
        int metros = 1000;

        Long id1 = 1L;
        Long id2 = 2L;

        Estabelecimento e1 = new Estabelecimento();
        e1.setId(id1);
        Estabelecimento e2 = new Estabelecimento();
        e2.setId(id2);

        when(filtroGateway.buscarPorLatitudeELongitude(anyDouble(), anyDouble(), anyDouble(), anyDouble()))
                .thenReturn(List.of(id1, id2));

        when(buscarGateway.buscarEstabelecimentoPorId(id1)).thenReturn(e1);
        when(buscarGateway.buscarEstabelecimentoPorId(id2)).thenReturn(e2);

        List<Estabelecimento> resultado = useCase.buscarEstabelecimentoPorLatitudeELongitude(latitude, longitude, metros);

        assertEquals(2, resultado.size());
        assertTrue(resultado.contains(e1));
        assertTrue(resultado.contains(e2));

        verify(filtroGateway, times(1)).buscarPorLatitudeELongitude(anyDouble(), anyDouble(), anyDouble(), anyDouble());
        verify(buscarGateway, times(1)).buscarEstabelecimentoPorId(id1);
        verify(buscarGateway, times(1)).buscarEstabelecimentoPorId(id2);
    }

    @Test
    void deveRetornarListaVaziaSeNenhumIdForEncontrado() {
        when(filtroGateway.buscarPorLatitudeELongitude(anyDouble(), anyDouble(), anyDouble(), anyDouble()))
                .thenReturn(List.of());

        List<Estabelecimento> resultado = useCase.buscarEstabelecimentoPorLatitudeELongitude(0, 0, 1000);

        assertNotNull(resultado);
        assertTrue(resultado.isEmpty());
        verifyNoInteractions(buscarGateway);
    }
}

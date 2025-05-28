package com.provasubstitutiva.fiap.application.usecase.foto.impl;

import com.provasubstitutiva.fiap.application.usecase.foto.BuscarFotosPorIdEstabelecimento;
import com.provasubstitutiva.fiap.domain.model.Foto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class BuscarFotosPorIdEstabelecimentoImplTest {

    private BuscarFotosPorIdEstabelecimento buscarGateway;
    private BuscarFotosPorIdEstabelecimentoImpl useCase;

    @BeforeEach
    void setUp() {
        buscarGateway = mock(BuscarFotosPorIdEstabelecimento.class);
        useCase = new BuscarFotosPorIdEstabelecimentoImpl(buscarGateway);
    }

    @Test
    void deveRetornarListaDeFotosDoEstabelecimento() {
        Long idEstabelecimento = 1L;
        Foto foto1 = new Foto();
        Foto foto2 = new Foto();

        when(buscarGateway.buscarFotoPorIdEstabelecimento(idEstabelecimento))
                .thenReturn(List.of(foto1, foto2));

        List<Foto> resultado = useCase.buscarFotoPorIdEstabelecimento(idEstabelecimento);

        assertEquals(2, resultado.size());
        verify(buscarGateway, times(1)).buscarFotoPorIdEstabelecimento(idEstabelecimento);
    }

    @Test
    void deveRetornarListaVaziaSeNaoHouverFotos() {
        Long idEstabelecimento = 1L;

        when(buscarGateway.buscarFotoPorIdEstabelecimento(idEstabelecimento)).thenReturn(List.of());

        List<Foto> resultado = useCase.buscarFotoPorIdEstabelecimento(idEstabelecimento);

        assertNotNull(resultado);
        assertTrue(resultado.isEmpty());
        verify(buscarGateway, times(1)).buscarFotoPorIdEstabelecimento(idEstabelecimento);
    }
}

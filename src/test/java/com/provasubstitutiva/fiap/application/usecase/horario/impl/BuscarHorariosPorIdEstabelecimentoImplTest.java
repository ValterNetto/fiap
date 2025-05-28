package com.provasubstitutiva.fiap.application.usecase.horario.impl;

import com.provasubstitutiva.fiap.application.usecase.horario.BuscarHorariosPorIdEstabelecimento;
import com.provasubstitutiva.fiap.domain.model.Horario;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class BuscarHorariosPorIdEstabelecimentoImplTest {

    private BuscarHorariosPorIdEstabelecimento buscarGateway;
    private BuscarHorariosPorIdEstabelecimentoImpl useCase;

    @BeforeEach
    void setUp() {
        buscarGateway = mock(BuscarHorariosPorIdEstabelecimento.class);
        useCase = new BuscarHorariosPorIdEstabelecimentoImpl(buscarGateway);
    }

    @Test
    void deveRetornarListaDeHorarios() {
        Long idEstabelecimento = 1L;
        Horario h1 = new Horario();
        Horario h2 = new Horario();

        when(buscarGateway.buscarPorIdEstabelecimento(idEstabelecimento))
                .thenReturn(List.of(h1, h2));

        List<Horario> resultado = useCase.buscarHorariosPorIdEstabelecimento(idEstabelecimento);

        assertEquals(2, resultado.size());
        verify(buscarGateway, times(1)).buscarPorIdEstabelecimento(idEstabelecimento);
    }

    @Test
    void deveRetornarListaVaziaSeNaoExistiremHorarios() {
        Long idEstabelecimento = 2L;

        when(buscarGateway.buscarPorIdEstabelecimento(idEstabelecimento))
                .thenReturn(List.of());

        List<Horario> resultado = useCase.buscarHorariosPorIdEstabelecimento(idEstabelecimento);

        assertNotNull(resultado);
        assertTrue(resultado.isEmpty());
        verify(buscarGateway, times(1)).buscarPorIdEstabelecimento(idEstabelecimento);
    }
}

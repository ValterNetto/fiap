package com.provasubstitutiva.fiap.application.usecase.agendamento.impl;

import com.provasubstitutiva.fiap.application.usecase.agendamento.BuscarAgendamentosPorProfissionalEDia;
import com.provasubstitutiva.fiap.domain.model.Agendamento;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class BuscarAgendamentosPorProfissionalEDiaImplTest {

    private BuscarAgendamentosPorProfissionalEDia buscarAgendamentosGateway;
    private BuscarAgendamentosPorProfissionalEDiaImpl buscarAgendamentosUseCase;

    @BeforeEach
    void setup() {
        buscarAgendamentosGateway = mock(BuscarAgendamentosPorProfissionalEDia.class);
        buscarAgendamentosUseCase = new BuscarAgendamentosPorProfissionalEDiaImpl(buscarAgendamentosGateway);
    }

    @Test
    void deveRetornarListaDeAgendamentosQuandoEncontrados() {
        Long idProfissional = 1L;
        LocalDate data = LocalDate.now();
        List<Agendamento> mockAgendamentos = List.of(new Agendamento());

        when(buscarAgendamentosGateway.buscarAgendamentos(idProfissional, data))
                .thenReturn(mockAgendamentos);

        List<Agendamento> resultado = buscarAgendamentosUseCase.buscarAgendamentos(idProfissional, data);

        assertEquals(mockAgendamentos, resultado);
        verify(buscarAgendamentosGateway, times(1)).buscarAgendamentos(idProfissional, data);
    }

    @Test
    void deveLancarExcecaoQuandoListaForNula() {
        Long idProfissional = 1L;
        LocalDate data = LocalDate.now();

        when(buscarAgendamentosGateway.buscarAgendamentos(idProfissional, data)).thenReturn(null);

        assertThrows(NoSuchElementException.class, () ->
                buscarAgendamentosUseCase.buscarAgendamentos(idProfissional, data));
    }

    @Test
    void deveRetornarListaVaziaQuandoNaoHaAgendamentos() {
        Long idProfissional = 1L;
        LocalDate data = LocalDate.now();

        when(buscarAgendamentosGateway.buscarAgendamentos(idProfissional, data)).thenReturn(Collections.emptyList());

        List<Agendamento> resultado = buscarAgendamentosUseCase.buscarAgendamentos(idProfissional, data);

        assertNotNull(resultado);
        assertTrue(resultado.isEmpty());
    }
}

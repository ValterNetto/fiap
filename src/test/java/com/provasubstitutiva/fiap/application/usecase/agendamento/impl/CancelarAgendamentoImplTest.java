package com.provasubstitutiva.fiap.application.usecase.agendamento.impl;

import com.provasubstitutiva.fiap.application.usecase.agendamento.BuscarAgendamentoPorId;
import com.provasubstitutiva.fiap.application.usecase.agendamento.CancelarAgendamento;
import com.provasubstitutiva.fiap.domain.model.Agendamento;
import com.provasubstitutiva.fiap.domain.model.constant.StatusEnum;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CancelarAgendamentoImplTest {

    private CancelarAgendamento cancelarAgendamento;
    private BuscarAgendamentoPorId buscarAgendamentoPorId;
    private CancelarAgendamentoImpl cancelarAgendamentoImpl;

    @BeforeEach
    void setUp() {
        cancelarAgendamento = mock(CancelarAgendamento.class);
        buscarAgendamentoPorId = mock(BuscarAgendamentoPorId.class);
        cancelarAgendamentoImpl = new CancelarAgendamentoImpl(cancelarAgendamento, buscarAgendamentoPorId);
    }

    @Test
    void deveCancelarAgendamentoValido() {
        Agendamento agendamento = new Agendamento();
        agendamento.setStatus(StatusEnum.AGENDADO);

        when(buscarAgendamentoPorId.buscarAgendamentoPorId(1L)).thenReturn(agendamento);
        when(cancelarAgendamento.cancelar(any())).thenReturn(agendamento);

        Agendamento resultado = cancelarAgendamentoImpl.cancelar(1L);

        assertEquals(StatusEnum.CANCELADO, resultado.getStatus());
        verify(buscarAgendamentoPorId, times(1)).buscarAgendamentoPorId(1L);
        verify(cancelarAgendamento, times(1)).cancelar(agendamento);
    }

    @Test
    void deveLancarExcecaoQuandoAgendamentoNaoForEncontrado() {
        when(buscarAgendamentoPorId.buscarAgendamentoPorId(1L)).thenReturn(null);

        assertThrows(NoSuchElementException.class, () -> cancelarAgendamentoImpl.cancelar(1L));
        verify(cancelarAgendamento, never()).cancelar(any());
    }

    @Test
    void deveLancarExcecaoSeAgendamentoJaEstiverCancelado() {
        Agendamento agendamento = new Agendamento();
        agendamento.setStatus(StatusEnum.CANCELADO);

        when(buscarAgendamentoPorId.buscarAgendamentoPorId(1L)).thenReturn(agendamento);

        assertThrows(IllegalStateException.class, () -> cancelarAgendamentoImpl.cancelar(1L));
        verify(cancelarAgendamento, never()).cancelar(any());
    }

    @Test
    void deveLancarExcecaoSeAgendamentoJaEstiverConcluido() {
        Agendamento agendamento = new Agendamento();
        agendamento.setStatus(StatusEnum.CONCLUIDO);

        when(buscarAgendamentoPorId.buscarAgendamentoPorId(1L)).thenReturn(agendamento);

        assertThrows(IllegalStateException.class, () -> cancelarAgendamentoImpl.cancelar(1L));
        verify(cancelarAgendamento, never()).cancelar(any());
    }
}

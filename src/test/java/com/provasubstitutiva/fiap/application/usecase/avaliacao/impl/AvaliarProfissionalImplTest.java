package com.provasubstitutiva.fiap.application.usecase.avaliacao.impl;

import com.provasubstitutiva.fiap.application.usecase.agendamento.BuscarAgendamentosPorCliente;
import com.provasubstitutiva.fiap.application.usecase.avaliacao.AvaliarProfissional;
import com.provasubstitutiva.fiap.application.usecase.cliente.BuscarClientePorId;
import com.provasubstitutiva.fiap.application.usecase.profissional.BuscarProfissionalPorId;
import com.provasubstitutiva.fiap.domain.model.Agendamento;
import com.provasubstitutiva.fiap.domain.model.Avaliacao;
import com.provasubstitutiva.fiap.domain.model.Cliente;
import com.provasubstitutiva.fiap.domain.model.Profissional;
import com.provasubstitutiva.fiap.domain.model.constant.StatusEnum;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class AvaliarProfissionalImplTest {

    private AvaliarProfissional avaliarProfissional;
    private BuscarClientePorId buscarClientePorId;
    private BuscarProfissionalPorId buscarProfissionalPorId;
    private BuscarAgendamentosPorCliente buscarAgendamentosPorCliente;

    private AvaliarProfissionalImpl useCase;

    @BeforeEach
    void setUp() {
        avaliarProfissional = mock(AvaliarProfissional.class);
        buscarClientePorId = mock(BuscarClientePorId.class);
        buscarProfissionalPorId = mock(BuscarProfissionalPorId.class);
        buscarAgendamentosPorCliente = mock(BuscarAgendamentosPorCliente.class);

        useCase = new AvaliarProfissionalImpl(
                avaliarProfissional,
                buscarClientePorId,
                buscarProfissionalPorId,
                buscarAgendamentosPorCliente
        );
    }

    @Test
    void deveAvaliarProfissionalComSucesso() {
        Avaliacao avaliacao = new Avaliacao();
        avaliacao.setIdCliente(1L);
        avaliacao.setIdProfissional(2L);
        avaliacao.setEstrelas(5);

        when(buscarClientePorId.buscarClientePorId(1L)).thenReturn(new Cliente());
        when(buscarProfissionalPorId.buscarPorId(2L)).thenReturn(new Profissional());

        Agendamento agendamento = new Agendamento();
        agendamento.setIdProfissional(2L);
        agendamento.setStatus(StatusEnum.CONCLUIDO);

        when(buscarAgendamentosPorCliente.buscarAgendamentos(1L)).thenReturn(List.of(agendamento));
        when(avaliarProfissional.avaliarProfissional(any())).thenAnswer(invocation -> invocation.getArgument(0));

        Avaliacao resultado = useCase.avaliarProfissional(avaliacao);

        assertEquals(5, resultado.getEstrelas());
        assertNull(resultado.getIdEstabelecimento());
    }

    @Test
    void deveLancarExcecaoSeClienteNaoExiste() {
        Avaliacao avaliacao = new Avaliacao();
        avaliacao.setIdCliente(1L);
        avaliacao.setIdProfissional(2L);

        when(buscarClientePorId.buscarClientePorId(1L)).thenReturn(null);

        assertThrows(NoSuchElementException.class, () -> useCase.avaliarProfissional(avaliacao));
    }

    @Test
    void deveLancarExcecaoSeProfissionalNaoExiste() {
        Avaliacao avaliacao = new Avaliacao();
        avaliacao.setIdCliente(1L);
        avaliacao.setIdProfissional(2L);

        when(buscarClientePorId.buscarClientePorId(1L)).thenReturn(new Cliente());
        when(buscarProfissionalPorId.buscarPorId(2L)).thenReturn(null);

        assertThrows(NoSuchElementException.class, () -> useCase.avaliarProfissional(avaliacao));
    }

    @Test
    void deveLancarExcecaoSeClienteNuncaConcluiuAgendamentoComProfissional() {
        Avaliacao avaliacao = new Avaliacao();
        avaliacao.setIdCliente(1L);
        avaliacao.setIdProfissional(2L);

        Agendamento agendamento = new Agendamento();
        agendamento.setIdProfissional(2L);
        agendamento.setStatus(StatusEnum.AGENDADO);

        when(buscarClientePorId.buscarClientePorId(1L)).thenReturn(new Cliente());
        when(buscarProfissionalPorId.buscarPorId(2L)).thenReturn(new Profissional());
        when(buscarAgendamentosPorCliente.buscarAgendamentos(1L)).thenReturn(List.of(agendamento));

        assertThrows(IllegalStateException.class, () -> useCase.avaliarProfissional(avaliacao));
    }
}

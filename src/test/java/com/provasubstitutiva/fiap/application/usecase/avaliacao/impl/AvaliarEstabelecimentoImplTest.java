package com.provasubstitutiva.fiap.application.usecase.avaliacao.impl;

import com.provasubstitutiva.fiap.application.usecase.agendamento.BuscarAgendamentosPorCliente;
import com.provasubstitutiva.fiap.application.usecase.avaliacao.AvaliarEstabelecimento;
import com.provasubstitutiva.fiap.application.usecase.cliente.BuscarClientePorId;
import com.provasubstitutiva.fiap.application.usecase.estabelecimento.BuscarEstabelecimentoPorId;
import com.provasubstitutiva.fiap.domain.model.Agendamento;
import com.provasubstitutiva.fiap.domain.model.Avaliacao;
import com.provasubstitutiva.fiap.domain.model.Cliente;
import com.provasubstitutiva.fiap.domain.model.Estabelecimento;
import com.provasubstitutiva.fiap.domain.model.constant.StatusEnum;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class AvaliarEstabelecimentoImplTest {

    private AvaliarEstabelecimento avaliarEstabelecimento;
    private BuscarClientePorId buscarClientePorId;
    private BuscarEstabelecimentoPorId buscarEstabelecimentoPorId;
    private BuscarAgendamentosPorCliente buscarAgendamentosPorCliente;

    private AvaliarEstabelecimentoImpl useCase;

    @BeforeEach
    void setUp() {
        avaliarEstabelecimento = mock(AvaliarEstabelecimento.class);
        buscarClientePorId = mock(BuscarClientePorId.class);
        buscarEstabelecimentoPorId = mock(BuscarEstabelecimentoPorId.class);
        buscarAgendamentosPorCliente = mock(BuscarAgendamentosPorCliente.class);

        useCase = new AvaliarEstabelecimentoImpl(
                avaliarEstabelecimento,
                buscarClientePorId,
                buscarEstabelecimentoPorId,
                buscarAgendamentosPorCliente
        );
    }

    @Test
    void deveRealizarAvaliacaoComSucesso() {
        Avaliacao avaliacao = new Avaliacao();
        avaliacao.setIdCliente(1L);
        avaliacao.setIdEstabelecimento(2L);
        avaliacao.setEstrelas(5);

        when(buscarClientePorId.buscarClientePorId(1L)).thenReturn(new Cliente());
        when(buscarEstabelecimentoPorId.buscarEstabelecimentoPorId(2L)).thenReturn(new Estabelecimento());

        Agendamento agendamento = new Agendamento();
        agendamento.setIdEstabelecimento(2L);
        agendamento.setStatus(StatusEnum.CONCLUIDO);

        when(buscarAgendamentosPorCliente.buscarAgendamentos(1L)).thenReturn(List.of(agendamento));
        when(avaliarEstabelecimento.fazerAvaliacao(any())).thenAnswer(invocation -> invocation.getArgument(0));

        Avaliacao resultado = useCase.fazerAvaliacao(avaliacao);

        assertEquals(5, resultado.getEstrelas());
        assertNull(resultado.getIdProfissional());
    }

    @Test
    void deveLancarExcecaoSeClienteNaoExiste() {
        Avaliacao avaliacao = new Avaliacao();
        avaliacao.setIdCliente(1L);
        avaliacao.setIdEstabelecimento(2L);

        when(buscarClientePorId.buscarClientePorId(1L)).thenReturn(null);

        assertThrows(NoSuchElementException.class, () -> useCase.fazerAvaliacao(avaliacao));
    }

    @Test
    void deveLancarExcecaoSeEstabelecimentoNaoExiste() {
        Avaliacao avaliacao = new Avaliacao();
        avaliacao.setIdCliente(1L);
        avaliacao.setIdEstabelecimento(2L);

        when(buscarClientePorId.buscarClientePorId(1L)).thenReturn(new Cliente());
        when(buscarEstabelecimentoPorId.buscarEstabelecimentoPorId(2L)).thenReturn(null);

        assertThrows(NoSuchElementException.class, () -> useCase.fazerAvaliacao(avaliacao));
    }

    @Test
    void deveLancarExcecaoSeClienteNuncaConcluiuAgendamentoNoEstabelecimento() {
        Avaliacao avaliacao = new Avaliacao();
        avaliacao.setIdCliente(1L);
        avaliacao.setIdEstabelecimento(2L);

        Agendamento agendamentoNaoConcluido = new Agendamento();
        agendamentoNaoConcluido.setIdEstabelecimento(2L);
        agendamentoNaoConcluido.setStatus(StatusEnum.AGENDADO);

        when(buscarClientePorId.buscarClientePorId(1L)).thenReturn(new Cliente());
        when(buscarEstabelecimentoPorId.buscarEstabelecimentoPorId(2L)).thenReturn(new Estabelecimento());
        when(buscarAgendamentosPorCliente.buscarAgendamentos(1L)).thenReturn(List.of(agendamentoNaoConcluido));

        assertThrows(IllegalStateException.class, () -> useCase.fazerAvaliacao(avaliacao));
    }
}

package com.provasubstitutiva.fiap.application.usecase.agendamento.impl;

import com.provasubstitutiva.fiap.application.usecase.agendamento.BuscarAgendamentosPorProfissionalEDia;
import com.provasubstitutiva.fiap.application.usecase.agendamento.RealizarAgendamento;
import com.provasubstitutiva.fiap.application.usecase.cliente.BuscarClientePorId;
import com.provasubstitutiva.fiap.application.usecase.estabelecimento.BuscarEstabelecimentoPorId;
import com.provasubstitutiva.fiap.application.usecase.horario.BuscarHorarioPorDia;
import com.provasubstitutiva.fiap.application.usecase.profissional.BuscarProfissionalPorId;
import com.provasubstitutiva.fiap.application.usecase.servico.BuscarServicoPorId;
import com.provasubstitutiva.fiap.domain.model.*;
import com.provasubstitutiva.fiap.domain.model.constant.DiasDaSemanaEnum;
import com.provasubstitutiva.fiap.domain.model.constant.StatusEnum;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class RealizarAgendamentoImplTest {

    private RealizarAgendamento realizarAgendamento;
    private BuscarClientePorId buscarClientePorId;
    private BuscarProfissionalPorId buscarProfissionalPorId;
    private BuscarEstabelecimentoPorId buscarEstabelecimentoPorId;
    private BuscarServicoPorId buscarServicoPorId;
    private BuscarHorarioPorDia buscarHorarioPorDia;
    private BuscarAgendamentosPorProfissionalEDia buscarAgendamentos;

    private RealizarAgendamentoImpl useCase;

    @BeforeEach
    void setup() {
        realizarAgendamento = mock(RealizarAgendamento.class);
        buscarClientePorId = mock(BuscarClientePorId.class);
        buscarProfissionalPorId = mock(BuscarProfissionalPorId.class);
        buscarEstabelecimentoPorId = mock(BuscarEstabelecimentoPorId.class);
        buscarServicoPorId = mock(BuscarServicoPorId.class);
        buscarHorarioPorDia = mock(BuscarHorarioPorDia.class);
        buscarAgendamentos = mock(BuscarAgendamentosPorProfissionalEDia.class);

        useCase = new RealizarAgendamentoImpl(
                realizarAgendamento,
                buscarClientePorId,
                buscarProfissionalPorId,
                buscarEstabelecimentoPorId,
                buscarServicoPorId,
                buscarHorarioPorDia,
                buscarAgendamentos
        );
    }

    @Test
    void deveRealizarAgendamentoComSucesso() {
        Agendamento agendamento = new Agendamento();
        agendamento.setIdCliente(1L);
        agendamento.setIdProfissional(2L);
        agendamento.setIdEstabelecimento(3L);
        agendamento.setIdServico(4L);
        agendamento.setData(LocalDate.of(2025, 5, 17));
        agendamento.setHoraInicio(LocalTime.of(10, 0));
        agendamento.setHoraTermino(LocalTime.of(11, 0));

        Cliente cliente = new Cliente();
        Profissional profissional = new Profissional();
        profissional.setIdEstabelecimento(3L);

        Estabelecimento estabelecimento = new Estabelecimento();
        estabelecimento.setId(3L);

        Servico servico = new Servico();
        servico.setIdEstabelecimento(3L);

        Horario horario = new Horario();
        horario.setInicio(LocalTime.of(8, 0));
        horario.setFim(LocalTime.of(18, 0));

        when(buscarClientePorId.buscarClientePorId(1L)).thenReturn(cliente);
        when(buscarProfissionalPorId.buscarPorId(2L)).thenReturn(profissional);
        when(buscarEstabelecimentoPorId.buscarEstabelecimentoPorId(3L)).thenReturn(estabelecimento);
        when(buscarServicoPorId.buscarServicoPorId(4L)).thenReturn(servico);
        when(buscarHorarioPorDia.buscarHorarioPorDia(3L, DiasDaSemanaEnum.SATURDAY)).thenReturn(horario);
        when(buscarAgendamentos.buscarAgendamentos(2L, agendamento.getData())).thenReturn(List.of());
        when(realizarAgendamento.agendar(any())).thenAnswer(invocation -> invocation.getArgument(0));

        Agendamento resultado = useCase.realizarAgendamento(agendamento);

        assertEquals(StatusEnum.AGENDADO, resultado.getStatus());
    }

    @Test
    void deveLancarExcecaoSeClienteNaoExiste() {
        Agendamento agendamento = new Agendamento();
        agendamento.setIdCliente(1L);

        when(buscarClientePorId.buscarClientePorId(1L)).thenReturn(null);

        assertThrows(NoSuchElementException.class, () -> useCase.realizarAgendamento(agendamento));
    }

    @Test
    void deveLancarExcecaoSeProfissionalNaoExiste() {
        Agendamento agendamento = new Agendamento();
        agendamento.setIdCliente(1L);
        agendamento.setIdProfissional(2L);

        when(buscarClientePorId.buscarClientePorId(1L)).thenReturn(new Cliente());
        when(buscarProfissionalPorId.buscarPorId(2L)).thenReturn(null);

        assertThrows(NoSuchElementException.class, () -> useCase.realizarAgendamento(agendamento));
    }

    @Test
    void deveLancarExcecaoSeEstabelecimentoNaoExiste() {
        Agendamento agendamento = new Agendamento();
        agendamento.setIdCliente(1L);
        agendamento.setIdProfissional(2L);
        agendamento.setIdEstabelecimento(3L);

        when(buscarClientePorId.buscarClientePorId(1L)).thenReturn(new Cliente());
        when(buscarProfissionalPorId.buscarPorId(2L)).thenReturn(new Profissional());
        when(buscarEstabelecimentoPorId.buscarEstabelecimentoPorId(3L)).thenReturn(null);

        assertThrows(NoSuchElementException.class, () -> useCase.realizarAgendamento(agendamento));
    }

    @Test
    void deveLancarExcecaoSeServicoNaoExiste() {
        Agendamento agendamento = new Agendamento();
        agendamento.setIdCliente(1L);
        agendamento.setIdProfissional(2L);
        agendamento.setIdEstabelecimento(3L);
        agendamento.setIdServico(4L);

        when(buscarClientePorId.buscarClientePorId(1L)).thenReturn(new Cliente());
        when(buscarProfissionalPorId.buscarPorId(2L)).thenReturn(new Profissional());
        when(buscarEstabelecimentoPorId.buscarEstabelecimentoPorId(3L)).thenReturn(new Estabelecimento());
        when(buscarServicoPorId.buscarServicoPorId(4L)).thenReturn(null);

        assertThrows(NoSuchElementException.class, () -> useCase.realizarAgendamento(agendamento));
    }

    @Test
    void deveLancarExcecaoSeProfissionalOuServicoNaoPertenceAoEstabelecimento() {
        Agendamento agendamento = new Agendamento();
        agendamento.setIdCliente(1L);
        agendamento.setIdProfissional(2L);
        agendamento.setIdEstabelecimento(3L);
        agendamento.setIdServico(4L);

        Profissional profissional = new Profissional();
        profissional.setIdEstabelecimento(99L);

        Servico servico = new Servico();
        servico.setIdEstabelecimento(3L);

        Estabelecimento estabelecimento = new Estabelecimento();
        estabelecimento.setId(3L);

        when(buscarClientePorId.buscarClientePorId(1L)).thenReturn(new Cliente());
        when(buscarProfissionalPorId.buscarPorId(2L)).thenReturn(profissional);
        when(buscarEstabelecimentoPorId.buscarEstabelecimentoPorId(3L)).thenReturn(estabelecimento);
        when(buscarServicoPorId.buscarServicoPorId(4L)).thenReturn(servico);

        assertThrows(IllegalStateException.class, () -> useCase.realizarAgendamento(agendamento));
    }

    @Test
    void deveLancarExcecaoSeConflitoDeHorario() {
        Agendamento agendamento = new Agendamento();
        agendamento.setIdCliente(1L);
        agendamento.setIdProfissional(2L);
        agendamento.setIdEstabelecimento(3L);
        agendamento.setIdServico(4L);
        agendamento.setData(LocalDate.of(2025, 5, 17));
        agendamento.setHoraInicio(LocalTime.of(10, 0));
        agendamento.setHoraTermino(LocalTime.of(11, 0));

        Profissional profissional = new Profissional();
        profissional.setIdEstabelecimento(3L);

        Servico servico = new Servico();
        servico.setIdEstabelecimento(3L);

        Estabelecimento estabelecimento = new Estabelecimento();
        estabelecimento.setId(3L);

        Horario horario = new Horario();
        horario.setInicio(LocalTime.of(8, 0));
        horario.setFim(LocalTime.of(18, 0));

        Agendamento agendamentoExistente = new Agendamento();
        agendamentoExistente.setHoraInicio(LocalTime.of(10, 30));
        agendamentoExistente.setHoraTermino(LocalTime.of(11, 30));

        when(buscarClientePorId.buscarClientePorId(1L)).thenReturn(new Cliente());
        when(buscarProfissionalPorId.buscarPorId(2L)).thenReturn(profissional);
        when(buscarEstabelecimentoPorId.buscarEstabelecimentoPorId(3L)).thenReturn(estabelecimento);
        when(buscarServicoPorId.buscarServicoPorId(4L)).thenReturn(servico);
        when(buscarHorarioPorDia.buscarHorarioPorDia(3L, DiasDaSemanaEnum.SATURDAY)).thenReturn(horario);
        when(buscarAgendamentos.buscarAgendamentos(2L, agendamento.getData()))
                .thenReturn(List.of(agendamentoExistente));

        assertThrows(IllegalStateException.class, () -> useCase.realizarAgendamento(agendamento));
    }
}

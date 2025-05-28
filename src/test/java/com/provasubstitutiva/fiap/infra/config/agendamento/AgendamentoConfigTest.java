package com.provasubstitutiva.fiap.infra.config.agendamento;

import com.provasubstitutiva.fiap.application.usecase.agendamento.BuscarAgendamentoPorId;
import com.provasubstitutiva.fiap.application.usecase.agendamento.BuscarAgendamentosPorProfissionalEDia;
import com.provasubstitutiva.fiap.application.usecase.agendamento.CancelarAgendamento;
import com.provasubstitutiva.fiap.application.usecase.agendamento.RealizarAgendamento;
import com.provasubstitutiva.fiap.application.usecase.agendamento.impl.BuscarAgendamentosPorProfissionalEDiaImpl;
import com.provasubstitutiva.fiap.application.usecase.agendamento.impl.CancelarAgendamentoImpl;
import com.provasubstitutiva.fiap.application.usecase.agendamento.impl.RealizarAgendamentoImpl;
import com.provasubstitutiva.fiap.application.usecase.cliente.BuscarClientePorId;
import com.provasubstitutiva.fiap.application.usecase.estabelecimento.BuscarEstabelecimentoPorId;
import com.provasubstitutiva.fiap.application.usecase.horario.BuscarHorarioPorDia;
import com.provasubstitutiva.fiap.application.usecase.profissional.BuscarProfissionalPorId;
import com.provasubstitutiva.fiap.application.usecase.servico.BuscarServicoPorId;
import com.provasubstitutiva.fiap.infra.gateway.agendamento.AgendamentoJPAAdapter;
import com.provasubstitutiva.fiap.infra.gateway.agendamento.AgendamentoMapper;
import com.provasubstitutiva.fiap.infra.persistence.agendamento.AgendamentoRepository;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class AgendamentoConfigTest {

    private final AgendamentoConfig config = new AgendamentoConfig();

    @Test
    void deveInstanciarBuscarAgendamentosPorProfissionalEDiaImpl() {
        BuscarAgendamentosPorProfissionalEDia mock = mock(BuscarAgendamentosPorProfissionalEDia.class);
        var result = config.buscarAgendamentosPorProfissionalEDia(mock);
        assertNotNull(result);
    }

    @Test
    void deveInstanciarCancelarAgendamentoImpl() {
        CancelarAgendamento cancelar = mock(CancelarAgendamento.class);
        BuscarAgendamentoPorId buscar = mock(BuscarAgendamentoPorId.class);
        var result = config.cancelarAgendamento(cancelar, buscar);
        assertNotNull(result);
    }

    @Test
    void deveInstanciarRealizarAgendamentoImpl() {
        RealizarAgendamento realizar = mock(RealizarAgendamento.class);
        BuscarClientePorId cliente = mock(BuscarClientePorId.class);
        BuscarProfissionalPorId profissional = mock(BuscarProfissionalPorId.class);
        BuscarEstabelecimentoPorId est = mock(BuscarEstabelecimentoPorId.class);
        BuscarServicoPorId servico = mock(BuscarServicoPorId.class);
        BuscarHorarioPorDia horario = mock(BuscarHorarioPorDia.class);
        BuscarAgendamentosPorProfissionalEDia buscar = mock(BuscarAgendamentosPorProfissionalEDia.class);
        var result = config.realizarAgendamento(realizar, cliente, profissional, est, servico, horario, buscar);
        assertNotNull(result);
    }

    @Test
    void deveInstanciarAgendamentoJPAAdapter() {
        AgendamentoRepository repo = mock(AgendamentoRepository.class);
        AgendamentoMapper mapper = new AgendamentoMapper();
        var result = config.agendamentoJPAAdapter(repo, mapper);
        assertNotNull(result);
    }

    @Test
    void deveInstanciarAgendamentoMapper() {
        var result = config.agendamentoMapper();
        assertNotNull(result);
    }
}

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
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AgendamentoConfig {

    @Bean
    BuscarAgendamentosPorProfissionalEDiaImpl buscarAgendamentosPorProfissionalEDia(BuscarAgendamentosPorProfissionalEDia buscarAgendamentosPorProfissionalEDia) {
        return new BuscarAgendamentosPorProfissionalEDiaImpl(buscarAgendamentosPorProfissionalEDia);
    }

    @Bean
    CancelarAgendamentoImpl cancelarAgendamento(CancelarAgendamento cancelarAgendamento, BuscarAgendamentoPorId buscarAgendamentoPorId) {
        return new CancelarAgendamentoImpl(cancelarAgendamento, buscarAgendamentoPorId);
    }

    @Bean
    RealizarAgendamentoImpl realizarAgendamento(RealizarAgendamento realizarAgendamento,
                                                BuscarClientePorId buscarClientePorId,
                                                BuscarProfissionalPorId buscarProfissionalPorId,
                                                BuscarEstabelecimentoPorId buscarEstabelecimentoPorId,
                                                BuscarServicoPorId buscarServicoPorId,
                                                BuscarHorarioPorDia buscarHorarioPorDia,
                                                BuscarAgendamentosPorProfissionalEDia buscarAgendamentosPorProfissionalEDia) {
        return new RealizarAgendamentoImpl(realizarAgendamento,
                buscarClientePorId,
                buscarProfissionalPorId,
                buscarEstabelecimentoPorId,
                buscarServicoPorId,
                buscarHorarioPorDia,
                buscarAgendamentosPorProfissionalEDia
        );
    }

    @Bean
    AgendamentoJPAAdapter agendamentoJPAAdapter(AgendamentoRepository repository, AgendamentoMapper mapper) {
        return new AgendamentoJPAAdapter(repository, mapper);
    }

    @Bean
    AgendamentoMapper agendamentoMapper(){
        return new AgendamentoMapper();
    }
}

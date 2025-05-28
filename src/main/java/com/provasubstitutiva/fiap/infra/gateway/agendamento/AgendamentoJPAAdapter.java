package com.provasubstitutiva.fiap.infra.gateway.agendamento;

import com.provasubstitutiva.fiap.application.usecase.agendamento.*;
import com.provasubstitutiva.fiap.domain.model.Agendamento;
import com.provasubstitutiva.fiap.infra.persistence.agendamento.AgendamentoEntity;
import com.provasubstitutiva.fiap.infra.persistence.agendamento.AgendamentoRepository;
import lombok.AllArgsConstructor;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
public class AgendamentoJPAAdapter implements
        BuscarAgendamentoPorId,
        BuscarAgendamentosPorCliente,
        BuscarAgendamentosPorProfissionalEDia,
        CancelarAgendamento,
        RealizarAgendamento {

    private final AgendamentoRepository repository;
    private final AgendamentoMapper mapper;

    @Override
    public Agendamento buscarAgendamentoPorId(Long id) {
        Optional<AgendamentoEntity> byId = repository.findById(id);
        return byId.map(mapper::toDomain).orElse(null);
    }

    @Override
    public List<Agendamento> buscarAgendamentos(Long idCliente) {
        List<Agendamento> list = repository.findByIdCliente(idCliente)
                .stream()
                .map(mapper::toDomain)
                .toList();
        return list.isEmpty() ? null : list;
    }

    @Override
    public List<Agendamento> buscarAgendamentos(Long idProfissional, LocalDate data) {
        List<Agendamento> list = repository.findByIdProfissionalAndData(idProfissional, data)
                .stream()
                .map(mapper::toDomain)
                .toList();
        return list.isEmpty() ? null : list;
    }

    @Override
    public Agendamento cancelar(Agendamento agendamento) {
        return mapper.toDomain(repository.save(mapper.toEntity(agendamento)));
    }

    @Override
    public Agendamento agendar(Agendamento agendamento) {
        return mapper.toDomain(repository.save(mapper.toEntity(agendamento)));
    }
}

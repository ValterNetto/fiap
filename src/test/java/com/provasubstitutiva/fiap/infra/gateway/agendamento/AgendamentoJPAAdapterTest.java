package com.provasubstitutiva.fiap.infra.gateway.agendamento;

import com.provasubstitutiva.fiap.domain.model.Agendamento;
import com.provasubstitutiva.fiap.domain.model.constant.StatusEnum;
import com.provasubstitutiva.fiap.infra.persistence.agendamento.AgendamentoEntity;
import com.provasubstitutiva.fiap.infra.persistence.agendamento.AgendamentoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class AgendamentoJPAAdapterTest {

    private AgendamentoRepository repository;
    private AgendamentoMapper mapper;
    private AgendamentoJPAAdapter adapter;

    private AgendamentoEntity entity;
    private Agendamento domain;

    @BeforeEach
    void setup() {
        repository = mock(AgendamentoRepository.class);
        mapper = mock(AgendamentoMapper.class);
        adapter = new AgendamentoJPAAdapter(repository, mapper);

        entity = new AgendamentoEntity();
        domain = new Agendamento(1L, 1L, 1L, 1L, 1L, StatusEnum.CONCLUIDO, LocalDate.now(), null, null);
    }

    @Test
    void testBuscarAgendamentoPorIdExistente() {
        when(repository.findById(1L)).thenReturn(Optional.of(entity));
        when(mapper.toDomain(entity)).thenReturn(domain);

        Agendamento result = adapter.buscarAgendamentoPorId(1L);

        assertNotNull(result);
        assertEquals(domain, result);
    }

    @Test
    void testBuscarAgendamentoPorIdInexistente() {
        when(repository.findById(99L)).thenReturn(Optional.empty());

        Agendamento result = adapter.buscarAgendamentoPorId(99L);

        assertNull(result);
    }

    @Test
    void testBuscarAgendamentosPorClienteComResultado() {
        when(repository.findByIdCliente(1L)).thenReturn(List.of(entity));
        when(mapper.toDomain(entity)).thenReturn(domain);

        List<Agendamento> result = adapter.buscarAgendamentos(1L);

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals(domain, result.get(0));
    }

    @Test
    void testBuscarAgendamentosPorClienteSemResultado() {
        when(repository.findByIdCliente(1L)).thenReturn(List.of());

        List<Agendamento> result = adapter.buscarAgendamentos(1L);

        assertNull(result);
    }

    @Test
    void testBuscarAgendamentosPorProfissionalEDiaComResultado() {
        when(repository.findByIdProfissionalAndData(1L, LocalDate.now())).thenReturn(List.of(entity));
        when(mapper.toDomain(entity)).thenReturn(domain);

        List<Agendamento> result = adapter.buscarAgendamentos(1L, LocalDate.now());

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals(domain, result.get(0));
    }

    @Test
    void testBuscarAgendamentosPorProfissionalEDiaSemResultado() {
        when(repository.findByIdProfissionalAndData(1L, LocalDate.now())).thenReturn(List.of());

        List<Agendamento> result = adapter.buscarAgendamentos(1L, LocalDate.now());

        assertNull(result);
    }

    @Test
    void testCancelarAgendamento() {
        when(mapper.toEntity(domain)).thenReturn(entity);
        when(repository.save(entity)).thenReturn(entity);
        when(mapper.toDomain(entity)).thenReturn(domain);

        Agendamento result = adapter.cancelar(domain);

        assertNotNull(result);
        assertEquals(domain, result);
    }

    @Test
    void testAgendar() {
        when(mapper.toEntity(domain)).thenReturn(entity);
        when(repository.save(entity)).thenReturn(entity);
        when(mapper.toDomain(entity)).thenReturn(domain);

        Agendamento result = adapter.agendar(domain);

        assertNotNull(result);
        assertEquals(domain, result);
    }
}

package com.provasubstitutiva.fiap.infra.gateway.servico;

import com.provasubstitutiva.fiap.domain.model.Servico;
import com.provasubstitutiva.fiap.infra.persistence.servico.ServicoEntity;
import com.provasubstitutiva.fiap.infra.persistence.servico.ServicoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ServicoJPAAdapterTest {

    private ServicoRepository repository;
    private ServicoMapper mapper;
    private ServicoJPAAdapter adapter;

    private Servico servicoDomain;
    private ServicoEntity servicoEntity;

    @BeforeEach
    void setup() {
        repository = mock(ServicoRepository.class);
        mapper = mock(ServicoMapper.class);
        adapter = new ServicoJPAAdapter(repository, mapper);

        servicoDomain = new Servico(1L, "Depilação", 100, 10L);
        servicoEntity = new ServicoEntity();
    }

    @Test
    void testBuscarPorIdEstabelecimento() {
        when(repository.findByIdEstabelecimento(10L)).thenReturn(List.of(servicoEntity));
        when(mapper.toDomain(servicoEntity)).thenReturn(servicoDomain);

        List<Servico> result = adapter.buscarPorIdEstabelecimento(10L);

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals(servicoDomain, result.get(0));
    }

    @Test
    void testBuscarServicoPorIdExiste() {
        when(repository.findById(1L)).thenReturn(Optional.of(servicoEntity));
        when(mapper.toDomain(servicoEntity)).thenReturn(servicoDomain);

        Servico result = adapter.buscarServicoPorId(1L);

        assertNotNull(result);
        assertEquals(servicoDomain, result);
    }

    @Test
    void testBuscarServicoPorIdNaoExiste() {
        when(repository.findById(1L)).thenReturn(Optional.empty());

        Servico result = adapter.buscarServicoPorId(1L);

        assertNull(result);
    }

    @Test
    void testBuscarServicoPorNome() {
        when(repository.findByNome("Depilação")).thenReturn(List.of(servicoEntity));
        when(mapper.toDomain(servicoEntity)).thenReturn(servicoDomain);

        List<Servico> result = adapter.buscarServicoPorNome("Depilação");

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals(servicoDomain, result.get(0));
    }

    @Test
    void testCancelarServico() {
        adapter.cancelarServico(1L);
        verify(repository).deleteById(1L);
    }

    @Test
    void testRegistrarServico() {
        when(mapper.toEntity(servicoDomain)).thenReturn(servicoEntity);
        when(repository.save(servicoEntity)).thenReturn(servicoEntity);
        when(mapper.toDomain(servicoEntity)).thenReturn(servicoDomain);

        Servico result = adapter.registrarServico(servicoDomain);

        assertNotNull(result);
        assertEquals(servicoDomain, result);
    }
}

package com.provasubstitutiva.fiap.infra.gateway.avaliacao;

import com.provasubstitutiva.fiap.domain.model.Avaliacao;
import com.provasubstitutiva.fiap.infra.persistence.avaliacao.AvaliacaoEntity;
import com.provasubstitutiva.fiap.infra.persistence.avaliacao.AvaliacaoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class AvaliacaoJPAAdapterTest {

    private AvaliacaoRepository repository;
    private AvaliacaoMapper mapper;
    private AvaliacaoJPAAdapter adapter;

    private Avaliacao domain;
    private AvaliacaoEntity entity;

    @BeforeEach
    void setup() {
        repository = mock(AvaliacaoRepository.class);
        mapper = mock(AvaliacaoMapper.class);
        adapter = new AvaliacaoJPAAdapter(repository, mapper);

        domain = new Avaliacao(1L, 10L, 5, "Muito bom", 20L, null);
        entity = new AvaliacaoEntity();
    }

    @Test
    void testFazerAvaliacao() {
        when(mapper.toEntity(domain)).thenReturn(entity);
        when(repository.save(entity)).thenReturn(entity);
        when(mapper.toDomain(entity)).thenReturn(domain);

        Avaliacao result = adapter.fazerAvaliacao(domain);

        assertEquals(domain, result);
    }

    @Test
    void testAvaliarProfissional() {
        when(mapper.toEntity(domain)).thenReturn(entity);
        when(repository.save(entity)).thenReturn(entity);
        when(mapper.toDomain(entity)).thenReturn(domain);

        Avaliacao result = adapter.avaliarProfissional(domain);

        assertEquals(domain, result);
    }

    @Test
    void testBuscarAvaliacaoPorIdExiste() {
        when(repository.findById(1L)).thenReturn(Optional.of(entity));
        when(mapper.toDomain(entity)).thenReturn(domain);

        Avaliacao result = adapter.buscarAvaliacaoPorId(1L);

        assertEquals(domain, result);
    }

    @Test
    void testBuscarAvaliacaoPorIdNaoExiste() {
        when(repository.findById(1L)).thenReturn(Optional.empty());

        Avaliacao result = adapter.buscarAvaliacaoPorId(1L);

        assertNull(result);
    }

    @Test
    void testBuscarAvaliacoesPorIdCliente() {
        when(repository.findByIdCliente(10L)).thenReturn(List.of(entity));
        when(mapper.toDomain(entity)).thenReturn(domain);

        List<Avaliacao> result = adapter.buscarAvaliacoesPorIdCliente(10L);

        assertEquals(1, result.size());
        assertEquals(domain, result.get(0));
    }

    @Test
    void testBuscarPorIdEstabelecimento() {
        when(repository.findByIdEstabelecimento(20L)).thenReturn(List.of(entity));
        when(mapper.toDomain(entity)).thenReturn(domain);

        List<Avaliacao> result = adapter.buscarPorIdEstabelecimento(20L);

        assertEquals(1, result.size());
        assertEquals(domain, result.get(0));
    }

    @Test
    void testEditarAvaliacao() {
        when(mapper.toEntity(domain)).thenReturn(entity);
        when(repository.save(entity)).thenReturn(entity);
        when(mapper.toDomain(entity)).thenReturn(domain);

        Avaliacao result = adapter.editarAvaliacao(domain);

        assertEquals(domain, result);
    }

    @Test
    void testExcluir() {
        adapter.excluir(1L);
        verify(repository).deleteById(1L);
    }

    @Test
    void testVerTodasAsAvaliacoes() {
        when(repository.findAll()).thenReturn(List.of(entity));
        when(mapper.toDomain(entity)).thenReturn(domain);

        List<Avaliacao> result = adapter.verTodasAsAvaliacoes();

        assertEquals(1, result.size());
        assertEquals(domain, result.get(0));
    }
}

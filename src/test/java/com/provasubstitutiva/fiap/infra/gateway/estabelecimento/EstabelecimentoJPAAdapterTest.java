package com.provasubstitutiva.fiap.infra.gateway.estabelecimento;

import com.provasubstitutiva.fiap.domain.model.Estabelecimento;
import com.provasubstitutiva.fiap.infra.persistence.estabelecimento.EstabelecimentoEntity;
import com.provasubstitutiva.fiap.infra.persistence.estabelecimento.EstabelecimentoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class EstabelecimentoJPAAdapterTest {

    private EstabelecimentoRepository repository;
    private EstabelecimentoMapper mapper;
    private EstabelecimentoJPAAdapter adapter;

    private Estabelecimento estabelecimentoDomain;
    private EstabelecimentoEntity estabelecimentoEntity;

    @BeforeEach
    void setUp() {
        repository = mock(EstabelecimentoRepository.class);
        mapper = mock(EstabelecimentoMapper.class);
        adapter = new EstabelecimentoJPAAdapter(repository, mapper);

        estabelecimentoDomain = new Estabelecimento(1L, "Beleza Pura", 100L, "contato@beleza.com");
        estabelecimentoEntity = new EstabelecimentoEntity();
    }

    @Test
    void testBuscarEstabelecimentoPorIdExiste() {
        when(repository.findById(1L)).thenReturn(Optional.of(estabelecimentoEntity));
        when(mapper.toDomain(estabelecimentoEntity)).thenReturn(estabelecimentoDomain);

        Estabelecimento result = adapter.buscarEstabelecimentoPorId(1L);

        assertNotNull(result);
        assertEquals(estabelecimentoDomain, result);
    }

    @Test
    void testBuscarEstabelecimentoPorIdNaoExiste() {
        when(repository.findById(1L)).thenReturn(Optional.empty());

        Estabelecimento result = adapter.buscarEstabelecimentoPorId(1L);

        assertNull(result);
    }

    @Test
    void testEditarEstabelecimento() {
        when(mapper.toEntity(estabelecimentoDomain)).thenReturn(estabelecimentoEntity);
        when(repository.save(estabelecimentoEntity)).thenReturn(estabelecimentoEntity);
        when(mapper.toDomain(estabelecimentoEntity)).thenReturn(estabelecimentoDomain);

        Estabelecimento result = adapter.editarEstabelecimento(estabelecimentoDomain);

        assertNotNull(result);
        assertEquals(estabelecimentoDomain, result);
    }

    @Test
    void testBuscarPorNome() {
        when(repository.findAllByNome("Beleza")).thenReturn(List.of(estabelecimentoEntity));
        when(mapper.toDomain(estabelecimentoEntity)).thenReturn(estabelecimentoDomain);

        List<Estabelecimento> result = adapter.buscarPorNome("Beleza");

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals(estabelecimentoDomain, result.get(0));
    }

    @Test
    void testRegistrarEstabelecimento() {
        when(mapper.toEntity(estabelecimentoDomain)).thenReturn(estabelecimentoEntity);
        when(repository.save(estabelecimentoEntity)).thenReturn(estabelecimentoEntity);
        when(mapper.toDomain(estabelecimentoEntity)).thenReturn(estabelecimentoDomain);

        Estabelecimento result = adapter.registrarEstabelecimento(estabelecimentoDomain);

        assertNotNull(result);
        assertEquals(estabelecimentoDomain, result);
    }
}

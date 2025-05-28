package com.provasubstitutiva.fiap.infra.gateway.profissional;

import com.provasubstitutiva.fiap.domain.model.Profissional;
import com.provasubstitutiva.fiap.infra.persistence.profissional.ProfissionalEntity;
import com.provasubstitutiva.fiap.infra.persistence.profissional.ProfissionalRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ProfissionalJPAAdapterTest {

    private ProfissionalRepository repository;
    private ProfissionalMapper mapper;
    private ProfissionalJPAAdapter adapter;

    private Profissional profissionalDomain;
    private ProfissionalEntity profissionalEntity;

    @BeforeEach
    void setup() {
        repository = mock(ProfissionalRepository.class);
        mapper = mock(ProfissionalMapper.class);
        adapter = new ProfissionalJPAAdapter(repository, mapper);

        profissionalDomain = new Profissional(1L, "Lívia", "livia@email.com", "Manicure", 100, 2L);
        profissionalEntity = new ProfissionalEntity();
    }

    @Test
    void testAdmitirProfissional() {
        when(mapper.toEntity(profissionalDomain)).thenReturn(profissionalEntity);
        when(repository.save(profissionalEntity)).thenReturn(profissionalEntity);
        when(mapper.toDomain(profissionalEntity)).thenReturn(profissionalDomain);

        Profissional result = adapter.admitirProfissional(profissionalDomain);

        assertNotNull(result);
        assertEquals(profissionalDomain, result);
    }

    @Test
    void testBuscarPorIdExiste() {
        when(repository.findById(1L)).thenReturn(Optional.of(profissionalEntity));
        when(mapper.toDomain(profissionalEntity)).thenReturn(profissionalDomain);

        Profissional result = adapter.buscarPorId(1L);

        assertNotNull(result);
        assertEquals(profissionalDomain, result);
    }

    @Test
    void testBuscarPorIdNaoExiste() {
        when(repository.findById(1L)).thenReturn(Optional.empty());

        Profissional result = adapter.buscarPorId(1L);

        assertNull(result);
    }

    @Test
    void testDemitirProfissional() {
        when(mapper.toEntity(profissionalDomain)).thenReturn(profissionalEntity);
        when(repository.save(profissionalEntity)).thenReturn(profissionalEntity);
        when(mapper.toDomain(profissionalEntity)).thenReturn(profissionalDomain);

        Profissional result = adapter.demitir(profissionalDomain);

        assertNotNull(result);
        assertEquals(profissionalDomain, result);
    }

    @Test
    void testRegistrarProfissional() {
        when(mapper.toEntity(profissionalDomain)).thenReturn(profissionalEntity);
        when(repository.save(profissionalEntity)).thenReturn(profissionalEntity);
        when(mapper.toDomain(profissionalEntity)).thenReturn(profissionalDomain);

        Profissional result = adapter.registrar(profissionalDomain);

        assertNotNull(result);
        assertEquals(profissionalDomain, result);
    }
}

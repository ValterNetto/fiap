package com.provasubstitutiva.fiap.infra.gateway.endereco;

import com.provasubstitutiva.fiap.domain.model.Endereco;
import com.provasubstitutiva.fiap.infra.persistence.endereco.EnderecoEntity;
import com.provasubstitutiva.fiap.infra.persistence.endereco.EnderecoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class EnderecoJPAAdapterTest {

    private EnderecoRepository repository;
    private EnderecoMapper mapper;
    private EnderecoJPAAdapter adapter;

    private Endereco enderecoDomain;
    private EnderecoEntity enderecoEntity;

    @BeforeEach
    void setup() {
        repository = mock(EnderecoRepository.class);
        mapper = mock(EnderecoMapper.class);
        adapter = new EnderecoJPAAdapter(repository, mapper);

        enderecoDomain = new Endereco(1L, "Rua A", "12345-678", "10", -23.5, -46.6, 99L);
        enderecoEntity = new EnderecoEntity();
    }

    @Test
    void testBuscarEnderecoPorIdExiste() {
        when(repository.findById(1L)).thenReturn(Optional.of(enderecoEntity));
        when(mapper.toDomain(enderecoEntity)).thenReturn(enderecoDomain);

        Endereco result = adapter.buscarEnderecoPorId(1L);

        assertNotNull(result);
        assertEquals(enderecoDomain, result);
    }

    @Test
    void testBuscarEnderecoPorIdNaoExiste() {
        when(repository.findById(1L)).thenReturn(Optional.empty());

        Endereco result = adapter.buscarEnderecoPorId(1L);

        assertNull(result);
    }

    @Test
    void testBuscarPorIdEstabelecimentoExiste() {
        when(repository.findByIdEstabelecimento(99L)).thenReturn(Optional.of(enderecoEntity));
        when(mapper.toDomain(enderecoEntity)).thenReturn(enderecoDomain);

        Endereco result = adapter.buscarPorIdEstabelecimento(99L);

        assertNotNull(result);
        assertEquals(enderecoDomain, result);
    }

    @Test
    void testBuscarPorIdEstabelecimentoNaoExiste() {
        when(repository.findByIdEstabelecimento(99L)).thenReturn(Optional.empty());

        Endereco result = adapter.buscarPorIdEstabelecimento(99L);

        assertNull(result);
    }

    @Test
    void testEditarEndereco() {
        when(mapper.toEntity(enderecoDomain)).thenReturn(enderecoEntity);
        when(repository.save(enderecoEntity)).thenReturn(enderecoEntity);
        when(mapper.toDomain(enderecoEntity)).thenReturn(enderecoDomain);

        Endereco result = adapter.editarEndereco(enderecoDomain);

        assertNotNull(result);
        assertEquals(enderecoDomain, result);
    }

    @Test
    void testBuscarPorLatitudeELongitude() {
        List<Long> expected = List.of(1L, 2L, 3L);
        when(repository.findIdEstabelecimentoByLatLongInRange(-23.6, -23.4, -46.7, -46.5)).thenReturn(expected);

        List<Long> result = adapter.buscarPorLatitudeELongitude(-23.6, -46.7, -23.4, -46.5);

        assertEquals(expected, result);
    }

    @Test
    void testRegistrarEndereco() {
        when(mapper.toEntity(enderecoDomain)).thenReturn(enderecoEntity);
        when(repository.save(enderecoEntity)).thenReturn(enderecoEntity);
        when(mapper.toDomain(enderecoEntity)).thenReturn(enderecoDomain);

        Endereco result = adapter.registrarEndereco(enderecoDomain);

        assertNotNull(result);
        assertEquals(enderecoDomain, result);
    }
}

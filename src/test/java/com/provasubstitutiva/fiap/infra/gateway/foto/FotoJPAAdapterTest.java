package com.provasubstitutiva.fiap.infra.gateway.foto;

import com.provasubstitutiva.fiap.domain.model.Foto;
import com.provasubstitutiva.fiap.infra.persistence.foto.FotoEntity;
import com.provasubstitutiva.fiap.infra.persistence.foto.FotoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class FotoJPAAdapterTest {

    private FotoRepository repository;
    private FotoMapper mapper;
    private FotoJPAAdapter adapter;

    private Foto fotoDomain;
    private FotoEntity fotoEntity;

    @BeforeEach
    void setup() {
        repository = mock(FotoRepository.class);
        mapper = mock(FotoMapper.class);
        adapter = new FotoJPAAdapter(repository, mapper);

        fotoDomain = new Foto(1L, "fachada", "base64", 10L);
        fotoEntity = new FotoEntity();
    }

    @Test
    void testAdicionarFoto() {
        when(mapper.toEntity(fotoDomain)).thenReturn(fotoEntity);
        when(repository.save(fotoEntity)).thenReturn(fotoEntity);
        when(mapper.toDomain(fotoEntity)).thenReturn(fotoDomain);

        Foto result = adapter.adicionarFoto(fotoDomain);

        assertNotNull(result);
        assertEquals(fotoDomain, result);
    }

    @Test
    void testBuscarFotoPorIdEstabelecimento() {
        when(repository.findByIdEstabelecimento(10L)).thenReturn(List.of(fotoEntity));
        when(mapper.toDomain(fotoEntity)).thenReturn(fotoDomain);

        List<Foto> result = adapter.buscarFotoPorIdEstabelecimento(10L);

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals(fotoDomain, result.get(0));
    }

    @Test
    void testExcluirFoto() {
        adapter.excluirFoto(1L);
        verify(repository).deleteById(1L);
    }
}

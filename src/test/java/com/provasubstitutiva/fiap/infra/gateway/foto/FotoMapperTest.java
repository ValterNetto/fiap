package com.provasubstitutiva.fiap.infra.gateway.foto;

import com.provasubstitutiva.fiap.domain.model.Foto;
import com.provasubstitutiva.fiap.infra.persistence.foto.FotoEntity;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FotoMapperTest {

    private final FotoMapper mapper = new FotoMapper();

    @Test
    void testToDomain() {
        FotoEntity entity = new FotoEntity(
                1L,
                "fachada",
                "base64img",
                100L
        );

        Foto domain = mapper.toDomain(entity);

        assertEquals(entity.getId(), domain.getId());
        assertEquals(entity.getNome(), domain.getNome());
        assertEquals(entity.getFoto(), domain.getFoto());
        assertEquals(entity.getIdEstabelecimento(), domain.getIdEstabelecimento());
    }

    @Test
    void testToEntity() {
        Foto domain = new Foto(
                2L,
                "recepção",
                "imgdata",
                200L
        );

        FotoEntity entity = mapper.toEntity(domain);

        assertEquals(domain.getId(), entity.getId());
        assertEquals(domain.getNome(), entity.getNome());
        assertEquals(domain.getFoto(), entity.getFoto());
        assertEquals(domain.getIdEstabelecimento(), entity.getIdEstabelecimento());
    }
}

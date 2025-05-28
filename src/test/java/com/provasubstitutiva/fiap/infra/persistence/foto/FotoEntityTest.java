package com.provasubstitutiva.fiap.infra.persistence.foto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FotoEntityTest {

    @Test
    void testAllArgsConstructorAndGetters() {
        FotoEntity entity = new FotoEntity(
                1L,
                "fachada",
                "base64imagem",
                101L
        );

        assertEquals(1L, entity.getId());
        assertEquals("fachada", entity.getNome());
        assertEquals("base64imagem", entity.getFoto());
        assertEquals(101L, entity.getIdEstabelecimento());
    }

    @Test
    void testSettersAndNoArgsConstructor() {
        FotoEntity entity = new FotoEntity();

        entity.setId(2L);
        entity.setNome("recepção");
        entity.setFoto("imgdata123");
        entity.setIdEstabelecimento(202L);

        assertEquals(2L, entity.getId());
        assertEquals("recepção", entity.getNome());
        assertEquals("imgdata123", entity.getFoto());
        assertEquals(202L, entity.getIdEstabelecimento());
    }
}

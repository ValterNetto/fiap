package com.provasubstitutiva.fiap.infra.controller.foto;

import com.provasubstitutiva.fiap.domain.model.Foto;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FotoDTOTest {

    @Test
    void testConstrutorComFoto() {
        Foto foto = new Foto(1L, "interior", "base64string", 5L);
        FotoDTO dto = new FotoDTO(foto);

        assertEquals(1L, dto.id());
        assertEquals("interior", dto.nome());
        assertEquals("base64string", dto.foto());
        assertEquals(5L, dto.idEstabelecimento());
    }

    @Test
    void testConstrutorDireto() {
        FotoDTO dto = new FotoDTO(2L, "recepção", "imagem64", 8L);

        assertEquals(2L, dto.id());
        assertEquals("recepção", dto.nome());
        assertEquals("imagem64", dto.foto());
        assertEquals(8L, dto.idEstabelecimento());
    }
}

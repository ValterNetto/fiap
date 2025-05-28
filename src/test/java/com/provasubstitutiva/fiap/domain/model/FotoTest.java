package com.provasubstitutiva.fiap.domain.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FotoTest {

    @Test
    void deveCriarFotoComTodosOsCampos() {
        Foto foto = new Foto(1L, "fachada.jpg", "base64ImagemFachada", 100L);

        assertEquals(1L, foto.getId());
        assertEquals("fachada.jpg", foto.getNome());
        assertEquals("base64ImagemFachada", foto.getFoto());
        assertEquals(100L, foto.getIdEstabelecimento());
    }

    @Test
    void devePermitirSettersEAcessarComGetters() {
        Foto foto = new Foto();
        foto.setId(2L);
        foto.setNome("salao_interno.png");
        foto.setFoto("base64ImagemInterna");
        foto.setIdEstabelecimento(200L);

        assertEquals(2L, foto.getId());
        assertEquals("salao_interno.png", foto.getNome());
        assertEquals("base64ImagemInterna", foto.getFoto());
        assertEquals(200L, foto.getIdEstabelecimento());
    }
}

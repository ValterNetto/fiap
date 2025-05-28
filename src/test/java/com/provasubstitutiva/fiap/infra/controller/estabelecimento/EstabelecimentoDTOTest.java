package com.provasubstitutiva.fiap.infra.controller.estabelecimento;

import com.provasubstitutiva.fiap.domain.model.Estabelecimento;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EstabelecimentoDTOTest {

    @Test
    void testConstrutorComEstabelecimento() {
        Estabelecimento estabelecimento = new Estabelecimento(1L, "Clínica Saúde", 200L, "contato@clinica.com");
        EstabelecimentoDTO dto = new EstabelecimentoDTO(estabelecimento);

        assertEquals(1L, dto.id());
        assertEquals("Clínica Saúde", dto.nome());
        assertEquals(200L, dto.idEndereco());
        assertEquals("contato@clinica.com", dto.email());
    }

    @Test
    void testConstrutorDireto() {
        EstabelecimentoDTO dto = new EstabelecimentoDTO(2L, "Pet Shop Alegria", 300L, "contato@pet.com");

        assertEquals(2L, dto.id());
        assertEquals("Pet Shop Alegria", dto.nome());
        assertEquals(300L, dto.idEndereco());
        assertEquals("contato@pet.com", dto.email());
    }
}

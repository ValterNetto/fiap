package com.provasubstitutiva.fiap.infra.controller.endereco;

import com.provasubstitutiva.fiap.domain.model.Endereco;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EnderecoDTOTest {

    @Test
    void testConstrutorComEndereco() {
        Endereco endereco = new Endereco(1L, "Rua B", "98765-432", "20", -22.0, -43.0, 55L);
        EnderecoDTO dto = new EnderecoDTO(endereco);

        assertEquals(1L, dto.id());
        assertEquals("Rua B", dto.logradouro());
        assertEquals("98765-432", dto.cep());
        assertEquals("20", dto.numero());
        assertEquals(-22.0, dto.latitude());
        assertEquals(-43.0, dto.longitude());
        assertEquals(55L, dto.idEstabelecimento());
    }

    @Test
    void testConstrutorDireto() {
        EnderecoDTO dto = new EnderecoDTO(2L, "Av. Central", "11111-222", "100", -10.5, -50.2, 77L);

        assertEquals(2L, dto.id());
        assertEquals("Av. Central", dto.logradouro());
        assertEquals("11111-222", dto.cep());
        assertEquals("100", dto.numero());
        assertEquals(-10.5, dto.latitude());
        assertEquals(-50.2, dto.longitude());
        assertEquals(77L, dto.idEstabelecimento());
    }
}

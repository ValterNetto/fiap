package com.provasubstitutiva.fiap.infra.controller.servico;

import com.provasubstitutiva.fiap.domain.model.Servico;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ServicoDTOTest {

    @Test
    void testConstrutorComServico() {
        Servico servico = new Servico(1L, "Manicure", 80, 3L);
        ServicoDTO dto = new ServicoDTO(servico);

        assertEquals(1L, dto.id());
        assertEquals("Manicure", dto.nome());
        assertEquals(80, dto.valor());
        assertEquals(3L, dto.idEstabelecimento());
    }

    @Test
    void testConstrutorDireto() {
        ServicoDTO dto = new ServicoDTO(2L, "Pedicure", 90, 4L);

        assertEquals(2L, dto.id());
        assertEquals("Pedicure", dto.nome());
        assertEquals(90, dto.valor());
        assertEquals(4L, dto.idEstabelecimento());
    }
}

package com.provasubstitutiva.fiap.infra.controller.avaliacao;

import com.provasubstitutiva.fiap.domain.model.Avaliacao;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AvaliacaoDTOTest {

    @Test
    void testConstrutorComAvaliacao() {
        Avaliacao avaliacao = new Avaliacao(1L, 2L, 5, "Ótimo!", 3L, null);
        AvaliacaoDTO dto = new AvaliacaoDTO(avaliacao);

        assertEquals(avaliacao.getId(), dto.id());
        assertEquals(avaliacao.getIdCliente(), dto.idCliente());
        assertEquals(avaliacao.getEstrelas(), dto.estrelas());
        assertEquals(avaliacao.getComentario(), dto.comentario());
        assertEquals(avaliacao.getIdEstabelecimento(), dto.idEstabelecimento());
        assertEquals(avaliacao.getIdProfissional(), dto.idProfissional());
    }

    @Test
    void testConstrutorDireto() {
        AvaliacaoDTO dto = new AvaliacaoDTO(10L, 20L, 4, "Bom atendimento", 30L, 40L);

        assertEquals(10L, dto.id());
        assertEquals(20L, dto.idCliente());
        assertEquals(4, dto.estrelas());
        assertEquals("Bom atendimento", dto.comentario());
        assertEquals(30L, dto.idEstabelecimento());
        assertEquals(40L, dto.idProfissional());
    }
}

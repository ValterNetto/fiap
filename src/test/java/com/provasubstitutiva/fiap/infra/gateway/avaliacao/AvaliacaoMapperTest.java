package com.provasubstitutiva.fiap.infra.gateway.avaliacao;

import com.provasubstitutiva.fiap.domain.model.Avaliacao;
import com.provasubstitutiva.fiap.infra.persistence.avaliacao.AvaliacaoEntity;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AvaliacaoMapperTest {

    private final AvaliacaoMapper mapper = new AvaliacaoMapper();

    @Test
    void testToDomain() {
        AvaliacaoEntity entity = new AvaliacaoEntity(
                1L,
                10L,
                5,
                "Excelente",
                20L,
                null
        );

        Avaliacao domain = mapper.toDomain(entity);

        assertEquals(entity.getId(), domain.getId());
        assertEquals(entity.getIdCliente(), domain.getIdCliente());
        assertEquals(entity.getEstrelas(), domain.getEstrelas());
        assertEquals(entity.getComentario(), domain.getComentario());
        assertEquals(entity.getIdEstabelecimento(), domain.getIdEstabelecimento());
        assertEquals(entity.getIdProfissional(), domain.getIdProfissional());
    }

    @Test
    void testToEntity() {
        Avaliacao domain = new Avaliacao(
                2L,
                11L,
                4,
                "Bom atendimento",
                21L,
                null
        );

        AvaliacaoEntity entity = mapper.toEntity(domain);

        assertEquals(domain.getId(), entity.getId());
        assertEquals(domain.getIdCliente(), entity.getIdCliente());
        assertEquals(domain.getEstrelas(), entity.getEstrelas());
        assertEquals(domain.getComentario(), entity.getComentario());
        assertEquals(domain.getIdEstabelecimento(), entity.getIdEstabelecimento());
        assertEquals(domain.getIdProfissional(), entity.getIdProfissional());
    }
}

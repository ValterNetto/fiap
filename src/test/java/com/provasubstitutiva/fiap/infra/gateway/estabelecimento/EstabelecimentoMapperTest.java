package com.provasubstitutiva.fiap.infra.gateway.estabelecimento;

import com.provasubstitutiva.fiap.domain.model.Estabelecimento;
import com.provasubstitutiva.fiap.infra.persistence.estabelecimento.EstabelecimentoEntity;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EstabelecimentoMapperTest {

    private final EstabelecimentoMapper mapper = new EstabelecimentoMapper();

    @Test
    void testToDomain() {
        EstabelecimentoEntity entity = new EstabelecimentoEntity(
                1L,
                "Studio Hair",
                50L,
                "studio@hair.com"
        );

        Estabelecimento domain = mapper.toDomain(entity);

        assertEquals(entity.getId(), domain.getId());
        assertEquals(entity.getNome(), domain.getNome());
        assertEquals(entity.getIdEndereco(), domain.getIdEndereco());
        assertEquals(entity.getEmail(), domain.getEmail());
    }

    @Test
    void testToEntity() {
        Estabelecimento domain = new Estabelecimento(
                2L,
                "Barbearia Central",
                60L,
                "barbearia@central.com"
        );

        EstabelecimentoEntity entity = mapper.toEntity(domain);

        assertEquals(domain.getId(), entity.getId());
        assertEquals(domain.getNome(), entity.getNome());
        assertEquals(domain.getIdEndereco(), entity.getIdEndereco());
        assertEquals(domain.getEmail(), entity.getEmail());
    }
}

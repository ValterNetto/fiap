package com.provasubstitutiva.fiap.infra.gateway.profissional;

import com.provasubstitutiva.fiap.domain.model.Profissional;
import com.provasubstitutiva.fiap.infra.persistence.profissional.ProfissionalEntity;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProfissionalMapperTest {

    private final ProfissionalMapper mapper = new ProfissionalMapper();

    @Test
    void testToDomain() {
        ProfissionalEntity entity = new ProfissionalEntity(
                1L,
                "Júlia",
                "julia@email.com",
                "Designer de Sobrancelhas",
                120,
                10L
        );

        Profissional domain = mapper.toDomain(entity);

        assertEquals(entity.getId(), domain.getId());
        assertEquals(entity.getNome(), domain.getNome());
        assertEquals(entity.getEmail(), domain.getEmail());
        assertEquals(entity.getEspecialidade(), domain.getEspecialidade());
        assertEquals(entity.getTarifaPorHora(), domain.getTarifaPorHora());
        assertEquals(entity.getIdEstabelecimento(), domain.getIdEstabelecimento());
    }

    @Test
    void testToEntity() {
        Profissional domain = new Profissional(
                2L,
                "Roberto",
                "roberto@email.com",
                "Barbeiro",
                150,
                20L
        );

        ProfissionalEntity entity = mapper.toEntity(domain);

        assertEquals(domain.getId(), entity.getId());
        assertEquals(domain.getNome(), entity.getNome());
        assertEquals(domain.getEmail(), entity.getEmail());
        assertEquals(domain.getEspecialidade(), entity.getEspecialidade());
        assertEquals(domain.getTarifaPorHora(), entity.getTarifaPorHora());
        assertEquals(domain.getIdEstabelecimento(), entity.getIdEstabelecimento());
    }
}

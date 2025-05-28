package com.provasubstitutiva.fiap.infra.gateway.horario;

import com.provasubstitutiva.fiap.domain.model.Horario;
import com.provasubstitutiva.fiap.domain.model.constant.DiasDaSemanaEnum;
import com.provasubstitutiva.fiap.infra.persistence.horario.HorarioEntity;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

class HorarioMapperTest {

    private final HorarioMapper mapper = new HorarioMapper();

    @Test
    void testToDomain() {
        HorarioEntity entity = new HorarioEntity(
                1L,
                DiasDaSemanaEnum.TUESDAY,
                LocalTime.of(8, 0),
                LocalTime.of(17, 0),
                99L
        );

        Horario domain = mapper.toDomain(entity);

        assertEquals(entity.getId(), domain.getId());
        assertEquals(entity.getDiaDaSemana(), domain.getDiaDaSemana());
        assertEquals(entity.getInicio(), domain.getInicio());
        assertEquals(entity.getFim(), domain.getFim());
        assertEquals(entity.getIdEstabelecimento(), domain.getIdEstabelecimento());
    }

    @Test
    void testToEntity() {
        Horario domain = new Horario(
                2L,
                DiasDaSemanaEnum.THURSDAY,
                LocalTime.of(10, 0),
                LocalTime.of(18, 0),
                88L
        );

        HorarioEntity entity = mapper.toEntity(domain);

        assertEquals(domain.getId(), entity.getId());
        assertEquals(domain.getDiaDaSemana(), entity.getDiaDaSemana());
        assertEquals(domain.getInicio(), entity.getInicio());
        assertEquals(domain.getFim(), entity.getFim());
        assertEquals(domain.getIdEstabelecimento(), entity.getIdEstabelecimento());
    }
}

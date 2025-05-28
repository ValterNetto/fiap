package com.provasubstitutiva.fiap.infra.persistence.horario;

import com.provasubstitutiva.fiap.domain.model.constant.DiasDaSemanaEnum;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

class HorarioEntityTest {

    @Test
    void testAllArgsConstructorAndGetters() {
        HorarioEntity entity = new HorarioEntity(
                1L,
                DiasDaSemanaEnum.MONDAY,
                LocalTime.of(9, 0),
                LocalTime.of(18, 0),
                101L
        );

        assertEquals(1L, entity.getId());
        assertEquals(DiasDaSemanaEnum.MONDAY, entity.getDiaDaSemana());
        assertEquals(LocalTime.of(9, 0), entity.getInicio());
        assertEquals(LocalTime.of(18, 0), entity.getFim());
        assertEquals(101L, entity.getIdEstabelecimento());
    }

    @Test
    void testSettersAndNoArgsConstructor() {
        HorarioEntity entity = new HorarioEntity();

        entity.setId(2L);
        entity.setDiaDaSemana(DiasDaSemanaEnum.WEDNESDAY);
        entity.setInicio(LocalTime.of(10, 0));
        entity.setFim(LocalTime.of(17, 0));
        entity.setIdEstabelecimento(202L);

        assertEquals(2L, entity.getId());
        assertEquals(DiasDaSemanaEnum.WEDNESDAY, entity.getDiaDaSemana());
        assertEquals(LocalTime.of(10, 0), entity.getInicio());
        assertEquals(LocalTime.of(17, 0), entity.getFim());
        assertEquals(202L, entity.getIdEstabelecimento());
    }
}

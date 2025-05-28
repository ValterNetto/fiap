package com.provasubstitutiva.fiap.domain.model;

import com.provasubstitutiva.fiap.domain.model.constant.DiasDaSemanaEnum;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

class HorarioTest {

    @Test
    void deveCriarHorarioComTodosOsCampos() {
        Horario horario = new Horario(
                1L,
                DiasDaSemanaEnum.WEDNESDAY,
                LocalTime.of(8, 0),
                LocalTime.of(17, 0),
                10L
        );

        assertEquals(1L, horario.getId());
        assertEquals(DiasDaSemanaEnum.WEDNESDAY, horario.getDiaDaSemana());
        assertEquals(LocalTime.of(8, 0), horario.getInicio());
        assertEquals(LocalTime.of(17, 0), horario.getFim());
        assertEquals(10L, horario.getIdEstabelecimento());
    }

    @Test
    void devePermitirSettersEAcessarComGetters() {
        Horario horario = new Horario();
        horario.setId(2L);
        horario.setDiaDaSemana(DiasDaSemanaEnum.FRIDAY);
        horario.setInicio(LocalTime.of(9, 30));
        horario.setFim(LocalTime.of(18, 0));
        horario.setIdEstabelecimento(20L);

        assertEquals(2L, horario.getId());
        assertEquals(DiasDaSemanaEnum.FRIDAY, horario.getDiaDaSemana());
        assertEquals(LocalTime.of(9, 30), horario.getInicio());
        assertEquals(LocalTime.of(18, 0), horario.getFim());
        assertEquals(20L, horario.getIdEstabelecimento());
    }
}

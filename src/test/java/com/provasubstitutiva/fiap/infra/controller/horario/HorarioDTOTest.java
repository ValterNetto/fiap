package com.provasubstitutiva.fiap.infra.controller.horario;

import com.provasubstitutiva.fiap.domain.model.Horario;
import com.provasubstitutiva.fiap.domain.model.constant.DiasDaSemanaEnum;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

class HorarioDTOTest {

    @Test
    void testConstrutorComHorario() {
        Horario horario = new Horario(1L, DiasDaSemanaEnum.WEDNESDAY, LocalTime.of(9, 0), LocalTime.of(18, 0), 50L);
        HorarioDTO dto = new HorarioDTO(horario);

        assertEquals(1L, dto.id());
        assertEquals(DiasDaSemanaEnum.WEDNESDAY, dto.diaDaSemana());
        assertEquals(LocalTime.of(9, 0), dto.inicio());
        assertEquals(LocalTime.of(18, 0), dto.fim());
        assertEquals(50L, dto.idEstabelecimento());
    }

    @Test
    void testConstrutorDireto() {
        HorarioDTO dto = new HorarioDTO(2L, DiasDaSemanaEnum.FRIDAY, LocalTime.of(10, 30), LocalTime.of(16, 0), 60L);

        assertEquals(2L, dto.id());
        assertEquals(DiasDaSemanaEnum.FRIDAY, dto.diaDaSemana());
        assertEquals(LocalTime.of(10, 30), dto.inicio());
        assertEquals(LocalTime.of(16, 0), dto.fim());
        assertEquals(60L, dto.idEstabelecimento());
    }
}

package com.provasubstitutiva.fiap.infra.persistence.agendamento;

import com.provasubstitutiva.fiap.domain.model.constant.StatusEnum;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

class AgendamentoEntityTest {

    @Test
    void testAllArgsConstructorAndGetters() {
        LocalDate data = LocalDate.of(2025, 6, 1);
        LocalTime inicio = LocalTime.of(14, 0);
        LocalTime fim = LocalTime.of(15, 0);

        AgendamentoEntity entity = new AgendamentoEntity(
                1L, 2L, 3L, 4L, 5L,
                StatusEnum.AGENDADO,
                data,
                inicio,
                fim
        );

        assertEquals(1L, entity.getId());
        assertEquals(2L, entity.getIdProfissional());
        assertEquals(3L, entity.getIdEstabelecimento());
        assertEquals(4L, entity.getIdCliente());
        assertEquals(5L, entity.getIdServico());
        assertEquals(StatusEnum.AGENDADO, entity.getStatus());
        assertEquals(data, entity.getData());
        assertEquals(inicio, entity.getHoraInicio());
        assertEquals(fim, entity.getHoraTermino());
    }

    @Test
    void testSettersAndNoArgsConstructor() {
        AgendamentoEntity entity = new AgendamentoEntity();

        entity.setId(10L);
        entity.setIdProfissional(20L);
        entity.setIdEstabelecimento(30L);
        entity.setIdCliente(40L);
        entity.setIdServico(50L);
        entity.setStatus(StatusEnum.CANCELADO);
        entity.setData(LocalDate.of(2025, 1, 1));
        entity.setHoraInicio(LocalTime.of(8, 0));
        entity.setHoraTermino(LocalTime.of(9, 0));

        assertEquals(10L, entity.getId());
        assertEquals(20L, entity.getIdProfissional());
        assertEquals(30L, entity.getIdEstabelecimento());
        assertEquals(40L, entity.getIdCliente());
        assertEquals(50L, entity.getIdServico());
        assertEquals(StatusEnum.CANCELADO, entity.getStatus());
        assertEquals(LocalDate.of(2025, 1, 1), entity.getData());
        assertEquals(LocalTime.of(8, 0), entity.getHoraInicio());
        assertEquals(LocalTime.of(9, 0), entity.getHoraTermino());
    }
}

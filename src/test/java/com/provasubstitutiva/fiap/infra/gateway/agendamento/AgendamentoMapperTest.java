package com.provasubstitutiva.fiap.infra.gateway.agendamento;

import com.provasubstitutiva.fiap.domain.model.Agendamento;
import com.provasubstitutiva.fiap.domain.model.constant.StatusEnum;
import com.provasubstitutiva.fiap.infra.persistence.agendamento.AgendamentoEntity;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AgendamentoMapperTest {

    private final AgendamentoMapper mapper = new AgendamentoMapper();

    @Test
    void testToDomain() {
        AgendamentoEntity entity = new AgendamentoEntity(
                1L,
                2L,
                3L,
                4L,
                5L,
                StatusEnum.AGENDADO,
                LocalDate.of(2025, 5, 30),
                LocalTime.of(9, 0),
                LocalTime.of(10, 0)
        );

        Agendamento domain = mapper.toDomain(entity);

        assertEquals(entity.getId(), domain.getId());
        assertEquals(entity.getIdProfissional(), domain.getIdProfissional());
        assertEquals(entity.getIdEstabelecimento(), domain.getIdEstabelecimento());
        assertEquals(entity.getIdCliente(), domain.getIdCliente());
        assertEquals(entity.getIdServico(), domain.getIdServico());
        assertEquals(entity.getStatus(), domain.getStatus());
        assertEquals(entity.getData(), domain.getData());
        assertEquals(entity.getHoraInicio(), domain.getHoraInicio());
        assertEquals(entity.getHoraTermino(), domain.getHoraTermino());
    }

    @Test
    void testToEntity() {
        Agendamento domain = new Agendamento(
                10L,
                20L,
                30L,
                40L,
                50L,
                StatusEnum.CANCELADO,
                LocalDate.of(2025, 12, 1),
                LocalTime.of(14, 30),
                LocalTime.of(15, 30)
        );

        AgendamentoEntity entity = mapper.toEntity(domain);

        assertEquals(domain.getId(), entity.getId());
        assertEquals(domain.getIdProfissional(), entity.getIdProfissional());
        assertEquals(domain.getIdEstabelecimento(), entity.getIdEstabelecimento());
        assertEquals(domain.getIdCliente(), entity.getIdCliente());
        assertEquals(domain.getIdServico(), entity.getIdServico());
        assertEquals(domain.getStatus(), entity.getStatus());
        assertEquals(domain.getData(), entity.getData());
        assertEquals(domain.getHoraInicio(), entity.getHoraInicio());
        assertEquals(domain.getHoraTermino(), entity.getHoraTermino());
    }
}

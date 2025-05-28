package com.provasubstitutiva.fiap.domain.model;

import com.provasubstitutiva.fiap.domain.model.constant.StatusEnum;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

class AgendamentoTest {

    @Test
    void deveConstruirAgendamentoComTodosOsCampos() {
        Long id = 1L;
        Long idProf = 2L;
        Long idEstab = 3L;
        Long idCliente = 4L;
        Long idServico = 5L;
        StatusEnum status = StatusEnum.AGENDADO;
        LocalDate data = LocalDate.now();
        LocalTime inicio = LocalTime.of(9, 0);
        LocalTime fim = LocalTime.of(10, 0);

        Agendamento agendamento = new Agendamento(id, idProf, idEstab, idCliente, idServico, status, data, inicio, fim);

        assertEquals(id, agendamento.getId());
        assertEquals(idProf, agendamento.getIdProfissional());
        assertEquals(idEstab, agendamento.getIdEstabelecimento());
        assertEquals(idCliente, agendamento.getIdCliente());
        assertEquals(idServico, agendamento.getIdServico());
        assertEquals(status, agendamento.getStatus());
        assertEquals(data, agendamento.getData());
        assertEquals(inicio, agendamento.getHoraInicio());
        assertEquals(fim, agendamento.getHoraTermino());
    }

    @Test
    void deveSetarValoresCorretamente() {
        Agendamento agendamento = new Agendamento();

        agendamento.setId(1L);
        agendamento.setIdProfissional(2L);
        agendamento.setIdEstabelecimento(3L);
        agendamento.setIdCliente(4L);
        agendamento.setIdServico(5L);
        agendamento.setStatus(StatusEnum.CONCLUIDO);
        agendamento.setData(LocalDate.of(2024, 5, 20));
        agendamento.setHoraInicio(LocalTime.of(14, 30));
        agendamento.setHoraTermino(LocalTime.of(15, 30));

        assertEquals(1L, agendamento.getId());
        assertEquals(2L, agendamento.getIdProfissional());
        assertEquals(3L, agendamento.getIdEstabelecimento());
        assertEquals(4L, agendamento.getIdCliente());
        assertEquals(5L, agendamento.getIdServico());
        assertEquals(StatusEnum.CONCLUIDO, agendamento.getStatus());
        assertEquals(LocalDate.of(2024, 5, 20), agendamento.getData());
        assertEquals(LocalTime.of(14, 30), agendamento.getHoraInicio());
        assertEquals(LocalTime.of(15, 30), agendamento.getHoraTermino());
    }
}

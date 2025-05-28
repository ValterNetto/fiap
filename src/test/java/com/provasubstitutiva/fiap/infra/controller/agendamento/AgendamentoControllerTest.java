package com.provasubstitutiva.fiap.infra.controller.agendamento;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.provasubstitutiva.fiap.application.usecase.agendamento.impl.BuscarAgendamentosPorProfissionalEDiaImpl;
import com.provasubstitutiva.fiap.application.usecase.agendamento.impl.CancelarAgendamentoImpl;
import com.provasubstitutiva.fiap.application.usecase.agendamento.impl.RealizarAgendamentoImpl;
import com.provasubstitutiva.fiap.domain.model.Agendamento;
import com.provasubstitutiva.fiap.domain.model.constant.StatusEnum;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

class AgendamentoControllerTest {

    private MockMvc mockMvc;
    private BuscarAgendamentosPorProfissionalEDiaImpl buscarUseCase;
    private CancelarAgendamentoImpl cancelarUseCase;
    private RealizarAgendamentoImpl realizarUseCase;
    private ObjectMapper objectMapper = new ObjectMapper();

    @BeforeEach
    void setUp() {
        buscarUseCase = mock(BuscarAgendamentosPorProfissionalEDiaImpl.class);
        cancelarUseCase = mock(CancelarAgendamentoImpl.class);
        realizarUseCase = mock(RealizarAgendamentoImpl.class);
        AgendamentoController controller = new AgendamentoController(
                buscarUseCase, cancelarUseCase, realizarUseCase
        );
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();

        objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
    }

    @Test
    void deveBuscarAgendamentosPorProfissional() throws Exception {
        Agendamento ag = new Agendamento(
                1L, 2L, 3L, 4L, 5L,
                StatusEnum.AGENDADO,
                LocalDate.of(2025,5,27),
                LocalTime.of(9,0),
                LocalTime.of(10,0)
        );
        when(buscarUseCase.buscarAgendamentos(eq(2L), any(LocalDate.class)))
                .thenReturn(List.of(ag));

        LocalDate date = LocalDate.of(2025,5,27);
        mockMvc.perform(get("/agendamentos/profissional/2")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(date)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].idProfissional").value(2))
                .andExpect(jsonPath("$[0].status").value("AGENDADO"));

        verify(buscarUseCase).buscarAgendamentos(eq(2L), eq(date));
    }

    @Test
    void deveCancelarAgendamento() throws Exception {
        Agendamento ag = new Agendamento();
        ag.setId(10L);
        when(cancelarUseCase.cancelar(10L)).thenReturn(ag);

        mockMvc.perform(delete("/agendamentos/cancelar/10"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(10));

        verify(cancelarUseCase).cancelar(10L);
    }

    @Test
    void deveAgendar() throws Exception {
        AgendamentoDTO dto = new AgendamentoDTO(
                11L, 2L, 3L, 4L, 5L,
                StatusEnum.AGENDADO,
                LocalDate.of(2025,5,27),
                LocalTime.of(14,0),
                LocalTime.of(15,0)
        );
        Agendamento domain = new Agendamento(
                dto.id(), dto.idProfissional(), dto.idEstabelecimento(),
                dto.idCliente(), dto.idServico(), dto.status(),
                dto.data(), dto.horaInicio(), dto.horaTermino()
        );
        when(realizarUseCase.realizarAgendamento(any(Agendamento.class)))
                .thenReturn(domain);

        mockMvc.perform(post("/agendamentos")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(dto)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(11))
                .andExpect(jsonPath("$.status").value("AGENDADO"));

        verify(realizarUseCase).realizarAgendamento(argThat(a ->
                a.getId().equals(11L) && a.getStatus() == StatusEnum.AGENDADO
        ));
    }
}

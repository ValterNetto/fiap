package com.provasubstitutiva.fiap.infra.controller.horario;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.provasubstitutiva.fiap.application.usecase.horario.impl.BuscarHorariosPorIdEstabelecimentoImpl;
import com.provasubstitutiva.fiap.application.usecase.horario.impl.CadastrarHorarioImpl;
import com.provasubstitutiva.fiap.application.usecase.horario.impl.ExcluirHorarioImpl;
import com.provasubstitutiva.fiap.domain.model.Horario;
import com.provasubstitutiva.fiap.domain.model.constant.DiasDaSemanaEnum;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalTime;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(HorarioController.class)
class HorarioControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BuscarHorariosPorIdEstabelecimentoImpl buscarHorariosPorIdEstabelecimento;

    @MockBean
    private CadastrarHorarioImpl cadastrarHorario;

    @MockBean
    private ExcluirHorarioImpl excluirHorario;

    @Autowired
    private ObjectMapper objectMapper;

    private Horario getHorario() {
        return new Horario(1L, DiasDaSemanaEnum.MONDAY, LocalTime.of(8, 0), LocalTime.of(17, 0), 10L);
    }

    private HorarioDTO getDTO() {
        return new HorarioDTO(1L, DiasDaSemanaEnum.MONDAY, LocalTime.of(8, 0), LocalTime.of(17, 0), 10L);
    }

    @Test
    void testBuscarPorEstabelecimento() throws Exception {
        Mockito.when(buscarHorariosPorIdEstabelecimento.buscarHorariosPorIdEstabelecimento(10L))
                .thenReturn(List.of(getHorario()));

        mockMvc.perform(get("/horarios/estabelecimentos/10"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].diaDaSemana").value("MONDAY"))
                .andExpect(jsonPath("$[0].idEstabelecimento").value(10L));
    }

    @Test
    void testCadastrarHorario() throws Exception {
        Mockito.when(cadastrarHorario.cadastraHorario(any())).thenReturn(getHorario());

        mockMvc.perform(post("/horarios")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(getDTO())))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.inicio").value("08:00:00"))
                .andExpect(jsonPath("$.fim").value("17:00:00"));
    }

    @Test
    void testDeletarHorario() throws Exception {
        mockMvc.perform(delete("/horarios/1"))
                .andExpect(status().isOk());

        Mockito.verify(excluirHorario).excluirHorario(1L);
    }
}

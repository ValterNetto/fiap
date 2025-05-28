package com.provasubstitutiva.fiap.infra.controller.profissional;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.provasubstitutiva.fiap.application.usecase.profissional.impl.AdmitirProfissionalImpl;
import com.provasubstitutiva.fiap.application.usecase.profissional.impl.BuscarProfissionalPorIdImpl;
import com.provasubstitutiva.fiap.application.usecase.profissional.impl.DemitirProfissionalImpl;
import com.provasubstitutiva.fiap.application.usecase.profissional.impl.RegistrarProfissionalImpl;
import com.provasubstitutiva.fiap.domain.model.Profissional;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ProfissionalController.class)
class ProfissionalControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AdmitirProfissionalImpl admitirProfissional;

    @MockBean
    private BuscarProfissionalPorIdImpl buscarProfissionalPorId;

    @MockBean
    private DemitirProfissionalImpl demitirProfissional;

    @MockBean
    private RegistrarProfissionalImpl registrarProfissional;

    @Autowired
    private ObjectMapper objectMapper;

    private Profissional getProfissional() {
        return new Profissional(1L, "João", "joao@email.com", "Cabelereiro", 150, 2L);
    }

    private ProfissionalDTO getDTO() {
        return new ProfissionalDTO(1L, "João", "joao@email.com", "Cabelereiro", 150, 2L);
    }

    @Test
    void testAdmitirProfissional() throws Exception {
        Mockito.when(admitirProfissional.admitirProfissional(1L, 2L)).thenReturn(getProfissional());

        mockMvc.perform(put("/profissionais/admitir")
                        .param("idProfissional", "1")
                        .param("idEstabelecimento", "2"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nome").value("João"))
                .andExpect(jsonPath("$.idEstabelecimento").value(2));
    }

    @Test
    void testBuscarProfissionalPorId() throws Exception {
        Mockito.when(buscarProfissionalPorId.buscarPorIdProfissional(1L)).thenReturn(getProfissional());

        mockMvc.perform(get("/profissionais/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.email").value("joao@email.com"));
    }

    @Test
    void testDemitirProfissional() throws Exception {
        Mockito.when(demitirProfissional.demitir(1L)).thenReturn(getProfissional());

        mockMvc.perform(put("/profissionais/demitir")
                        .param("idProfissional", "1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.especialidade").value("Cabelereiro"));
    }

    @Test
    void testRegistrarProfissional() throws Exception {
        Mockito.when(registrarProfissional.registrarProfissional(any())).thenReturn(getProfissional());

        mockMvc.perform(post("/profissionais")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(getDTO())))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.tarifaPorHora").value(150.00));
    }
}

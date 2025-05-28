package com.provasubstitutiva.fiap.infra.controller.estabelecimento;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.provasubstitutiva.fiap.application.usecase.estabelecimento.impl.*;
import com.provasubstitutiva.fiap.domain.model.Estabelecimento;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.ArgumentMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(EstabelecimentoController.class)
class EstabelecimentoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BuscarEstabelecimentoPorIdImpl buscarEstabelecimentoPorId;

    @MockBean
    private EditarEstabelecimentoPorIdImpl editarEstabelecimentoPorId;

    @MockBean
    private FiltragemBuscarEstabelecimentosPorEstrelasImpl filtragemBuscarEstabelecimentosPorEstrelas;

    @MockBean
    private FiltragemBuscarEstabelecimentosPorLatitudeELongitudeImpl filtragemBuscarEstabelecimentosPorLatitudeELongitude;

    @MockBean
    private FiltragemBuscarEstabelecimentosPorNomeImpl filtragemBuscarEstabelecimentosPorNome;

    @MockBean
    private FiltragemBuscarEstabelecimentosPorServicoImpl filtragemBuscarEstabelecimentosPorServico;

    @MockBean
    private RegistrarEstabelecimentoImpl registrarEstabelecimento;

    @Autowired
    private ObjectMapper objectMapper;

    private Estabelecimento getEstabelecimento() {
        return new Estabelecimento(1L, "Salão Bela", 100L, "contato@bela.com");
    }

    private EstabelecimentoDTO getDTO() {
        return new EstabelecimentoDTO(1L, "Salão Bela", 100L, "contato@bela.com");
    }

    @Test
    void testBuscarPorId() throws Exception {
        Mockito.when(buscarEstabelecimentoPorId.buscarEstabelecimentoPorId(1L)).thenReturn(getEstabelecimento());

        mockMvc.perform(get("/estabelecimentos/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nome").value("Salão Bela"));
    }

    @Test
    void testEditarEstabelecimento() throws Exception {
        Mockito.when(editarEstabelecimentoPorId.editarEstabelecimento(any())).thenReturn(getEstabelecimento());

        mockMvc.perform(put("/estabelecimentos")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(getDTO())))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.email").value("contato@bela.com"));
    }

    @Test
    void testFiltragemPorEstrelas() throws Exception {
        Mockito.when(filtragemBuscarEstabelecimentosPorEstrelas.listaEstabelecimentosPorEstrelas(5))
                .thenReturn(List.of(getEstabelecimento()));

        mockMvc.perform(get("/estabelecimentos/filtro/estrelas?estrelas=5"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].idEndereco").value(100L));
    }

    @Test
    void testFiltragemPorGeolocalizacao() throws Exception {
        Mockito.when(filtragemBuscarEstabelecimentosPorLatitudeELongitude
                        .buscarEstabelecimentoPorLatitudeELongitude(anyDouble(), anyDouble(), anyInt()))
                .thenReturn(List.of(getEstabelecimento()));

        mockMvc.perform(get("/estabelecimentos/filtro/geolocalizacao")
                        .param("latitude", "-23.5")
                        .param("longitude", "-46.6")
                        .param("metros", "1000"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].nome").value("Salão Bela"));
    }

    @Test
    void testFiltragemPorNome() throws Exception {
        Mockito.when(filtragemBuscarEstabelecimentosPorNome.buscarPorNome("Salão"))
                .thenReturn(List.of(getEstabelecimento()));

        mockMvc.perform(get("/estabelecimentos/filtro/nomes?nome=Salão"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].email").value("contato@bela.com"));
    }

    @Test
    void testFiltragemPorServicos() throws Exception {
        Mockito.when(filtragemBuscarEstabelecimentosPorServico.buscarEstabelecimentosPorServico("Corte"))
                .thenReturn(List.of(getEstabelecimento()));

        mockMvc.perform(get("/estabelecimentos/filtro/servicos?nomeServico=Corte"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(1L));
    }

    @Test
    void testRegistrarEstabelecimento() throws Exception {
        Mockito.when(registrarEstabelecimento.registrarEstabelecimento(any())).thenReturn(getEstabelecimento());

        mockMvc.perform(post("/estabelecimentos")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(getDTO())))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nome").value("Salão Bela"));
    }
}

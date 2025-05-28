package com.provasubstitutiva.fiap.infra.controller.avaliacao;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.provasubstitutiva.fiap.application.usecase.avaliacao.impl.*;
import com.provasubstitutiva.fiap.domain.model.Avaliacao;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(AvaliacaoController.class)
public class AvaliacaoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AvaliarEstabelecimentoImpl avaliarEstabelecimento;

    @MockBean
    private AvaliarProfissionalImpl avaliarProfissional;

    @MockBean
    private BuscarAvaliacoesPorIdClienteImpl buscarAvaliacoesPorIdCliente;

    @MockBean
    private BuscarAvaliacoesPorIdEstabalecimentoImpl buscarAvaliacoesPorIdEstabalecimento;

    @MockBean
    private EditarAvaliacaoImpl editarAvaliacao;

    @MockBean
    private ExcluirAvaliacaoImpl excluirAvaliacao;

    @Autowired
    private ObjectMapper objectMapper;

    private Avaliacao getAvaliacaoEstabelecimento() {
        return new Avaliacao(1L, 10L, 5, "Excelente", 20L, null);
    }

    private Avaliacao getAvaliacaoProfissional() {
        return new Avaliacao(2L, 11L, 4, "Muito bom", null, 30L);
    }

    private AvaliacaoDTO getDTOEstabelecimento() {
        return new AvaliacaoDTO(1L, 10L, 5, "Excelente", 20L, null);
    }

    private AvaliacaoDTO getDTOProfissional() {
        return new AvaliacaoDTO(2L, 11L, 4, "Muito bom", null, 30L);
    }

    @Test
    void deveBuscarPorCliente() throws Exception {
        Mockito.when(buscarAvaliacoesPorIdCliente.buscarAvaliacaoPorIdCliente(10L))
                .thenReturn(List.of(getAvaliacaoEstabelecimento()));

        mockMvc.perform(get("/avaliacoes/cliente/10"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].idCliente").value(10L));
    }

    @Test
    void deveBuscarPorEstabelecimento() throws Exception {
        Mockito.when(buscarAvaliacoesPorIdEstabalecimento.buscarporIdEstabelecimento(20L))
                .thenReturn(List.of(getAvaliacaoEstabelecimento()));

        mockMvc.perform(get("/avaliacoes/estabelecimento/20"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].idEstabelecimento").value(20L));
    }

    @Test
    void deveEditarAvaliacao() throws Exception {
        Mockito.when(editarAvaliacao.editar(any())).thenReturn(getAvaliacaoEstabelecimento());

        mockMvc.perform(put("/avaliacoes/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(getDTOEstabelecimento())))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1L));
    }

    @Test
    void deveExcluirAvaliacao() throws Exception {
        mockMvc.perform(delete("/avaliacoes/1"))
                .andExpect(status().isOk());

        Mockito.verify(excluirAvaliacao).excluirAvaliacao(1L);
    }
}

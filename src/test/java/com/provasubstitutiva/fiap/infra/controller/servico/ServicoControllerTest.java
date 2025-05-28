package com.provasubstitutiva.fiap.infra.controller.servico;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.provasubstitutiva.fiap.application.usecase.servico.impl.BuscarPorIdEstabelecimentoImpl;
import com.provasubstitutiva.fiap.application.usecase.servico.impl.ExcluirServicoImpl;
import com.provasubstitutiva.fiap.application.usecase.servico.impl.RegistrarServicoImpl;
import com.provasubstitutiva.fiap.domain.model.Servico;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ServicoController.class)
class ServicoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BuscarPorIdEstabelecimentoImpl buscarPorIdEstabelecimento;

    @MockBean
    private ExcluirServicoImpl excluirServico;

    @MockBean
    private RegistrarServicoImpl registrarServico;

    @Autowired
    private ObjectMapper objectMapper;

    private Servico getServico() {
        return new Servico(1L, "Depilação", 120, 9L);
    }

    private ServicoDTO getDTO() {
        return new ServicoDTO(1L, "Depilação", 120, 9L);
    }

    @Test
    void testBuscarPorEstabelecimento() throws Exception {
        Mockito.when(buscarPorIdEstabelecimento.buscarPorIdEstabelecimento(9L))
                .thenReturn(List.of(getServico()));

        mockMvc.perform(get("/servicos/estabelecimento/9"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].nome").value("Depilação"))
                .andExpect(jsonPath("$[0].valor").value(120.00));
    }

    @Test
    void testExcluirServico() throws Exception {
        mockMvc.perform(delete("/servicos/1"))
                .andExpect(status().isOk());

        Mockito.verify(excluirServico).cancelar(1L);
    }
}

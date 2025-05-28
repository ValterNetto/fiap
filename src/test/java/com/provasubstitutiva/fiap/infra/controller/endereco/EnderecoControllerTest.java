package com.provasubstitutiva.fiap.infra.controller.endereco;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.provasubstitutiva.fiap.application.usecase.endereco.impl.BuscarEnderecoPorIdEstabelecimentoImpl;
import com.provasubstitutiva.fiap.application.usecase.endereco.impl.BuscarEnderecoPorIdImpl;
import com.provasubstitutiva.fiap.application.usecase.endereco.impl.EditarEnderecoImpl;
import com.provasubstitutiva.fiap.application.usecase.endereco.impl.RegistrarEnderecoImpl;
import com.provasubstitutiva.fiap.domain.model.Endereco;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(EnderecoController.class)
class EnderecoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BuscarEnderecoPorIdEstabelecimentoImpl buscarEnderecoPorIdEstabelecimento;

    @MockBean
    private BuscarEnderecoPorIdImpl buscarEnderecoPorId;

    @MockBean
    private EditarEnderecoImpl editarEndereco;

    @MockBean
    private RegistrarEnderecoImpl registrarEndereco;

    @Autowired
    private ObjectMapper objectMapper;

    private Endereco getEndereco() {
        return new Endereco(1L, "Rua A", "12345-678", "10", -23.5, -46.6, 99L);
    }

    private EnderecoDTO getDTO() {
        return new EnderecoDTO(1L, "Rua A", "12345-678", "10", -23.5, -46.6, 99L);
    }

    @Test
    void testBuscarEnderecoPorIdEstabelecimento() throws Exception {
        Mockito.when(buscarEnderecoPorIdEstabelecimento.buscarPorIdEstabelecimento(99L)).thenReturn(getEndereco());

        mockMvc.perform(get("/enderecos/estabelecimento/99"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.logradouro").value("Rua A"));
    }

    @Test
    void testBuscarEnderecoPorId() throws Exception {
        Mockito.when(buscarEnderecoPorId.buscarEnderecoPorId(1L)).thenReturn(getEndereco());

        mockMvc.perform(get("/enderecos/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1L));
    }

    @Test
    void testEditarEndereco() throws Exception {
        Mockito.when(editarEndereco.editarEndereco(any())).thenReturn(getEndereco());

        mockMvc.perform(put("/enderecos")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(getDTO())))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.cep").value("12345-678"));
    }

    @Test
    void testRegistrarEndereco() throws Exception {
        Mockito.when(registrarEndereco.registrarEndereco(any())).thenReturn(getEndereco());

        mockMvc.perform(post("/enderecos")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(getDTO())))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.idEstabelecimento").value(99L));
    }
}

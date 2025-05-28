package com.provasubstitutiva.fiap.infra.controller.cliente;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.provasubstitutiva.fiap.application.usecase.cliente.impl.BuscarClientePorIdImpl;
import com.provasubstitutiva.fiap.application.usecase.cliente.impl.EditarClienteImpl;
import com.provasubstitutiva.fiap.application.usecase.cliente.impl.RegistrarClienteImpl;
import com.provasubstitutiva.fiap.domain.model.Cliente;
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

@WebMvcTest(ClienteController.class)
class ClienteControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BuscarClientePorIdImpl buscarClientePorId;

    @MockBean
    private EditarClienteImpl editarCliente;

    @MockBean
    private RegistrarClienteImpl registrarCliente;

    @Autowired
    private ObjectMapper objectMapper;

    private Cliente getCliente() {
        return new Cliente(1L, "Maria", "maria@email.com");
    }

    private ClienteDTO getDTO() {
        return new ClienteDTO(1L, "Maria", "maria@email.com");
    }

    @Test
    void testBuscarClientePorId() throws Exception {
        Mockito.when(buscarClientePorId.buscarClientePorId(1L)).thenReturn(getCliente());

        mockMvc.perform(get("/clientes/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.nome").value("Maria"))
                .andExpect(jsonPath("$.email").value("maria@email.com"));
    }

    @Test
    void testEditarCliente() throws Exception {
        Mockito.when(editarCliente.editar(any())).thenReturn(getCliente());

        mockMvc.perform(put("/clientes")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(getDTO())))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nome").value("Maria"));
    }

    @Test
    void testRegistrarCliente() throws Exception {
        Mockito.when(registrarCliente.registrarCliente(any())).thenReturn(getCliente());

        mockMvc.perform(post("/clientes")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(getDTO())))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.email").value("maria@email.com"));
    }
}

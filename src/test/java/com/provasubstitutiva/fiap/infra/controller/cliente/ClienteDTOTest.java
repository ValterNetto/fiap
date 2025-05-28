package com.provasubstitutiva.fiap.infra.controller.cliente;

import com.provasubstitutiva.fiap.domain.model.Cliente;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClienteDTOTest {

    @Test
    void testConstrutorComCliente() {
        Cliente cliente = new Cliente(1L, "Ana", "ana@email.com");
        ClienteDTO dto = new ClienteDTO(cliente);

        assertEquals(1L, dto.id());
        assertEquals("Ana", dto.nome());
        assertEquals("ana@email.com", dto.email());
    }

    @Test
    void testConstrutorDireto() {
        ClienteDTO dto = new ClienteDTO(2L, "Carlos", "carlos@email.com");

        assertEquals(2L, dto.id());
        assertEquals("Carlos", dto.nome());
        assertEquals("carlos@email.com", dto.email());
    }
}

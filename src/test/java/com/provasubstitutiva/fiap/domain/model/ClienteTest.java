package com.provasubstitutiva.fiap.domain.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClienteTest {

    @Test
    void deveCriarClienteComTodosOsCampos() {
        Cliente cliente = new Cliente(1L, "Ana", "ana@email.com");

        assertEquals(1L, cliente.getId());
        assertEquals("Ana", cliente.getNome());
        assertEquals("ana@email.com", cliente.getEmail());
    }

    @Test
    void devePermitirSettersEAcessarValoresComGetters() {
        Cliente cliente = new Cliente();
        cliente.setId(2L);
        cliente.setNome("Bruno");
        cliente.setEmail("bruno@email.com");

        assertEquals(2L, cliente.getId());
        assertEquals("Bruno", cliente.getNome());
        assertEquals("bruno@email.com", cliente.getEmail());
    }
}

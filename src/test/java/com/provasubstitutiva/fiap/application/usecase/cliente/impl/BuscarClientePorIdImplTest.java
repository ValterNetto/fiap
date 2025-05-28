package com.provasubstitutiva.fiap.application.usecase.cliente.impl;

import com.provasubstitutiva.fiap.application.usecase.cliente.BuscarClientePorId;
import com.provasubstitutiva.fiap.domain.model.Cliente;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class BuscarClientePorIdImplTest {

    private BuscarClientePorId buscarGateway;
    private BuscarClientePorIdImpl useCase;

    @BeforeEach
    void setUp() {
        buscarGateway = mock(BuscarClientePorId.class);
        useCase = new BuscarClientePorIdImpl(buscarGateway);
    }

    @Test
    void deveRetornarClienteQuandoEncontrado() {
        Cliente cliente = new Cliente();
        cliente.setId(1L);

        when(buscarGateway.buscarClientePorId(1L)).thenReturn(cliente);

        Cliente resultado = useCase.buscarClientePorId(1L);

        assertEquals(1L, resultado.getId());
        verify(buscarGateway, times(1)).buscarClientePorId(1L);
    }

    @Test
    void deveLancarExcecaoQuandoClienteNaoEncontrado() {
        when(buscarGateway.buscarClientePorId(1L)).thenReturn(null);

        assertThrows(NoSuchElementException.class, () -> useCase.buscarClientePorId(1L));
        verify(buscarGateway, times(1)).buscarClientePorId(1L);
    }
}

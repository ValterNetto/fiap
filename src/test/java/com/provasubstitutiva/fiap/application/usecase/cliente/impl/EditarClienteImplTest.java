package com.provasubstitutiva.fiap.application.usecase.cliente.impl;

import com.provasubstitutiva.fiap.application.usecase.cliente.BuscarClientePorId;
import com.provasubstitutiva.fiap.application.usecase.cliente.EditarCliente;
import com.provasubstitutiva.fiap.domain.model.Cliente;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class EditarClienteImplTest {

    private EditarCliente editarGateway;
    private BuscarClientePorId buscarGateway;
    private EditarClienteImpl useCase;

    @BeforeEach
    void setUp() {
        editarGateway = mock(EditarCliente.class);
        buscarGateway = mock(BuscarClientePorId.class);
        useCase = new EditarClienteImpl(editarGateway, buscarGateway);
    }

    @Test
    void deveEditarClienteQuandoValido() {
        Cliente cliente = new Cliente();
        cliente.setId(1L);

        when(buscarGateway.buscarClientePorId(1L)).thenReturn(cliente);
        when(editarGateway.editarCliente(cliente)).thenReturn(cliente);

        Cliente resultado = useCase.editar(cliente);

        assertEquals(1L, resultado.getId());
        verify(editarGateway, times(1)).editarCliente(cliente);
    }

    @Test
    void deveLancarExcecaoQuandoIdForNulo() {
        Cliente cliente = new Cliente();
        cliente.setId(null);

        assertThrows(IllegalStateException.class, () -> useCase.editar(cliente));
        verifyNoInteractions(buscarGateway, editarGateway);
    }

    @Test
    void deveLancarExcecaoQuandoClienteNaoEncontrado() {
        Cliente cliente = new Cliente();
        cliente.setId(1L);

        when(buscarGateway.buscarClientePorId(1L)).thenReturn(null);

        assertThrows(NoSuchElementException.class, () -> useCase.editar(cliente));
        verify(editarGateway, never()).editarCliente(any());
    }
}

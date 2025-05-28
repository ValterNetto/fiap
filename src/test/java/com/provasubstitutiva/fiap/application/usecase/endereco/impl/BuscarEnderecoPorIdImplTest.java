package com.provasubstitutiva.fiap.application.usecase.endereco.impl;

import com.provasubstitutiva.fiap.application.usecase.endereco.BuscarEnderecoPorId;
import com.provasubstitutiva.fiap.domain.model.Endereco;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class BuscarEnderecoPorIdImplTest {

    private BuscarEnderecoPorId buscarGateway;
    private BuscarEnderecoPorIdImpl useCase;

    @BeforeEach
    void setUp() {
        buscarGateway = mock(BuscarEnderecoPorId.class);
        useCase = new BuscarEnderecoPorIdImpl(buscarGateway);
    }

    @Test
    void deveRetornarEnderecoQuandoEncontrado() {
        Endereco endereco = new Endereco();
        endereco.setId(1L);

        when(buscarGateway.buscarEnderecoPorId(1L)).thenReturn(endereco);

        Endereco resultado = useCase.buscarEnderecoPorId(1L);

        assertEquals(1L, resultado.getId());
        verify(buscarGateway, times(1)).buscarEnderecoPorId(1L);
    }

    @Test
    void deveLancarExcecaoQuandoEnderecoNaoForEncontrado() {
        when(buscarGateway.buscarEnderecoPorId(1L)).thenReturn(null);

        assertThrows(NoSuchElementException.class, () -> useCase.buscarEnderecoPorId(1L));
        verify(buscarGateway, times(1)).buscarEnderecoPorId(1L);
    }
}

package com.provasubstitutiva.fiap.application.usecase.endereco.impl;

import com.provasubstitutiva.fiap.application.usecase.endereco.BuscarEnderecoPorIdEstabelecimento;
import com.provasubstitutiva.fiap.domain.model.Endereco;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class BuscarEnderecoPorIdEstabelecimentoImplTest {

    private BuscarEnderecoPorIdEstabelecimento buscarGateway;
    private BuscarEnderecoPorIdEstabelecimentoImpl useCase;

    @BeforeEach
    void setUp() {
        buscarGateway = mock(BuscarEnderecoPorIdEstabelecimento.class);
        useCase = new BuscarEnderecoPorIdEstabelecimentoImpl(buscarGateway);
    }

    @Test
    void deveRetornarEnderecoQuandoEncontrado() {
        Endereco endereco = new Endereco();
        endereco.setId(1L);

        when(buscarGateway.buscarPorIdEstabelecimento(10L)).thenReturn(endereco);

        Endereco resultado = useCase.buscarPorIdEstabelecimento(10L);

        assertEquals(1L, resultado.getId());
        verify(buscarGateway, times(1)).buscarPorIdEstabelecimento(10L);
    }

    @Test
    void deveLancarExcecaoQuandoEnderecoNaoEncontrado() {
        when(buscarGateway.buscarPorIdEstabelecimento(10L)).thenReturn(null);

        assertThrows(NoSuchElementException.class, () -> useCase.buscarPorIdEstabelecimento(10L));
        verify(buscarGateway, times(1)).buscarPorIdEstabelecimento(10L);
    }
}

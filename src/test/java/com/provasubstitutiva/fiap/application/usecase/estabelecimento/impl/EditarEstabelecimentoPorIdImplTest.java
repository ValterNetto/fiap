package com.provasubstitutiva.fiap.application.usecase.estabelecimento.impl;

import com.provasubstitutiva.fiap.application.usecase.estabelecimento.BuscarEstabelecimentoPorId;
import com.provasubstitutiva.fiap.application.usecase.estabelecimento.EditarEstabelecimento;
import com.provasubstitutiva.fiap.domain.model.Estabelecimento;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class EditarEstabelecimentoPorIdImplTest {

    private EditarEstabelecimento editarGateway;
    private BuscarEstabelecimentoPorId buscarGateway;
    private EditarEstabelecimentoPorIdImpl useCase;

    @BeforeEach
    void setUp() {
        editarGateway = mock(EditarEstabelecimento.class);
        buscarGateway = mock(BuscarEstabelecimentoPorId.class);
        useCase = new EditarEstabelecimentoPorIdImpl(editarGateway, buscarGateway);
    }

    @Test
    void deveEditarEstabelecimentoQuandoEncontrado() {
        Estabelecimento estabelecimento = new Estabelecimento();
        estabelecimento.setId(1L);

        when(buscarGateway.buscarEstabelecimentoPorId(1L)).thenReturn(estabelecimento);
        when(editarGateway.editarEstabelecimento(estabelecimento)).thenReturn(estabelecimento);

        Estabelecimento resultado = useCase.editarEstabelecimento(estabelecimento);

        assertEquals(1L, resultado.getId());
        verify(editarGateway, times(1)).editarEstabelecimento(estabelecimento);
    }

    @Test
    void deveLancarExcecaoQuandoEstabelecimentoNaoForEncontrado() {
        Estabelecimento estabelecimento = new Estabelecimento();
        estabelecimento.setId(1L);

        when(buscarGateway.buscarEstabelecimentoPorId(1L)).thenReturn(null);

        assertThrows(NoSuchElementException.class, () -> useCase.editarEstabelecimento(estabelecimento));
        verify(editarGateway, never()).editarEstabelecimento(any());
    }
}

package com.provasubstitutiva.fiap.application.usecase.avaliacao.impl;

import com.provasubstitutiva.fiap.application.usecase.avaliacao.BuscarAvaliacaoPorId;
import com.provasubstitutiva.fiap.application.usecase.avaliacao.EditarAvaliacao;
import com.provasubstitutiva.fiap.domain.model.Avaliacao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class EditarAvaliacaoImplTest {

    private EditarAvaliacao editarGateway;
    private BuscarAvaliacaoPorId buscarGateway;
    private EditarAvaliacaoImpl useCase;

    @BeforeEach
    void setUp() {
        editarGateway = mock(EditarAvaliacao.class);
        buscarGateway = mock(BuscarAvaliacaoPorId.class);
        useCase = new EditarAvaliacaoImpl(editarGateway, buscarGateway);
    }

    @Test
    void deveEditarAvaliacaoComSucesso() {
        Avaliacao avaliacao = new Avaliacao();
        avaliacao.setId(1L);
        avaliacao.setEstrelas(4);

        when(buscarGateway.buscarAvaliacaoPorId(1L)).thenReturn(avaliacao);
        when(editarGateway.editarAvaliacao(avaliacao)).thenReturn(avaliacao);

        Avaliacao resultado = useCase.editar(avaliacao);

        assertEquals(4, resultado.getEstrelas());
        verify(editarGateway, times(1)).editarAvaliacao(avaliacao);
    }

    @Test
    void deveLancarExcecaoSeAvaliacaoNaoForEncontrada() {
        Avaliacao avaliacao = new Avaliacao();
        avaliacao.setId(1L);

        when(buscarGateway.buscarAvaliacaoPorId(1L)).thenReturn(null);

        assertThrows(NoSuchElementException.class, () -> useCase.editar(avaliacao));
        verify(editarGateway, never()).editarAvaliacao(any());
    }
}

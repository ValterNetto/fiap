package com.provasubstitutiva.fiap.application.usecase.profissional.impl;

import com.provasubstitutiva.fiap.application.usecase.profissional.BuscarProfissionalPorId;
import com.provasubstitutiva.fiap.application.usecase.profissional.EditarProfissional;
import com.provasubstitutiva.fiap.domain.model.Profissional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class DemitirProfissionalImplTest {

    private BuscarProfissionalPorId buscarGateway;
    private EditarProfissional editarGateway;
    private DemitirProfissionalImpl useCase;

    @BeforeEach
    void setUp() {
        buscarGateway = mock(BuscarProfissionalPorId.class);
        editarGateway = mock(EditarProfissional.class);
        useCase = new DemitirProfissionalImpl(buscarGateway, editarGateway);
    }

    @Test
    void deveDemitirProfissionalComSucesso() {
        Long id = 1L;
        Profissional profissional = new Profissional();
        profissional.setId(id);
        profissional.setIdEstabelecimento(10L);

        when(buscarGateway.buscarPorId(id)).thenReturn(profissional);
        when(editarGateway.demitir(profissional)).thenReturn(profissional);

        Profissional resultado = useCase.demitir(id);

        assertNull(resultado.getIdEstabelecimento());
        verify(editarGateway).demitir(profissional);
    }

    @Test
    void deveLancarExcecaoSeProfissionalNaoForEncontrado() {
        when(buscarGateway.buscarPorId(1L)).thenReturn(null);

        assertThrows(NoSuchElementException.class, () -> useCase.demitir(1L));
        verifyNoInteractions(editarGateway);
    }
}

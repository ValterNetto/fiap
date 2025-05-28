package com.provasubstitutiva.fiap.application.usecase.foto.impl;

import com.provasubstitutiva.fiap.application.usecase.foto.ExcluirFoto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class ExcluirFotoImplTest {

    private ExcluirFoto excluirGateway;
    private ExcluirFotoImpl useCase;

    @BeforeEach
    void setUp() {
        excluirGateway = mock(ExcluirFoto.class);
        useCase = new ExcluirFotoImpl(excluirGateway);
    }

    @Test
    void deveExcluirFotoPorId() {
        Long id = 1L;

        useCase.excluir(id);

        verify(excluirGateway, times(1)).excluirFoto(id);
    }
}

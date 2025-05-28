package com.provasubstitutiva.fiap.application.usecase.avaliacao.impl;

import com.provasubstitutiva.fiap.application.usecase.avaliacao.ExcluirAvaliacao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class ExcluirAvaliacaoImplTest {

    private ExcluirAvaliacao excluirGateway;
    private ExcluirAvaliacaoImpl useCase;

    @BeforeEach
    void setUp() {
        excluirGateway = mock(ExcluirAvaliacao.class);
        useCase = new ExcluirAvaliacaoImpl(excluirGateway);
    }

    @Test
    void deveChamarGatewayDeExclusaoComIdCorreto() {
        Long id = 5L;

        useCase.excluirAvaliacao(id);

        verify(excluirGateway, times(1)).excluir(id);
    }
}

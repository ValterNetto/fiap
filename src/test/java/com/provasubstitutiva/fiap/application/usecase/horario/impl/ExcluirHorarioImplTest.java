package com.provasubstitutiva.fiap.application.usecase.horario.impl;

import com.provasubstitutiva.fiap.application.usecase.horario.ExcluirHorario;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class ExcluirHorarioImplTest {

    private ExcluirHorario excluirGateway;
    private ExcluirHorarioImpl useCase;

    @BeforeEach
    void setUp() {
        excluirGateway = mock(ExcluirHorario.class);
        useCase = new ExcluirHorarioImpl(excluirGateway);
    }

    @Test
    void deveExcluirHorarioPorId() {
        Long id = 1L;

        useCase.excluirHorario(id);

        verify(excluirGateway, times(1)).excluirHorario(id);
    }
}

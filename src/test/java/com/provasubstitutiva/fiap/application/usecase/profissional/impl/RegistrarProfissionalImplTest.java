package com.provasubstitutiva.fiap.application.usecase.profissional.impl;

import com.provasubstitutiva.fiap.application.usecase.profissional.RegistrarProfissional;
import com.provasubstitutiva.fiap.domain.model.Profissional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class RegistrarProfissionalImplTest {

    private RegistrarProfissional registrarGateway;
    private RegistrarProfissionalImpl useCase;

    @BeforeEach
    void setUp() {
        registrarGateway = mock(RegistrarProfissional.class);
        useCase = new RegistrarProfissionalImpl(registrarGateway);
    }

    @Test
    void deveRegistrarProfissionalComIdEstabelecimentoNulo() {
        Profissional profissional = new Profissional();
        profissional.setIdEstabelecimento(10L);

        Profissional esperado = new Profissional();
        esperado.setIdEstabelecimento(null);

        when(registrarGateway.registrar(any(Profissional.class))).thenReturn(esperado);

        Profissional resultado = useCase.registrarProfissional(profissional);

        assertNull(resultado.getIdEstabelecimento());
        verify(registrarGateway, times(1)).registrar(profissional);
    }
}

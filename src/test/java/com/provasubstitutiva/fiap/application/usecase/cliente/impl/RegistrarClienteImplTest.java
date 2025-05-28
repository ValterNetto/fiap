package com.provasubstitutiva.fiap.application.usecase.cliente.impl;

import com.provasubstitutiva.fiap.application.usecase.cliente.RegistrarCliente;
import com.provasubstitutiva.fiap.domain.model.Cliente;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class RegistrarClienteImplTest {

    private RegistrarCliente registrarGateway;
    private RegistrarClienteImpl useCase;

    @BeforeEach
    void setUp() {
        registrarGateway = mock(RegistrarCliente.class);
        useCase = new RegistrarClienteImpl(registrarGateway);
    }

    @Test
    void deveRegistrarClienteComIdNulo() {
        Cliente cliente = new Cliente();
        cliente.setId(10L);

        when(registrarGateway.registrarCliente(any())).thenAnswer(invocation -> invocation.getArgument(0));

        Cliente resultado = useCase.registrarCliente(cliente);

        assertNull(resultado.getId());
        verify(registrarGateway, times(1)).registrarCliente(cliente);
    }
}

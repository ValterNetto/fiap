package com.provasubstitutiva.fiap.application.usecase.servico.impl;

import com.provasubstitutiva.fiap.application.usecase.estabelecimento.BuscarEstabelecimentoPorId;
import com.provasubstitutiva.fiap.application.usecase.servico.RegistrarServico;
import com.provasubstitutiva.fiap.domain.model.Estabelecimento;
import com.provasubstitutiva.fiap.domain.model.Servico;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class RegistrarServicoImplTest {

    private RegistrarServico registrarGateway;
    private BuscarEstabelecimentoPorId buscarEstabelecimento;
    private RegistrarServicoImpl useCase;

    @BeforeEach
    void setUp() {
        registrarGateway = mock(RegistrarServico.class);
        buscarEstabelecimento = mock(BuscarEstabelecimentoPorId.class);
        useCase = new RegistrarServicoImpl(registrarGateway, buscarEstabelecimento);
    }

    @Test
    void deveRegistrarServicoComIdNuloSeEstabelecimentoExiste() {
        Servico servico = new Servico();
        servico.setId(50L); // Deve ser sobrescrito
        servico.setIdEstabelecimento(1L);

        Estabelecimento estabelecimento = new Estabelecimento();
        estabelecimento.setId(1L);

        when(buscarEstabelecimento.buscarEstabelecimentoPorId(1L)).thenReturn(estabelecimento);
        when(registrarGateway.registrarServico(servico)).thenReturn(servico);

        Servico resultado = useCase.registrarServico(servico);

        assertNull(resultado.getId()); // O ID foi sobrescrito para null
        verify(registrarGateway).registrarServico(servico);
    }

    @Test
    void deveLancarExcecaoSeEstabelecimentoNaoExistir() {
        Servico servico = new Servico();
        servico.setIdEstabelecimento(99L);

        when(buscarEstabelecimento.buscarEstabelecimentoPorId(99L)).thenReturn(null);

        assertThrows(NoSuchElementException.class, () -> useCase.registrarServico(servico));
        verifyNoInteractions(registrarGateway);
    }
}

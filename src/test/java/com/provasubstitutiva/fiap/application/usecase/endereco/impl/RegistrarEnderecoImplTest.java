package com.provasubstitutiva.fiap.application.usecase.endereco.impl;

import com.provasubstitutiva.fiap.application.usecase.endereco.BuscarEnderecoPorIdEstabelecimento;
import com.provasubstitutiva.fiap.application.usecase.endereco.RegistrarEndereco;
import com.provasubstitutiva.fiap.application.usecase.estabelecimento.BuscarEstabelecimentoPorId;
import com.provasubstitutiva.fiap.domain.model.Endereco;
import com.provasubstitutiva.fiap.domain.model.Estabelecimento;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class RegistrarEnderecoImplTest {

    private BuscarEstabelecimentoPorId buscarEstabelecimento;
    private RegistrarEndereco registrarGateway;
    private BuscarEnderecoPorIdEstabelecimento buscarEndereco;
    private RegistrarEnderecoImpl useCase;

    @BeforeEach
    void setUp() {
        buscarEstabelecimento = mock(BuscarEstabelecimentoPorId.class);
        registrarGateway = mock(RegistrarEndereco.class);
        buscarEndereco = mock(BuscarEnderecoPorIdEstabelecimento.class);
        useCase = new RegistrarEnderecoImpl(buscarEstabelecimento, registrarGateway, buscarEndereco);
    }

    @Test
    void deveRegistrarEnderecoComSucesso() {
        Endereco endereco = mock(Endereco.class);
        when(endereco.getIdEstabelecimento()).thenReturn(1L);
        when(endereco.isValid()).thenReturn(true);
        when(buscarEstabelecimento.buscarEstabelecimentoPorId(1L)).thenReturn(new Estabelecimento());
        when(buscarEndereco.buscarPorIdEstabelecimento(1L)).thenReturn(null);
        when(registrarGateway.registrarEndereco(endereco)).thenReturn(endereco);

        Endereco resultado = useCase.registrarEndereco(endereco);

        assertEquals(endereco, resultado);
        verify(registrarGateway).registrarEndereco(endereco);
    }

    @Test
    void deveLancarExcecaoSeEstabelecimentoNaoExiste() {
        Endereco endereco = new Endereco();
        endereco.setIdEstabelecimento(1L);

        when(buscarEstabelecimento.buscarEstabelecimentoPorId(1L)).thenReturn(null);

        assertThrows(NoSuchElementException.class, () -> useCase.registrarEndereco(endereco));
    }

    @Test
    void deveLancarExcecaoSeEnderecoJaExisteParaEstabelecimento() {
        Endereco endereco = new Endereco();
        endereco.setIdEstabelecimento(1L);

        when(buscarEstabelecimento.buscarEstabelecimentoPorId(1L)).thenReturn(new Estabelecimento());
        when(buscarEndereco.buscarPorIdEstabelecimento(1L)).thenReturn(new Endereco());

        assertThrows(IllegalStateException.class, () -> useCase.registrarEndereco(endereco));
    }

    @Test
    void deveLancarExcecaoSeEnderecoForInvalido() {
        Endereco endereco = mock(Endereco.class);
        when(endereco.getIdEstabelecimento()).thenReturn(1L);
        when(endereco.isValid()).thenReturn(false);
        when(buscarEstabelecimento.buscarEstabelecimentoPorId(1L)).thenReturn(new Estabelecimento());
        when(buscarEndereco.buscarPorIdEstabelecimento(1L)).thenReturn(null);

        assertThrows(IllegalStateException.class, () -> useCase.registrarEndereco(endereco));
    }
}

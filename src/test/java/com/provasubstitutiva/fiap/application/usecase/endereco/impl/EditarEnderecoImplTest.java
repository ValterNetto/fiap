package com.provasubstitutiva.fiap.application.usecase.endereco.impl;

import com.provasubstitutiva.fiap.application.usecase.endereco.BuscarEnderecoPorId;
import com.provasubstitutiva.fiap.application.usecase.endereco.EditarEndereco;
import com.provasubstitutiva.fiap.domain.model.Endereco;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class EditarEnderecoImplTest {

    private EditarEndereco editarGateway;
    private BuscarEnderecoPorId buscarGateway;
    private EditarEnderecoImpl useCase;

    @BeforeEach
    void setUp() {
        editarGateway = mock(EditarEndereco.class);
        buscarGateway = mock(BuscarEnderecoPorId.class);
        useCase = new EditarEnderecoImpl(editarGateway, buscarGateway);
    }

    @Test
    void deveEditarEnderecoQuandoValido() {
        Endereco endereco = mock(Endereco.class);

        when(endereco.getId()).thenReturn(1L);
        when(endereco.getIdEstabelecimento()).thenReturn(1L);
        when(endereco.isValid()).thenReturn(true);

        when(buscarGateway.buscarEnderecoPorId(1L)).thenReturn(endereco);
        when(editarGateway.editarEndereco(endereco)).thenReturn(endereco);

        Endereco resultado = useCase.editarEndereco(endereco);

        assertEquals(endereco, resultado);
        verify(editarGateway, times(1)).editarEndereco(endereco);
    }


    @Test
    void deveLancarExcecaoQuandoEnderecoNaoForEncontrado() {
        Endereco endereco = new Endereco();
        endereco.setIdEstabelecimento(1L);

        when(buscarGateway.buscarEnderecoPorId(1L)).thenReturn(null);

        assertThrows(NoSuchElementException.class, () -> useCase.editarEndereco(endereco));
        verify(editarGateway, never()).editarEndereco(any());
    }

    @Test
    void deveLancarExcecaoQuandoDadosObrigatoriosEstiveremInvalidos() {
        Endereco endereco = mock(Endereco.class);
        when(endereco.getIdEstabelecimento()).thenReturn(1L);
        when(endereco.isValid()).thenReturn(false);
        when(buscarGateway.buscarEnderecoPorId(1L)).thenReturn(endereco);

        assertThrows(IllegalStateException.class, () -> useCase.editarEndereco(endereco));
        verify(editarGateway, never()).editarEndereco(any());
    }
}

package com.provasubstitutiva.fiap.application.usecase.foto.impl;

import com.provasubstitutiva.fiap.application.usecase.estabelecimento.BuscarEstabelecimentoPorId;
import com.provasubstitutiva.fiap.application.usecase.foto.AdicionarFoto;
import com.provasubstitutiva.fiap.domain.model.Estabelecimento;
import com.provasubstitutiva.fiap.domain.model.Foto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class AdicionarFotoImplTest {

    private AdicionarFoto adicionarGateway;
    private BuscarEstabelecimentoPorId buscarEstabelecimento;
    private AdicionarFotoImpl useCase;

    @BeforeEach
    void setUp() {
        adicionarGateway = mock(AdicionarFoto.class);
        buscarEstabelecimento = mock(BuscarEstabelecimentoPorId.class);
        useCase = new AdicionarFotoImpl(adicionarGateway, buscarEstabelecimento);
    }

    @Test
    void deveAdicionarFotoQuandoEstabelecimentoExiste() {
        Foto foto = new Foto();
        foto.setIdEstabelecimento(1L);

        Estabelecimento estabelecimento = new Estabelecimento();
        estabelecimento.setId(1L);

        when(buscarEstabelecimento.buscarEstabelecimentoPorId(1L)).thenReturn(estabelecimento);
        when(adicionarGateway.adicionarFoto(foto)).thenReturn(foto);

        Foto resultado = useCase.adicionarFoto(foto);

        assertEquals(foto, resultado);
        verify(adicionarGateway, times(1)).adicionarFoto(foto);
    }

    @Test
    void deveLancarExcecaoSeEstabelecimentoNaoExiste() {
        Foto foto = new Foto();
        foto.setIdEstabelecimento(1L);

        when(buscarEstabelecimento.buscarEstabelecimentoPorId(1L)).thenReturn(null);

        assertThrows(NoSuchElementException.class, () -> useCase.adicionarFoto(foto));
        verify(adicionarGateway, never()).adicionarFoto(any());
    }
}

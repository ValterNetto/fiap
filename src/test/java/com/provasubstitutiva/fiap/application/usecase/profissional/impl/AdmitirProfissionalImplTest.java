package com.provasubstitutiva.fiap.application.usecase.profissional.impl;

import com.provasubstitutiva.fiap.application.usecase.estabelecimento.BuscarEstabelecimentoPorId;
import com.provasubstitutiva.fiap.application.usecase.profissional.AdmitirProfissional;
import com.provasubstitutiva.fiap.application.usecase.profissional.BuscarProfissionalPorId;
import com.provasubstitutiva.fiap.domain.model.Estabelecimento;
import com.provasubstitutiva.fiap.domain.model.Profissional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class AdmitirProfissionalImplTest {

    private AdmitirProfissional admitirGateway;
    private BuscarEstabelecimentoPorId buscarEstabelecimentoPorId;
    private BuscarProfissionalPorId buscarProfissionalPorId;
    private AdmitirProfissionalImpl useCase;

    @BeforeEach
    void setUp() {
        admitirGateway = mock(AdmitirProfissional.class);
        buscarEstabelecimentoPorId = mock(BuscarEstabelecimentoPorId.class);
        buscarProfissionalPorId = mock(BuscarProfissionalPorId.class);
        useCase = new AdmitirProfissionalImpl(admitirGateway, buscarEstabelecimentoPorId, buscarProfissionalPorId);
    }

    @Test
    void deveAdmitirProfissionalComSucesso() {
        Long idEstab = 1L;
        Long idProf = 2L;

        Profissional profissional = new Profissional();
        profissional.setId(idProf);
        profissional.setIdEstabelecimento(null);

        Estabelecimento estabelecimento = new Estabelecimento();
        estabelecimento.setId(idEstab);

        when(buscarEstabelecimentoPorId.buscarEstabelecimentoPorId(idEstab)).thenReturn(estabelecimento);
        when(buscarProfissionalPorId.buscarPorId(idProf)).thenReturn(profissional);
        when(admitirGateway.admitirProfissional(profissional)).thenReturn(profissional);

        Profissional resultado = useCase.admitirProfissional(idEstab, idProf);

        assertEquals(idEstab, resultado.getIdEstabelecimento());
        verify(admitirGateway).admitirProfissional(profissional);
    }

    @Test
    void deveLancarExcecaoSeEstabelecimentoOuProfissionalNaoExistirem() {
        when(buscarEstabelecimentoPorId.buscarEstabelecimentoPorId(1L)).thenReturn(null);
        when(buscarProfissionalPorId.buscarPorId(2L)).thenReturn(null);

        assertThrows(NoSuchElementException.class, () -> useCase.admitirProfissional(1L, 2L));
    }

    @Test
    void deveLancarExcecaoSeProfissionalJaVinculado() {
        Profissional profissional = new Profissional();
        profissional.setId(2L);
        profissional.setIdEstabelecimento(10L);

        when(buscarEstabelecimentoPorId.buscarEstabelecimentoPorId(1L)).thenReturn(new Estabelecimento());
        when(buscarProfissionalPorId.buscarPorId(2L)).thenReturn(profissional);

        assertThrows(IllegalStateException.class, () -> useCase.admitirProfissional(1L, 2L));
    }
}

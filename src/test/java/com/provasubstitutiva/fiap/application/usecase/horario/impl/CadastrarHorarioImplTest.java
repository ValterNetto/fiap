package com.provasubstitutiva.fiap.application.usecase.horario.impl;

import com.provasubstitutiva.fiap.application.usecase.estabelecimento.BuscarEstabelecimentoPorId;
import com.provasubstitutiva.fiap.application.usecase.horario.BuscarHorariosPorIdEstabelecimento;
import com.provasubstitutiva.fiap.application.usecase.horario.CadastrarHorario;
import com.provasubstitutiva.fiap.domain.model.Estabelecimento;
import com.provasubstitutiva.fiap.domain.model.Horario;
import com.provasubstitutiva.fiap.domain.model.constant.DiasDaSemanaEnum;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CadastrarHorarioImplTest {

    private CadastrarHorario cadastrarGateway;
    private BuscarEstabelecimentoPorId buscarEstabelecimento;
    private BuscarHorariosPorIdEstabelecimento buscarHorarios;
    private CadastrarHorarioImpl useCase;

    @BeforeEach
    void setUp() {
        cadastrarGateway = mock(CadastrarHorario.class);
        buscarEstabelecimento = mock(BuscarEstabelecimentoPorId.class);
        buscarHorarios = mock(BuscarHorariosPorIdEstabelecimento.class);
        useCase = new CadastrarHorarioImpl(cadastrarGateway, buscarEstabelecimento, buscarHorarios);
    }

    @Test
    void deveCadastrarHorarioSeNaoExistirOutroNoMesmoDia() {
        Horario horario = new Horario();
        horario.setIdEstabelecimento(1L);
        horario.setDiaDaSemana(DiasDaSemanaEnum.MONDAY);

        Estabelecimento estabelecimento = new Estabelecimento();
        estabelecimento.setId(1L);

        when(buscarEstabelecimento.buscarEstabelecimentoPorId(1L)).thenReturn(estabelecimento);
        when(buscarHorarios.buscarPorIdEstabelecimento(1L)).thenReturn(List.of());
        when(cadastrarGateway.cadastrarHorario(horario)).thenReturn(horario);

        Horario resultado = useCase.cadastraHorario(horario);

        assertEquals(horario, resultado);
        verify(cadastrarGateway, times(1)).cadastrarHorario(horario);
    }

    @Test
    void deveLancarExcecaoSeEstabelecimentoNaoExistir() {
        Horario horario = new Horario();
        horario.setIdEstabelecimento(1L);

        when(buscarEstabelecimento.buscarEstabelecimentoPorId(1L)).thenReturn(null);

        assertThrows(NoSuchElementException.class, () -> useCase.cadastraHorario(horario));
        verifyNoInteractions(buscarHorarios, cadastrarGateway);
    }

    @Test
    void deveLancarExcecaoSeJaHouverHorarioNoMesmoDia() {
        Horario horario = new Horario();
        horario.setIdEstabelecimento(1L);
        horario.setDiaDaSemana(DiasDaSemanaEnum.WEDNESDAY);

        Horario jaExistente = new Horario();
        jaExistente.setDiaDaSemana(DiasDaSemanaEnum.WEDNESDAY);

        when(buscarEstabelecimento.buscarEstabelecimentoPorId(1L)).thenReturn(new Estabelecimento());
        when(buscarHorarios.buscarPorIdEstabelecimento(1L)).thenReturn(List.of(jaExistente));

        assertThrows(IllegalStateException.class, () -> useCase.cadastraHorario(horario));
        verify(cadastrarGateway, never()).cadastrarHorario(any());
    }
}

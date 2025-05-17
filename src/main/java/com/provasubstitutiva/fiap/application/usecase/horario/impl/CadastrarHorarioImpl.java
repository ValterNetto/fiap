package com.provasubstitutiva.fiap.application.usecase.horario.impl;

import com.provasubstitutiva.fiap.application.usecase.estabelecimento.BuscarEstabelecimentoPorId;
import com.provasubstitutiva.fiap.application.usecase.horario.BuscarPorIdEstabelecimento;
import com.provasubstitutiva.fiap.application.usecase.horario.CadastrarHorario;
import com.provasubstitutiva.fiap.domain.model.Horario;

import java.util.NoSuchElementException;
import java.util.Objects;

public class CadastrarHorarioImpl {

    private final CadastrarHorario cadastrarHorario;
    private final BuscarEstabelecimentoPorId buscarEstabelecimento;
    private final BuscarPorIdEstabelecimento buscarPorIdEstabelecimento;

    public CadastrarHorarioImpl(CadastrarHorario cadastrarHorario, BuscarEstabelecimentoPorId buscarEstabelecimento, BuscarPorIdEstabelecimento buscarPorIdEstabelecimento) {
        this.cadastrarHorario = cadastrarHorario;
        this.buscarEstabelecimento = buscarEstabelecimento;
        this.buscarPorIdEstabelecimento = buscarPorIdEstabelecimento;
    }

    public Horario cadastraHorario(Horario horario) {
        if (Objects.isNull(buscarEstabelecimento.buscarEstabelecimentoPorId(horario.getIdEstabelecimento()))) {
            throw new NoSuchElementException("Estabelecimento não encontrado");
        }
        Horario horarioExistente = buscarPorIdEstabelecimento.buscarPorIdEstabelecimento(horario.getIdEstabelecimento())
                .stream().filter(horarioStream -> horarioStream.getDiaDaSemana().equals(horario.getDiaDaSemana()))
                .findFirst()
                .orElse(null);
        if (Objects.nonNull(horarioExistente)) {
            throw new IllegalStateException("Os horários desse dia já foram registrados");
        }
        return cadastrarHorario.cadastrarHorario(horario);
    }
}

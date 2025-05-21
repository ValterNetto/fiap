package com.provasubstitutiva.fiap.application.usecase.horario.impl;

import com.provasubstitutiva.fiap.application.usecase.estabelecimento.BuscarEstabelecimentoPorId;
import com.provasubstitutiva.fiap.application.usecase.horario.BuscarHorariosPorIdEstabelecimento;
import com.provasubstitutiva.fiap.application.usecase.horario.CadastrarHorario;
import com.provasubstitutiva.fiap.domain.model.Horario;

import java.util.NoSuchElementException;
import java.util.Objects;

public class CadastrarHorarioImpl {

    private final CadastrarHorario cadastrarHorario;
    private final BuscarEstabelecimentoPorId buscarEstabelecimento;
    private final BuscarHorariosPorIdEstabelecimento buscarHorariosPorIdEstabelecimento;

    public CadastrarHorarioImpl(CadastrarHorario cadastrarHorario, BuscarEstabelecimentoPorId buscarEstabelecimento, BuscarHorariosPorIdEstabelecimento buscarHorariosPorIdEstabelecimento) {
        this.cadastrarHorario = cadastrarHorario;
        this.buscarEstabelecimento = buscarEstabelecimento;
        this.buscarHorariosPorIdEstabelecimento = buscarHorariosPorIdEstabelecimento;
    }

    public Horario cadastraHorario(Horario horario) {
        if (Objects.isNull(buscarEstabelecimento.buscarEstabelecimentoPorId(horario.getIdEstabelecimento()))) {
            throw new NoSuchElementException("Estabelecimento não encontrado");
        }
        Horario horarioExistente = buscarHorariosPorIdEstabelecimento.buscarPorIdEstabelecimento(horario.getIdEstabelecimento())
                .stream().filter(horarioStream -> horarioStream.getDiaDaSemana().equals(horario.getDiaDaSemana()))
                .findFirst()
                .orElse(null);
        if (Objects.nonNull(horarioExistente)) {
            throw new IllegalStateException("Os horários desse dia já foram registrados");
        }
        return cadastrarHorario.cadastrarHorario(horario);
    }
}

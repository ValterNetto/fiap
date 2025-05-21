package com.provasubstitutiva.fiap.application.usecase.horario.impl;

import com.provasubstitutiva.fiap.application.usecase.horario.BuscarHorariosPorIdEstabelecimento;
import com.provasubstitutiva.fiap.domain.model.Horario;

import java.util.List;

public class BuscarHorariosPorIdEstabelecimentoImpl {

    private final BuscarHorariosPorIdEstabelecimento buscarHorariosPorIdEstabelecimento;

    public BuscarHorariosPorIdEstabelecimentoImpl(BuscarHorariosPorIdEstabelecimento buscarHorariosPorIdEstabelecimento) {
        this.buscarHorariosPorIdEstabelecimento = buscarHorariosPorIdEstabelecimento;
    }

    public List<Horario> buscarHorariosPorIdEstabelecimento(Long idEstabelecimento) {
        return buscarHorariosPorIdEstabelecimento.buscarPorIdEstabelecimento(idEstabelecimento);
    }
}

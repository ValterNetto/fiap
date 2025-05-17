package com.provasubstitutiva.fiap.application.usecase.horario.impl;

import com.provasubstitutiva.fiap.application.usecase.horario.BuscarPorIdEstabelecimento;
import com.provasubstitutiva.fiap.domain.model.Horario;

import java.util.List;

public class BuscarPorIdEstabelecimentoImpl {

    private final BuscarPorIdEstabelecimento buscarPorIdEstabelecimento;

    public BuscarPorIdEstabelecimentoImpl(BuscarPorIdEstabelecimento buscarPorIdEstabelecimento) {
        this.buscarPorIdEstabelecimento = buscarPorIdEstabelecimento;
    }

    public List<Horario> buscarHorariosPorIdEstabelecimento(Long idEstabelecimento) {
        return buscarPorIdEstabelecimento.buscarPorIdEstabelecimento(idEstabelecimento);
    }
}

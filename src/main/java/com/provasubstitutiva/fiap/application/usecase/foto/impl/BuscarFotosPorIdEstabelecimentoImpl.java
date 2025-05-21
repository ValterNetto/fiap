package com.provasubstitutiva.fiap.application.usecase.foto.impl;

import com.provasubstitutiva.fiap.application.usecase.foto.BuscarFotosPorIdEstabelecimento;
import com.provasubstitutiva.fiap.domain.model.Foto;

import java.util.List;

public class BuscarFotosPorIdEstabelecimentoImpl {

    private final BuscarFotosPorIdEstabelecimento buscarFotosPorIdEstabelecimento;

    public BuscarFotosPorIdEstabelecimentoImpl(BuscarFotosPorIdEstabelecimento buscarFotosPorIdEstabelecimento) {
        this.buscarFotosPorIdEstabelecimento = buscarFotosPorIdEstabelecimento;
    }

    public List<Foto> buscarFotoPorIdEstabelecimento(Long idEstabelecimento) {
        return buscarFotosPorIdEstabelecimento.buscarFotoPorIdEstabelecimento(idEstabelecimento);
    }
}

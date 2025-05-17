package com.provasubstitutiva.fiap.application.usecase.foto.impl;

import com.provasubstitutiva.fiap.application.usecase.foto.BuscarFotoPorIdEstabelecimento;
import com.provasubstitutiva.fiap.domain.model.Foto;

import java.util.List;

public class BuscarFotoPorIdEstabelecimentoImpl {

    private final BuscarFotoPorIdEstabelecimento buscarFotoPorIdEstabelecimento;

    public BuscarFotoPorIdEstabelecimentoImpl(BuscarFotoPorIdEstabelecimento buscarFotoPorIdEstabelecimento) {
        this.buscarFotoPorIdEstabelecimento = buscarFotoPorIdEstabelecimento;
    }

    public List<Foto> buscarFotoPorIdEstabelecimento(Long idEstabelecimento) {
        return buscarFotoPorIdEstabelecimento.buscarFotoPorIdEstabelecimento(idEstabelecimento);
    }
}

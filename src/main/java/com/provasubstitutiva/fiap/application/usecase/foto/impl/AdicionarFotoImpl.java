package com.provasubstitutiva.fiap.application.usecase.foto.impl;

import com.provasubstitutiva.fiap.application.usecase.estabelecimento.BuscarEstabelecimentoPorId;
import com.provasubstitutiva.fiap.application.usecase.foto.AdicionarFoto;
import com.provasubstitutiva.fiap.domain.model.Foto;

import java.util.NoSuchElementException;
import java.util.Objects;

public class AdicionarFotoImpl {

    private final AdicionarFoto adicionarFoto;
    private final BuscarEstabelecimentoPorId buscarEstabelecimentoPorId;

    public AdicionarFotoImpl(AdicionarFoto adicionarFoto, BuscarEstabelecimentoPorId buscarEstabelecimentoPorId) {
        this.adicionarFoto = adicionarFoto;
        this.buscarEstabelecimentoPorId = buscarEstabelecimentoPorId;
    }

    public Foto adicionarFoto(Foto foto) {
        if (Objects.isNull(buscarEstabelecimentoPorId.buscarEstabelecimentoPorId(foto.getIdEstabelecimento()))) {
            throw new NoSuchElementException("Estabelecimento não encontrado");
        }
        return adicionarFoto.adicionarFoto(foto);
    }
}

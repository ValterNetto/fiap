package com.provasubstitutiva.fiap.application.usecase.estabelecimento.impl;

import com.provasubstitutiva.fiap.application.usecase.estabelecimento.AdmitirProfissional;
import com.provasubstitutiva.fiap.application.usecase.estabelecimento.BuscarEstabelecimentoPorId;
import com.provasubstitutiva.fiap.application.usecase.profissional.BuscarProfissionalPorId;
import com.provasubstitutiva.fiap.domain.model.Profissional;

import java.util.NoSuchElementException;
import java.util.Objects;

public class AdmitirProfissionalImpl {
    private final AdmitirProfissional admitirProfissional;
    private final BuscarEstabelecimentoPorId buscarEstabelecimentoPorId;
    private final BuscarProfissionalPorId buscarProfissionalPorId;

    public AdmitirProfissionalImpl(AdmitirProfissional admitirProfissional, BuscarEstabelecimentoPorId buscarEstabelecimentoPorId, BuscarProfissionalPorId buscarProfissionalPorId) {
        this.admitirProfissional = admitirProfissional;
        this.buscarEstabelecimentoPorId = buscarEstabelecimentoPorId;
        this.buscarProfissionalPorId = buscarProfissionalPorId;
    }

    public Profissional admitirProfissional(Long idEstabelecimento, Long idProfissional) {
        if (Objects.isNull(buscarEstabelecimentoPorId.buscarEstabelecimentoPorId(idEstabelecimento))
                || Objects.isNull(buscarProfissionalPorId.buscarPorId(idProfissional))) {
            throw new NoSuchElementException("Estabelecimento ou Profissional não encontrado");
        }
        if (Objects.nonNull(buscarProfissionalPorId.buscarPorId(idProfissional).getIdEstabelecimento())) {
            throw new IllegalStateException("Profissional já está vinculado à um estabelecimento");
        }
        return admitirProfissional.admitirProfissional(idEstabelecimento, idProfissional);
    }
}

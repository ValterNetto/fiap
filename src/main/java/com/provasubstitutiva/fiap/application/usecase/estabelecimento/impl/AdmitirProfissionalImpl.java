package com.provasubstitutiva.fiap.application.usecase.estabelecimento.impl;

import com.provasubstitutiva.fiap.application.usecase.estabelecimento.AdmitirProfissional;
import com.provasubstitutiva.fiap.application.usecase.estabelecimento.BuscarEstabelecimentoPorId;
import com.provasubstitutiva.fiap.application.usecase.profissional.BuscarPorIdProfissional;
import com.provasubstitutiva.fiap.domain.model.Profissional;

import javax.naming.NoPermissionException;
import java.util.NoSuchElementException;
import java.util.Objects;

public class AdmitirProfissionalImpl {
    private final AdmitirProfissional admitirProfissional;
    private final BuscarEstabelecimentoPorId buscarEstabelecimentoPorId;
    private final BuscarPorIdProfissional buscarPorIdProfissional;

    public AdmitirProfissionalImpl(AdmitirProfissional admitirProfissional, BuscarEstabelecimentoPorId buscarEstabelecimentoPorId, BuscarPorIdProfissional buscarPorIdProfissional) {
        this.admitirProfissional = admitirProfissional;
        this.buscarEstabelecimentoPorId = buscarEstabelecimentoPorId;
        this.buscarPorIdProfissional = buscarPorIdProfissional;
    }

    public Profissional admitirProfissional(Long idEstabelecimento, Long idProfissional) {
        if (Objects.isNull(buscarEstabelecimentoPorId.buscarEstabelecimentoPorId(idEstabelecimento))
                || Objects.isNull(buscarPorIdProfissional.buscarPorId(idProfissional))) {
            throw new NoSuchElementException("Estabelecimento ou Profissional não encontrado");
        }
        if (Objects.nonNull(buscarPorIdProfissional.buscarPorId(idProfissional).getIdEstabelecimento())) {
            throw new IllegalStateException("Profissional já está vinculado à um estabelecimento");
        }
        return admitirProfissional.admitirProfissional(idEstabelecimento, idProfissional);
    }
}

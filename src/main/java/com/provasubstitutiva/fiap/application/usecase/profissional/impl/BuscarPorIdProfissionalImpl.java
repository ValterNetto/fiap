package com.provasubstitutiva.fiap.application.usecase.profissional.impl;

import com.provasubstitutiva.fiap.application.usecase.profissional.BuscarPorIdProfissional;
import com.provasubstitutiva.fiap.domain.model.Profissional;

public class BuscarPorIdProfissionalImpl {

    private final BuscarPorIdProfissional buscarPorIdProfissional;

    public BuscarPorIdProfissionalImpl(BuscarPorIdProfissional buscarPorIdProfissional) {
        this.buscarPorIdProfissional = buscarPorIdProfissional;
    }

    public Profissional buscarPorIdProfissional(Long id) {
        return buscarPorIdProfissional.buscarPorId(id);
    }
}

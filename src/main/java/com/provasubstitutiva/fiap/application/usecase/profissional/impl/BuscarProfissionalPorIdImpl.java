package com.provasubstitutiva.fiap.application.usecase.profissional.impl;

import com.provasubstitutiva.fiap.application.usecase.profissional.BuscarProfissionalPorId;
import com.provasubstitutiva.fiap.domain.model.Profissional;

public class BuscarProfissionalPorIdImpl {

    private final BuscarProfissionalPorId buscarProfissionalPorId;

    public BuscarProfissionalPorIdImpl(BuscarProfissionalPorId buscarProfissionalPorId) {
        this.buscarProfissionalPorId = buscarProfissionalPorId;
    }

    public Profissional buscarPorIdProfissional(Long id) {
        return buscarProfissionalPorId.buscarPorId(id);
    }
}

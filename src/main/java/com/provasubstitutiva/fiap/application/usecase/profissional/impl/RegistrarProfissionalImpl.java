package com.provasubstitutiva.fiap.application.usecase.profissional.impl;

import com.provasubstitutiva.fiap.application.usecase.profissional.RegistrarProfissional;
import com.provasubstitutiva.fiap.domain.model.Profissional;

public class RegistrarProfissionalImpl {

    private final RegistrarProfissional registrarProfissional;

    public RegistrarProfissionalImpl(RegistrarProfissional registrarProfissional) {
        this.registrarProfissional = registrarProfissional;
    }

    public Profissional registrarProfissional(Profissional profissional) {
        profissional.setIdEstabelecimento(null);
        return registrarProfissional.registrar(profissional);
    }
}

package com.provasubstitutiva.fiap.application.usecase.foto.impl;

import com.provasubstitutiva.fiap.application.usecase.foto.ExcluirFoto;

public class ExcluirFotoImpl {

    private final ExcluirFoto excluirFoto;

    public ExcluirFotoImpl(ExcluirFoto excluirFoto) {
        this.excluirFoto = excluirFoto;
    }

    public void excluir(Long id) {
        excluirFoto.excluirFoto(id);
    }
}

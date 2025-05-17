package com.provasubstitutiva.fiap.application.usecase.avaliacao.impl;

import com.provasubstitutiva.fiap.application.usecase.avaliacao.EditarAvaliacao;
import com.provasubstitutiva.fiap.domain.model.Avaliacao;

public class EditarAvaliacaoImpl {

    private final EditarAvaliacao editarAvaliacao;

    public EditarAvaliacaoImpl(EditarAvaliacao editarAvaliacao) {
        this.editarAvaliacao = editarAvaliacao;
    }

    public Avaliacao editar(Avaliacao avaliacao) {
        return editarAvaliacao.editarAvaliacao(avaliacao);
    }
}

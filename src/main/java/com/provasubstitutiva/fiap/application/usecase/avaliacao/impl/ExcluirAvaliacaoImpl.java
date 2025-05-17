package com.provasubstitutiva.fiap.application.usecase.avaliacao.impl;

import com.provasubstitutiva.fiap.application.usecase.avaliacao.ExcluirAvaliacao;

public class ExcluirAvaliacaoImpl {

    private final ExcluirAvaliacao excluirAvaliacao;

    public ExcluirAvaliacaoImpl(ExcluirAvaliacao excluirAvaliacao) {
        this.excluirAvaliacao = excluirAvaliacao;
    }

    public void excluirAvaliacao(Long id) {
        excluirAvaliacao.excluir(id);
    }
}

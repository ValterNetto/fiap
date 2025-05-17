package com.provasubstitutiva.fiap.application.usecase.avaliacao.impl;

import com.provasubstitutiva.fiap.application.usecase.avaliacao.FazerAvaliacao;
import com.provasubstitutiva.fiap.domain.model.Avaliacao;

public class FazerAvaliacaoImpl {

    private final FazerAvaliacao fazerAvaliacao;

    public FazerAvaliacaoImpl(FazerAvaliacao fazerAvaliacao) {
        this.fazerAvaliacao = fazerAvaliacao;
    }

    public Avaliacao fazerAvaliacao(Avaliacao avaliacao) {
        return fazerAvaliacao.fazerAvaliacao(avaliacao);
    }
}

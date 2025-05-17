package com.provasubstitutiva.fiap.application.usecase.servico.impl;

import com.provasubstitutiva.fiap.application.usecase.servico.ExcluirServico;

public class ExcluirServicoImpl {

    private final ExcluirServico excluirServico;

    public ExcluirServicoImpl(ExcluirServico excluirServico) {
        this.excluirServico = excluirServico;
    }

    public void cancelar(Long id) {
        excluirServico.cancelarServico(id);
    }
}

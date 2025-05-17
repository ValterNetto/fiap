package com.provasubstitutiva.fiap.application.usecase.horario.impl;

import com.provasubstitutiva.fiap.application.usecase.horario.ExcluirHorario;

public class ExcluirHorarioImpl {

    private final ExcluirHorario excluirHorario;

    public ExcluirHorarioImpl(ExcluirHorario excluirHorario) {
        this.excluirHorario = excluirHorario;
    }

    public void excluirHorario(Long id) {
        excluirHorario.excluirHorario(id);
    }
}

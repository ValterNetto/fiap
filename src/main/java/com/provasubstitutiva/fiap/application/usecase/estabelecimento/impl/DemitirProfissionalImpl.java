package com.provasubstitutiva.fiap.application.usecase.estabelecimento.impl;

import com.provasubstitutiva.fiap.application.usecase.profissional.BuscarPorIdProfissional;
import com.provasubstitutiva.fiap.application.usecase.profissional.EditarProfissional;
import com.provasubstitutiva.fiap.domain.model.Profissional;

import java.util.NoSuchElementException;
import java.util.Objects;

public class DemitirProfissionalImpl {

    private final BuscarPorIdProfissional buscarPorIdProfissional;
    private final EditarProfissional editarProfissional;

    public DemitirProfissionalImpl(BuscarPorIdProfissional buscarPorIdProfissional, EditarProfissional editarProfissional) {
        this.buscarPorIdProfissional = buscarPorIdProfissional;
        this.editarProfissional = editarProfissional;
    }

    public Profissional demitir(Long idProfissional) {
        Profissional profissional = buscarPorIdProfissional.buscarPorId(idProfissional);
        if (Objects.isNull(profissional)) {
            throw new NoSuchElementException("Não foi possível encontrar o profissional");
        }
        profissional.setIdEstabelecimento(null);
        return editarProfissional.editar(profissional);
    }
}

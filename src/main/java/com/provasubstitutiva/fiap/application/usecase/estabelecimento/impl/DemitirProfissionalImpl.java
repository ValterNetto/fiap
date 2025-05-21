package com.provasubstitutiva.fiap.application.usecase.estabelecimento.impl;

import com.provasubstitutiva.fiap.application.usecase.profissional.BuscarProfissionalPorId;
import com.provasubstitutiva.fiap.application.usecase.profissional.EditarProfissional;
import com.provasubstitutiva.fiap.domain.model.Profissional;

import java.util.NoSuchElementException;
import java.util.Objects;

public class DemitirProfissionalImpl {

    private final BuscarProfissionalPorId buscarProfissionalPorId;
    private final EditarProfissional editarProfissional;

    public DemitirProfissionalImpl(BuscarProfissionalPorId buscarProfissionalPorId, EditarProfissional editarProfissional) {
        this.buscarProfissionalPorId = buscarProfissionalPorId;
        this.editarProfissional = editarProfissional;
    }

    public Profissional demitir(Long idProfissional) {
        Profissional profissional = buscarProfissionalPorId.buscarPorId(idProfissional);
        if (Objects.isNull(profissional)) {
            throw new NoSuchElementException("Não foi possível encontrar o profissional");
        }
        profissional.setIdEstabelecimento(null);
        return editarProfissional.editar(profissional);
    }
}

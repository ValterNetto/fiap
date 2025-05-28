package com.provasubstitutiva.fiap.application.usecase.endereco.impl;

import com.provasubstitutiva.fiap.application.usecase.endereco.BuscarEnderecoPorId;
import com.provasubstitutiva.fiap.application.usecase.endereco.EditarEndereco;
import com.provasubstitutiva.fiap.domain.model.Endereco;

import java.util.NoSuchElementException;
import java.util.Objects;

public class EditarEnderecoImpl {

    private final EditarEndereco editarEndereco;
    private final BuscarEnderecoPorId buscarEnderecoPorId;

    public EditarEnderecoImpl(EditarEndereco editarEndereco, BuscarEnderecoPorId buscarEnderecoPorId) {
        this.editarEndereco = editarEndereco;
        this.buscarEnderecoPorId = buscarEnderecoPorId;
    }

    public Endereco editarEndereco(Endereco endereco) {
        if(Objects.isNull(buscarEnderecoPorId.buscarEnderecoPorId(endereco.getIdEstabelecimento()))) {
            throw new NoSuchElementException("Endereco não encontrado");
        }
        if (!endereco.isValid()) {
            throw new IllegalStateException("Dados obrigatórios estão nulos, preencha-os corretamente");
        }
        return editarEndereco.editarEndereco(endereco);
    }
}

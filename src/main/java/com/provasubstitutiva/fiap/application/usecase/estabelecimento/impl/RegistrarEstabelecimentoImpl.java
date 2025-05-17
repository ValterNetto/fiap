package com.provasubstitutiva.fiap.application.usecase.estabelecimento.impl;

import com.provasubstitutiva.fiap.application.usecase.endereco.BuscarEnderecoPorIdEstabelecimento;
import com.provasubstitutiva.fiap.application.usecase.estabelecimento.BuscarEstabelecimentoPorId;
import com.provasubstitutiva.fiap.application.usecase.estabelecimento.RegistrarEstabelecimento;
import com.provasubstitutiva.fiap.domain.model.Estabelecimento;

import java.util.NoSuchElementException;
import java.util.Objects;

public class RegistrarEstabelecimentoImpl {

    private final RegistrarEstabelecimento registrarEstabelecimento;
    private final BuscarEstabelecimentoPorId buscarEstabelecimentoPorId;
    private final BuscarEnderecoPorIdEstabelecimento buscarEnderecoPorIdEstabelecimento;

    public RegistrarEstabelecimentoImpl(RegistrarEstabelecimento registrarEstabelecimento, BuscarEstabelecimentoPorId buscarEstabelecimentoPorId, BuscarEnderecoPorIdEstabelecimento buscarEnderecoPorIdEstabelecimento) {
        this.registrarEstabelecimento = registrarEstabelecimento;
        this.buscarEstabelecimentoPorId = buscarEstabelecimentoPorId;
        this.buscarEnderecoPorIdEstabelecimento = buscarEnderecoPorIdEstabelecimento;
    }

    public Estabelecimento registrarEstabelecimento(Estabelecimento estabelecimento) {
        if (Objects.nonNull(buscarEstabelecimentoPorId.buscarEstabelecimentoPorId(estabelecimento.getId()))) {
            throw new NoSuchElementException("Estabelecimento já registrado");
        }
        if (Objects.isNull(buscarEnderecoPorIdEstabelecimento.buscarPorIdEstabelecimento(estabelecimento.getId()))) {
            throw new IllegalStateException("Informe um id de endereço existente");
        }
        return registrarEstabelecimento.registrarEstabelecimento(estabelecimento);
    }
}

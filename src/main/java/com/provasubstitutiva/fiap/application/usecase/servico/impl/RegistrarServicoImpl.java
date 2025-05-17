package com.provasubstitutiva.fiap.application.usecase.servico.impl;

import com.provasubstitutiva.fiap.application.usecase.estabelecimento.BuscarEstabelecimentoPorId;
import com.provasubstitutiva.fiap.application.usecase.servico.RegistrarServico;
import com.provasubstitutiva.fiap.domain.model.Servico;

import java.util.NoSuchElementException;
import java.util.Objects;

public class RegistrarServicoImpl {

    private final RegistrarServico registrarServico;
    private final BuscarEstabelecimentoPorId buscarEstabelecimentoPorId;

    public RegistrarServicoImpl(RegistrarServico registrarServico, BuscarEstabelecimentoPorId buscarEstabelecimentoPorId) {
        this.registrarServico = registrarServico;
        this.buscarEstabelecimentoPorId = buscarEstabelecimentoPorId;
    }

    public Servico registrarServico(Servico servico) {
        if (Objects.isNull(buscarEstabelecimentoPorId.buscarEstabelecimentoPorId(servico.getIdEstabelecimento()))) {
            throw new NoSuchElementException("Estabelecimento não encontrado");
        }
        return registrarServico.registrarServico(servico);
    }
}

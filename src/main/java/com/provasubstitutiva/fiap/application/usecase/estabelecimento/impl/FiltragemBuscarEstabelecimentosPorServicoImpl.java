package com.provasubstitutiva.fiap.application.usecase.estabelecimento.impl;

import com.provasubstitutiva.fiap.application.usecase.estabelecimento.BuscarEstabelecimentoPorId;
import com.provasubstitutiva.fiap.application.usecase.servico.BuscarServicoPorNome;
import com.provasubstitutiva.fiap.domain.model.Estabelecimento;

import java.util.List;

public class FiltragemBuscarEstabelecimentosPorServicoImpl {

    private final BuscarServicoPorNome buscarServicoPorNome;
    private final BuscarEstabelecimentoPorId buscarEstabelecimentoPorId;

    public FiltragemBuscarEstabelecimentosPorServicoImpl(BuscarServicoPorNome buscarServicoPorNome, BuscarEstabelecimentoPorId buscarEstabelecimentoPorId) {
        this.buscarServicoPorNome = buscarServicoPorNome;
        this.buscarEstabelecimentoPorId = buscarEstabelecimentoPorId;
    }

    public List<Estabelecimento> buscarEstabelecimentosPorServico(String nomeServico) {
        return buscarServicoPorNome.buscarServicoPorNome(nomeServico)
                .stream()
                .map(servico -> buscarEstabelecimentoPorId.buscarEstabelecimentoPorId(servico.getIdEstabelecimento()))
                .toList();
    }
}

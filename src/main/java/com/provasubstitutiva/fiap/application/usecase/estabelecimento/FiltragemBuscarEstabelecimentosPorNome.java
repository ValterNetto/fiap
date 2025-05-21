package com.provasubstitutiva.fiap.application.usecase.estabelecimento;

import com.provasubstitutiva.fiap.domain.model.Estabelecimento;

import java.util.List;

public interface FiltragemBuscarEstabelecimentosPorNome {
    List<Estabelecimento> buscarPorNome(String nome);
}

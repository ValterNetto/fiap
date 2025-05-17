package com.provasubstitutiva.fiap.application.usecase.avaliacao;

import com.provasubstitutiva.fiap.domain.model.Avaliacao;

import java.util.List;

public interface BuscarPorIdEstabelecimento {
    List<Avaliacao> buscarPorIdEstabelecimento(Long idEstabelecimento);
}

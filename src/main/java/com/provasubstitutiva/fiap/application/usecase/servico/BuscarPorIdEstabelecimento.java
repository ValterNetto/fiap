package com.provasubstitutiva.fiap.application.usecase.servico;

import com.provasubstitutiva.fiap.domain.model.Servico;

import java.util.List;

public interface BuscarPorIdEstabelecimento {

    List<Servico> buscarPorIdEstabelecimento(Long id);
}

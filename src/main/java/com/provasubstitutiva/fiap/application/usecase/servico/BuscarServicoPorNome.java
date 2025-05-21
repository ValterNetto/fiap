package com.provasubstitutiva.fiap.application.usecase.servico;

import com.provasubstitutiva.fiap.domain.model.Servico;

import java.util.List;

public interface BuscarServicoPorNome {
    List<Servico> buscarServicoPorNome(String nome);
}

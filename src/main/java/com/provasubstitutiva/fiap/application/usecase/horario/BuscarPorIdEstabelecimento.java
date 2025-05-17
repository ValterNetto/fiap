package com.provasubstitutiva.fiap.application.usecase.horario;

import com.provasubstitutiva.fiap.domain.model.Horario;

import java.util.List;

public interface BuscarPorIdEstabelecimento {

    List<Horario> buscarPorIdEstabelecimento(Long idEstabelecimento);
}

package com.provasubstitutiva.fiap.application.usecase.foto;

import com.provasubstitutiva.fiap.domain.model.Foto;

import java.util.List;

public interface BuscarFotosPorIdEstabelecimento {
    List<Foto> buscarFotoPorIdEstabelecimento(Long idEstabelecimento);
}

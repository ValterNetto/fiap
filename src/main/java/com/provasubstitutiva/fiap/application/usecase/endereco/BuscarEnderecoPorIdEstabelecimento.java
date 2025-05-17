package com.provasubstitutiva.fiap.application.usecase.endereco;

import com.provasubstitutiva.fiap.domain.model.Endereco;

public interface BuscarEnderecoPorIdEstabelecimento {
    Endereco buscarPorIdEstabelecimento(Long id);
}

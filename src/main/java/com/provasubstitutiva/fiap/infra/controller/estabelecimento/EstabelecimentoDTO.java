package com.provasubstitutiva.fiap.infra.controller.estabelecimento;

import com.provasubstitutiva.fiap.domain.model.Estabelecimento;

public record EstabelecimentoDTO(
        Long id,
        String nome,
        Long idEndereco,
        String email
) {

    public EstabelecimentoDTO(Estabelecimento estabelecimento){
        this(
        estabelecimento.getId(),
        estabelecimento.getNome(),
        estabelecimento.getIdEndereco(),
        estabelecimento.getEmail()
        );
    }
}

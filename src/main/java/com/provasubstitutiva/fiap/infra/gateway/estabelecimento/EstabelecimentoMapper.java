package com.provasubstitutiva.fiap.infra.gateway.estabelecimento;

import com.provasubstitutiva.fiap.domain.model.Estabelecimento;
import com.provasubstitutiva.fiap.infra.persistence.estabelecimento.EstabelecimentoEntity;

public class EstabelecimentoMapper {

    public Estabelecimento toDomain(EstabelecimentoEntity in){
        return new Estabelecimento(
        in.getId(),
        in.getNome(),
        in.getIdEndereco(),
        in.getEmail()
        );
    }

    public EstabelecimentoEntity toEntity(Estabelecimento in){
        return new EstabelecimentoEntity(
                in.getId(),
                in.getNome(),
                in.getIdEndereco(),
                in.getEmail()
        );
    }
}

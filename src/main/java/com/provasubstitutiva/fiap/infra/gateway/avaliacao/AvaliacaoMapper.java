package com.provasubstitutiva.fiap.infra.gateway.avaliacao;

import com.provasubstitutiva.fiap.domain.model.Avaliacao;
import com.provasubstitutiva.fiap.infra.persistence.avaliacao.AvaliacaoEntity;

public class AvaliacaoMapper {

    public Avaliacao toDomain(AvaliacaoEntity in) {
        return new Avaliacao(
                in.getId(),
                in.getIdCliente(),
                in.getEstrelas(),
                in.getComentario(),
                in.getIdEstabelecimento(),
                in.getIdProfissional()
        );
    }

    public AvaliacaoEntity toEntity(Avaliacao in) {
        return new AvaliacaoEntity(
                in.getId(),
                in.getIdCliente(),
                in.getEstrelas(),
                in.getComentario(),
                in.getIdEstabelecimento(),
                in.getIdProfissional()
        );
    }
}

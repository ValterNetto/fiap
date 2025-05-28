package com.provasubstitutiva.fiap.infra.gateway.servico;

import com.provasubstitutiva.fiap.domain.model.Servico;
import com.provasubstitutiva.fiap.infra.persistence.servico.ServicoEntity;

public class ServicoMapper {

    public Servico toDomain(ServicoEntity in) {
        return new Servico(
        in.getId(),
        in.getNome(),
        in.getValor(),
        in.getIdEstabelecimento()
        );
    }

    public ServicoEntity toEntity(Servico in) {
        return new ServicoEntity(
                in.getId(),
                in.getNome(),
                in.getValor(),
                in.getIdEstabelecimento()
        );
    }
}

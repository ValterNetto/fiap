package com.provasubstitutiva.fiap.infra.gateway.endereco;

import com.provasubstitutiva.fiap.domain.model.Endereco;
import com.provasubstitutiva.fiap.infra.persistence.endereco.EnderecoEntity;

public class EnderecoMapper {

    public Endereco toDomain(EnderecoEntity in){
        return new Endereco(
        in.getId(),
        in.getLogradouro(),
        in.getCep(),
        in.getNumero(),
        in.getLatitude(),
        in.getLongitude(),
        in.getIdEstabelecimento()
        );
    }

    public EnderecoEntity toEntity(Endereco in){
        return new EnderecoEntity(
                in.getId(),
                in.getLogradouro(),
                in.getCep(),
                in.getNumero(),
                in.getLatitude(),
                in.getLongitude(),
                in.getIdEstabelecimento()
        );
    }
}

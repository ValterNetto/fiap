package com.provasubstitutiva.fiap.infra.controller.endereco;

import com.provasubstitutiva.fiap.domain.model.Endereco;

public record EnderecoDTO(
        Long id,
        String logradouro,
        String cep,
        String numero,
        double latitude,
        double longitude,
        Long idEstabelecimento
) {
    public EnderecoDTO(Endereco endereco){
        this(endereco.getId(),
        endereco.getLogradouro(),
        endereco.getCep(),
        endereco.getNumero(),
        endereco.getLatitude(),
        endereco.getLongitude(),
        endereco.getIdEstabelecimento());
    }
}

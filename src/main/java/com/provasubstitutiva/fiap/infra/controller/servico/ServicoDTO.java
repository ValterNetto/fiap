package com.provasubstitutiva.fiap.infra.controller.servico;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.provasubstitutiva.fiap.domain.model.Servico;

public record ServicoDTO(
        Long id,
        String nome,
        int valor,
        Long idEstabelecimento
) {
    @JsonCreator
    public ServicoDTO(
            @JsonProperty("id") Long id,
            @JsonProperty("nome") String nome,
            @JsonProperty("valor") int valor,
            @JsonProperty("idEstabelecimento") Long idEstabelecimento
    ) {
        this.id = id;
        this.nome = nome;
        this.valor = valor;
        this.idEstabelecimento = idEstabelecimento;
    }

    public ServicoDTO(Servico servico) {
        this(
                servico.getId(),
                servico.getNome(),
                servico.getValor(),
                servico.getIdEstabelecimento()
        );
    }
}

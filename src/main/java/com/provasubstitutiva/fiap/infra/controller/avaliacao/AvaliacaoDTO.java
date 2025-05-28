package com.provasubstitutiva.fiap.infra.controller.avaliacao;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.provasubstitutiva.fiap.domain.model.Avaliacao;

public record AvaliacaoDTO(
        Long id,
        Long idCliente,
        int estrelas,
        String comentario,
        Long idEstabelecimento,
        Long idProfissional
) {
    @JsonCreator
    public AvaliacaoDTO(
            @JsonProperty("id") Long id,
            @JsonProperty("idCliente") Long idCliente,
            @JsonProperty("estrelas") int estrelas,
            @JsonProperty("comentario") String comentario,
            @JsonProperty("idEstabelecimento") Long idEstabelecimento,
            @JsonProperty("idProfissional") Long idProfissional
    ) {
        this.id = id;
        this.idCliente = idCliente;
        this.estrelas = estrelas;
        this.comentario = comentario;
        this.idEstabelecimento = idEstabelecimento;
        this.idProfissional = idProfissional;
    }

    public AvaliacaoDTO(Avaliacao avaliacao) {
        this(
                avaliacao.getId(),
                avaliacao.getIdCliente(),
                avaliacao.getEstrelas(),
                avaliacao.getComentario(),
                avaliacao.getIdEstabelecimento(),
                avaliacao.getIdProfissional()
        );
    }
}

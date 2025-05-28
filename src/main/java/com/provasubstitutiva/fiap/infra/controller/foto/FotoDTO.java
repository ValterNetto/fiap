package com.provasubstitutiva.fiap.infra.controller.foto;

import com.provasubstitutiva.fiap.domain.model.Foto;

public record FotoDTO(
        Long id,
        String nome,
        String foto,
        Long idEstabelecimento
) {

    public FotoDTO(Foto foto){
        this(
        foto.getId(),
        foto.getNome(),
        foto.getFoto(),
        foto.getIdEstabelecimento()
        );
    }
}

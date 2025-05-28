package com.provasubstitutiva.fiap.infra.gateway.foto;

import com.provasubstitutiva.fiap.domain.model.Foto;
import com.provasubstitutiva.fiap.infra.persistence.foto.FotoEntity;

public class FotoMapper {

    public Foto toDomain(FotoEntity in) {
        return new Foto(
        in.getId(),
        in.getNome(),
        in.getFoto(),
        in.getIdEstabelecimento()
        );
    }

    public FotoEntity toEntity(Foto in) {
        return new FotoEntity(
                in.getId(),
                in.getNome(),
                in.getFoto(),
                in.getIdEstabelecimento()
        );
    }
}

package com.provasubstitutiva.fiap.infra.gateway.profissional;

import com.provasubstitutiva.fiap.domain.model.Profissional;
import com.provasubstitutiva.fiap.infra.persistence.profissional.ProfissionalEntity;

public class ProfissionalMapper {

    public Profissional toDomain(ProfissionalEntity in) {
        return new Profissional(
        in.getId(),
        in.getNome(),
        in.getEmail(),
        in.getEspecialidade(),
        in.getTarifaPorHora(),
        in.getIdEstabelecimento()
        );
    }

    public ProfissionalEntity toEntity (Profissional in) {
        return new ProfissionalEntity(
                in.getId(),
                in.getNome(),
                in.getEmail(),
                in.getEspecialidade(),
                in.getTarifaPorHora(),
                in.getIdEstabelecimento()
        );
    }
}

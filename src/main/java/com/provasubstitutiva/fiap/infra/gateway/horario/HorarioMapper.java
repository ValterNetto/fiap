package com.provasubstitutiva.fiap.infra.gateway.horario;

import com.provasubstitutiva.fiap.domain.model.Horario;
import com.provasubstitutiva.fiap.domain.model.constant.DiasDaSemanaEnum;
import com.provasubstitutiva.fiap.infra.persistence.horario.HorarioEntity;

import java.time.LocalTime;

public class HorarioMapper {

    public Horario toDomain(HorarioEntity in) {
        return new Horario(
        in.getId(),
        in.getDiaDaSemana(),
        in.getInicio(),
        in.getFim(),
        in.getIdEstabelecimento()
        );
    }

    public HorarioEntity toEntity(Horario in) {
        return new HorarioEntity(
                in.getId(),
                in.getDiaDaSemana(),
                in.getInicio(),
                in.getFim(),
                in.getIdEstabelecimento()
        );
    }
}

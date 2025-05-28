package com.provasubstitutiva.fiap.infra.controller.horario;

import com.provasubstitutiva.fiap.domain.model.Horario;
import com.provasubstitutiva.fiap.domain.model.constant.DiasDaSemanaEnum;

import java.time.LocalTime;

public record HorarioDTO(
        Long id,
        DiasDaSemanaEnum diaDaSemana,
        LocalTime inicio,
        LocalTime fim,
        Long idEstabelecimento
) {

    public HorarioDTO(Horario horario) {
        this(
                horario.getId(),
                horario.getDiaDaSemana(),
                horario.getInicio(),
                horario.getFim(),
                horario.getIdEstabelecimento()
        );
    }
}

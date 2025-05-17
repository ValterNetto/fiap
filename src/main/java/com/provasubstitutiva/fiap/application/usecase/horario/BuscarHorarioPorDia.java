package com.provasubstitutiva.fiap.application.usecase.horario;

import com.provasubstitutiva.fiap.domain.model.constant.DiasDaSemanaEnum;
import com.provasubstitutiva.fiap.domain.model.Horario;

public interface BuscarHorarioPorDia {
    Horario buscarHorarioPorDia(Long idEstabelecimento, DiasDaSemanaEnum dia);
}

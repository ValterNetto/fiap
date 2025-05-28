package com.provasubstitutiva.fiap.infra.gateway.agendamento;

import com.provasubstitutiva.fiap.domain.model.Agendamento;
import com.provasubstitutiva.fiap.infra.persistence.agendamento.AgendamentoEntity;

public class AgendamentoMapper {

    public Agendamento toDomain(AgendamentoEntity in) {
        return new Agendamento(
        in.getId(),
        in.getIdProfissional(),
        in.getIdEstabelecimento(),
        in.getIdCliente(),
        in.getIdServico(),
        in.getStatus(),
        in.getData(),
        in.getHoraInicio(),
        in.getHoraTermino()
        );
    }

    public AgendamentoEntity toEntity(Agendamento in) {
        return new AgendamentoEntity(
                in.getId(),
                in.getIdProfissional(),
                in.getIdEstabelecimento(),
                in.getIdCliente(),
                in.getIdServico(),
                in.getStatus(),
                in.getData(),
                in.getHoraInicio(),
                in.getHoraTermino()
        );
    }
}

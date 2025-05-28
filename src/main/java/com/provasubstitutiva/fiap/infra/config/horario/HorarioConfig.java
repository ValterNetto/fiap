package com.provasubstitutiva.fiap.infra.config.horario;

import com.provasubstitutiva.fiap.application.usecase.estabelecimento.BuscarEstabelecimentoPorId;
import com.provasubstitutiva.fiap.application.usecase.horario.BuscarHorariosPorIdEstabelecimento;
import com.provasubstitutiva.fiap.application.usecase.horario.CadastrarHorario;
import com.provasubstitutiva.fiap.application.usecase.horario.ExcluirHorario;
import com.provasubstitutiva.fiap.application.usecase.horario.impl.BuscarHorariosPorIdEstabelecimentoImpl;
import com.provasubstitutiva.fiap.application.usecase.horario.impl.CadastrarHorarioImpl;
import com.provasubstitutiva.fiap.application.usecase.horario.impl.ExcluirHorarioImpl;
import com.provasubstitutiva.fiap.infra.gateway.horario.HorarioJPAAdapter;
import com.provasubstitutiva.fiap.infra.gateway.horario.HorarioMapper;
import com.provasubstitutiva.fiap.infra.persistence.horario.HorarioRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HorarioConfig {

    @Bean
    BuscarHorariosPorIdEstabelecimentoImpl buscarHorariosPorIdEstabelecimento(BuscarHorariosPorIdEstabelecimento buscarHorariosPorIdEstabelecimento){
        return new BuscarHorariosPorIdEstabelecimentoImpl(buscarHorariosPorIdEstabelecimento);
    }

    @Bean
    CadastrarHorarioImpl cadastrarHorario(CadastrarHorario cadastrarHorario,
                                                  BuscarEstabelecimentoPorId buscarEstabelecimentoPorId,
                                                  BuscarHorariosPorIdEstabelecimento buscarHorariosPorIdEstabelecimento){
        return new CadastrarHorarioImpl(cadastrarHorario, buscarEstabelecimentoPorId, buscarHorariosPorIdEstabelecimento);
    }

    @Bean
    ExcluirHorarioImpl excluirHorario(ExcluirHorario excluirHorario){
        return new ExcluirHorarioImpl(excluirHorario);
    }

    @Bean
    HorarioJPAAdapter horarioJPAAdapter(HorarioRepository repository, HorarioMapper mapper){
        return new HorarioJPAAdapter(repository, mapper);
    }

    @Bean
    HorarioMapper horarioMapper(){
        return new HorarioMapper();
    }
}

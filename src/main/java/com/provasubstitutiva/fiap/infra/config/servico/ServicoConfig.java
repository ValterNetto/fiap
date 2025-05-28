package com.provasubstitutiva.fiap.infra.config.servico;

import com.provasubstitutiva.fiap.application.usecase.estabelecimento.BuscarEstabelecimentoPorId;
import com.provasubstitutiva.fiap.application.usecase.servico.BuscarPorIdEstabelecimento;
import com.provasubstitutiva.fiap.application.usecase.servico.ExcluirServico;
import com.provasubstitutiva.fiap.application.usecase.servico.RegistrarServico;
import com.provasubstitutiva.fiap.application.usecase.servico.impl.BuscarPorIdEstabelecimentoImpl;
import com.provasubstitutiva.fiap.application.usecase.servico.impl.ExcluirServicoImpl;
import com.provasubstitutiva.fiap.application.usecase.servico.impl.RegistrarServicoImpl;
import com.provasubstitutiva.fiap.infra.gateway.servico.ServicoJPAAdapter;
import com.provasubstitutiva.fiap.infra.gateway.servico.ServicoMapper;
import com.provasubstitutiva.fiap.infra.persistence.servico.ServicoRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServicoConfig {

    @Bean
    BuscarPorIdEstabelecimentoImpl buscarPorIdEstabelecimento(BuscarPorIdEstabelecimento buscarPorIdEstabelecimento) {
        return new BuscarPorIdEstabelecimentoImpl(buscarPorIdEstabelecimento);
    }

    @Bean
    ExcluirServicoImpl excluirServico(ExcluirServico excluirServico) {
        return new ExcluirServicoImpl(excluirServico);
    }

    @Bean
    RegistrarServicoImpl registrarServico(RegistrarServico registrarServico,
                                                  BuscarEstabelecimentoPorId buscarEstabelecimentoPorId){
        return new RegistrarServicoImpl(registrarServico, buscarEstabelecimentoPorId);
    }

    @Bean
    ServicoJPAAdapter servicoJPAAdapter(ServicoRepository repository, ServicoMapper mapper) {
        return new ServicoJPAAdapter(repository, mapper);
    }

    @Bean
    ServicoMapper servicoMapper(){
        return new ServicoMapper();
    }

}

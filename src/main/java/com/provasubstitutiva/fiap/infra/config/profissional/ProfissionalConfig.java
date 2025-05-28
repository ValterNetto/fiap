package com.provasubstitutiva.fiap.infra.config.profissional;

import com.provasubstitutiva.fiap.application.usecase.estabelecimento.BuscarEstabelecimentoPorId;
import com.provasubstitutiva.fiap.application.usecase.profissional.AdmitirProfissional;
import com.provasubstitutiva.fiap.application.usecase.profissional.BuscarProfissionalPorId;
import com.provasubstitutiva.fiap.application.usecase.profissional.EditarProfissional;
import com.provasubstitutiva.fiap.application.usecase.profissional.RegistrarProfissional;
import com.provasubstitutiva.fiap.application.usecase.profissional.impl.AdmitirProfissionalImpl;
import com.provasubstitutiva.fiap.application.usecase.profissional.impl.BuscarProfissionalPorIdImpl;
import com.provasubstitutiva.fiap.application.usecase.profissional.impl.DemitirProfissionalImpl;
import com.provasubstitutiva.fiap.application.usecase.profissional.impl.RegistrarProfissionalImpl;
import com.provasubstitutiva.fiap.infra.gateway.profissional.ProfissionalJPAAdapter;
import com.provasubstitutiva.fiap.infra.gateway.profissional.ProfissionalMapper;
import com.provasubstitutiva.fiap.infra.persistence.profissional.ProfissionalRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProfissionalConfig {

    @Bean
    AdmitirProfissionalImpl admitirProfissional(AdmitirProfissional admitirProfissional,
                                                        BuscarEstabelecimentoPorId buscarEstabelecimentoPorId,
                                                        BuscarProfissionalPorId buscarProfissionalPorId){
        return new AdmitirProfissionalImpl(admitirProfissional, buscarEstabelecimentoPorId, buscarProfissionalPorId);
    }

    @Bean
    BuscarProfissionalPorIdImpl buscarProfissionalPorId(BuscarProfissionalPorId buscarProfissionalPorId) {
        return new BuscarProfissionalPorIdImpl(buscarProfissionalPorId);
    }

    @Bean
    DemitirProfissionalImpl demitirProfissional(BuscarProfissionalPorId buscarProfissionalPorId,
                                                        EditarProfissional editarProfissional) {
        return new DemitirProfissionalImpl(buscarProfissionalPorId, editarProfissional);
    }

    @Bean
    RegistrarProfissionalImpl registrarProfissional(RegistrarProfissional registrarProfissional) {
        return new RegistrarProfissionalImpl(registrarProfissional);
    }

    @Bean
    ProfissionalJPAAdapter profissionalJPAAdapter(ProfissionalRepository repository, ProfissionalMapper mapper){
        return new ProfissionalJPAAdapter(repository, mapper);
    }

    @Bean
    ProfissionalMapper profissionalMapper(){
        return new ProfissionalMapper();
    }
}

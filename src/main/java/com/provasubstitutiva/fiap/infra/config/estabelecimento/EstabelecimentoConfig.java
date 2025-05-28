package com.provasubstitutiva.fiap.infra.config.estabelecimento;

import com.provasubstitutiva.fiap.application.usecase.avaliacao.VerTodasAsAvaliacoes;
import com.provasubstitutiva.fiap.application.usecase.endereco.BuscarEnderecoPorIdEstabelecimento;
import com.provasubstitutiva.fiap.application.usecase.endereco.FiltragemBuscarEstabelecimentosPorLatitudeELongitude;
import com.provasubstitutiva.fiap.application.usecase.estabelecimento.BuscarEstabelecimentoPorId;
import com.provasubstitutiva.fiap.application.usecase.estabelecimento.EditarEstabelecimento;
import com.provasubstitutiva.fiap.application.usecase.estabelecimento.FiltragemBuscarEstabelecimentosPorNome;
import com.provasubstitutiva.fiap.application.usecase.estabelecimento.RegistrarEstabelecimento;
import com.provasubstitutiva.fiap.application.usecase.estabelecimento.impl.*;
import com.provasubstitutiva.fiap.application.usecase.servico.BuscarServicoPorNome;
import com.provasubstitutiva.fiap.infra.gateway.estabelecimento.EstabelecimentoJPAAdapter;
import com.provasubstitutiva.fiap.infra.gateway.estabelecimento.EstabelecimentoMapper;
import com.provasubstitutiva.fiap.infra.persistence.estabelecimento.EstabelecimentoRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EstabelecimentoConfig {

    @Bean
    BuscarEstabelecimentoPorIdImpl buscarEstabelecimentoPorId(BuscarEstabelecimentoPorId buscarEstabelecimentoPorId) {
        return new BuscarEstabelecimentoPorIdImpl(buscarEstabelecimentoPorId);
    }

    @Bean
    EditarEstabelecimentoPorIdImpl editarEstabelecimentoPorId(EditarEstabelecimento editarEstabelecimento,
                                                                      BuscarEstabelecimentoPorId buscarEstabelecimentoPorId) {
        return new EditarEstabelecimentoPorIdImpl(editarEstabelecimento, buscarEstabelecimentoPorId);
    }

    @Bean
    FiltragemBuscarEstabelecimentosPorEstrelasImpl filtragemBuscarEstabelecimentosPorEstrelas(
            VerTodasAsAvaliacoes verTodasAsAvaliacoes,
            BuscarEstabelecimentoPorId buscarEstabelecimentoPorId) {
        return new FiltragemBuscarEstabelecimentosPorEstrelasImpl(verTodasAsAvaliacoes, buscarEstabelecimentoPorId);
    }

    @Bean
    FiltragemBuscarEstabelecimentosPorLatitudeELongitudeImpl filtragemBuscarEstabelecimentosPorLatitudeELongitude(
            FiltragemBuscarEstabelecimentosPorLatitudeELongitude filtragemBuscarEstabelecimentosPorLatitudeELongitude,
            BuscarEstabelecimentoPorId buscarEstabelecimentoPorId) {
        return new FiltragemBuscarEstabelecimentosPorLatitudeELongitudeImpl(
                filtragemBuscarEstabelecimentosPorLatitudeELongitude,
                buscarEstabelecimentoPorId);
    }

    @Bean
    FiltragemBuscarEstabelecimentosPorNomeImpl filtragemBuscarEstabelecimentosPorNome(FiltragemBuscarEstabelecimentosPorNome filtragemBuscarEstabelecimentosPorNome) {
        return new FiltragemBuscarEstabelecimentosPorNomeImpl(filtragemBuscarEstabelecimentosPorNome);
    }

    @Bean
    FiltragemBuscarEstabelecimentosPorServicoImpl filtragemBuscarEstabelecimentosPorServico(
            BuscarServicoPorNome buscarServicoPorNome,
            BuscarEstabelecimentoPorId buscarEstabelecimentoPorId) {
        return new FiltragemBuscarEstabelecimentosPorServicoImpl(
                buscarServicoPorNome,
                buscarEstabelecimentoPorId);
    }

    @Bean
    RegistrarEstabelecimentoImpl registrarEstabelecimento(
            RegistrarEstabelecimento registrarEstabelecimento,
            BuscarEstabelecimentoPorId buscarEstabelecimentoPorId,
            BuscarEnderecoPorIdEstabelecimento buscarEnderecoPorIdEstabelecimento) {

        return new RegistrarEstabelecimentoImpl(registrarEstabelecimento,
                buscarEstabelecimentoPorId,
                buscarEnderecoPorIdEstabelecimento);
    }

    @Bean
    EstabelecimentoJPAAdapter estabelecimentoJPAAdapter(EstabelecimentoRepository repository, EstabelecimentoMapper mapper) {
        return new EstabelecimentoJPAAdapter(repository, mapper);
    }

    @Bean
    EstabelecimentoMapper mapper() {
        return new EstabelecimentoMapper();
    }
}

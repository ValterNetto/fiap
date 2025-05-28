package com.provasubstitutiva.fiap.infra.config.foto;

import com.provasubstitutiva.fiap.application.usecase.estabelecimento.BuscarEstabelecimentoPorId;
import com.provasubstitutiva.fiap.application.usecase.foto.AdicionarFoto;
import com.provasubstitutiva.fiap.application.usecase.foto.BuscarFotosPorIdEstabelecimento;
import com.provasubstitutiva.fiap.application.usecase.foto.ExcluirFoto;
import com.provasubstitutiva.fiap.application.usecase.foto.impl.AdicionarFotoImpl;
import com.provasubstitutiva.fiap.application.usecase.foto.impl.BuscarFotosPorIdEstabelecimentoImpl;
import com.provasubstitutiva.fiap.application.usecase.foto.impl.ExcluirFotoImpl;
import com.provasubstitutiva.fiap.infra.gateway.foto.FotoJPAAdapter;
import com.provasubstitutiva.fiap.infra.gateway.foto.FotoMapper;
import com.provasubstitutiva.fiap.infra.persistence.foto.FotoRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FotoConfig {

    @Bean
    AdicionarFotoImpl adicionarFoto(AdicionarFoto adicionarFoto,
                                            BuscarEstabelecimentoPorId buscarEstabelecimentoPorId) {
        return new AdicionarFotoImpl(adicionarFoto, buscarEstabelecimentoPorId);
    }

    @Bean
    BuscarFotosPorIdEstabelecimentoImpl buscarFotosPorIdEstabelecimento(
            BuscarFotosPorIdEstabelecimento buscarFotosPorIdEstabelecimento
    ) {
        return new BuscarFotosPorIdEstabelecimentoImpl(buscarFotosPorIdEstabelecimento);
    }

    @Bean
    ExcluirFotoImpl excluirFoto(ExcluirFoto excluirFoto) {
        return new ExcluirFotoImpl(excluirFoto);
    }

    @Bean
    FotoJPAAdapter fotoJPAAdapter(FotoRepository repository, FotoMapper mapper) {
        return new FotoJPAAdapter(repository, mapper);
    }

    @Bean
    FotoMapper fotoMapper(){
        return new FotoMapper();
    }
}

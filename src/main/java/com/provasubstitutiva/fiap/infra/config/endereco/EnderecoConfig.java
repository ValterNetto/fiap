package com.provasubstitutiva.fiap.infra.config.endereco;

import com.provasubstitutiva.fiap.application.usecase.endereco.BuscarEnderecoPorId;
import com.provasubstitutiva.fiap.application.usecase.endereco.BuscarEnderecoPorIdEstabelecimento;
import com.provasubstitutiva.fiap.application.usecase.endereco.EditarEndereco;
import com.provasubstitutiva.fiap.application.usecase.endereco.RegistrarEndereco;
import com.provasubstitutiva.fiap.application.usecase.endereco.impl.BuscarEnderecoPorIdImpl;
import com.provasubstitutiva.fiap.application.usecase.endereco.impl.BuscarEnderecoPorIdEstabelecimentoImpl;
import com.provasubstitutiva.fiap.application.usecase.endereco.impl.EditarEnderecoImpl;
import com.provasubstitutiva.fiap.application.usecase.endereco.impl.RegistrarEnderecoImpl;
import com.provasubstitutiva.fiap.application.usecase.estabelecimento.BuscarEstabelecimentoPorId;
import com.provasubstitutiva.fiap.infra.gateway.endereco.EnderecoJPAAdapter;
import com.provasubstitutiva.fiap.infra.gateway.endereco.EnderecoMapper;
import com.provasubstitutiva.fiap.infra.persistence.endereco.EnderecoRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EnderecoConfig {

    @Bean
    BuscarEnderecoPorIdEstabelecimentoImpl buscarPorEnderecoIdEstabelecimento(BuscarEnderecoPorIdEstabelecimento buscarEnderecoPorIdEstabelecimento) {
        return new BuscarEnderecoPorIdEstabelecimentoImpl(buscarEnderecoPorIdEstabelecimento);
    }

    @Bean
    BuscarEnderecoPorIdImpl buscarEnderecoPorId(BuscarEnderecoPorId buscarEnderecoPorId) {
        return new BuscarEnderecoPorIdImpl(buscarEnderecoPorId);
    }

    @Bean
    EditarEnderecoImpl editarEndereco(EditarEndereco editarEndereco, BuscarEnderecoPorId buscarEnderecoPorId) {
        return new EditarEnderecoImpl(editarEndereco, buscarEnderecoPorId);
    }

    @Bean
    RegistrarEnderecoImpl registrarEndereco(BuscarEstabelecimentoPorId buscarEstabelecimentoPorId,
                                            RegistrarEndereco registrarEndereco,
                                            BuscarEnderecoPorIdEstabelecimento buscarEnderecoPorIdEstabelecimento) {
        return new RegistrarEnderecoImpl(buscarEstabelecimentoPorId, registrarEndereco, buscarEnderecoPorIdEstabelecimento);
    }

    @Bean
    EnderecoJPAAdapter enderecoJPAAdapter(EnderecoRepository repository, EnderecoMapper mapper) {
        return new EnderecoJPAAdapter(repository, mapper);
    }

    @Bean
    EnderecoMapper enderecoMapper() {
        return new EnderecoMapper();
    }
}

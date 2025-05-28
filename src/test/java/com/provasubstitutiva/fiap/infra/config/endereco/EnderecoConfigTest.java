package com.provasubstitutiva.fiap.infra.config.endereco;

import com.provasubstitutiva.fiap.application.usecase.endereco.BuscarEnderecoPorId;
import com.provasubstitutiva.fiap.application.usecase.endereco.BuscarEnderecoPorIdEstabelecimento;
import com.provasubstitutiva.fiap.application.usecase.endereco.EditarEndereco;
import com.provasubstitutiva.fiap.application.usecase.endereco.RegistrarEndereco;
import com.provasubstitutiva.fiap.application.usecase.estabelecimento.BuscarEstabelecimentoPorId;
import com.provasubstitutiva.fiap.infra.gateway.endereco.EnderecoJPAAdapter;
import com.provasubstitutiva.fiap.infra.gateway.endereco.EnderecoMapper;
import com.provasubstitutiva.fiap.infra.persistence.endereco.EnderecoRepository;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;

class EnderecoConfigTest {

    private final EnderecoConfig config = new EnderecoConfig();

    @Test
    void deveInstanciarBuscarEnderecoPorIdEstabelecimentoImpl() {
        var impl = config.buscarPorEnderecoIdEstabelecimento(mock(BuscarEnderecoPorIdEstabelecimento.class));
        assertNotNull(impl);
    }

    @Test
    void deveInstanciarBuscarEnderecoPorIdImpl() {
        var impl = config.buscarEnderecoPorId(mock(BuscarEnderecoPorId.class));
        assertNotNull(impl);
    }

    @Test
    void deveInstanciarEditarEnderecoImpl() {
        var impl = config.editarEndereco(
                mock(EditarEndereco.class),
                mock(BuscarEnderecoPorId.class)
        );
        assertNotNull(impl);
    }

    @Test
    void deveInstanciarRegistrarEnderecoImpl() {
        var impl = config.registrarEndereco(
                mock(BuscarEstabelecimentoPorId.class),
                mock(RegistrarEndereco.class),
                mock(BuscarEnderecoPorIdEstabelecimento.class)
        );
        assertNotNull(impl);
    }

    @Test
    void deveInstanciarEnderecoJPAAdapter() {
        var adapter = config.enderecoJPAAdapter(
                mock(EnderecoRepository.class),
                new EnderecoMapper()
        );
        assertNotNull(adapter);
    }

    @Test
    void deveInstanciarEnderecoMapper() {
        var mapper = config.enderecoMapper();
        assertNotNull(mapper);
    }
}

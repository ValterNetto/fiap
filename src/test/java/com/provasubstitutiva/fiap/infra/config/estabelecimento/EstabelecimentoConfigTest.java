package com.provasubstitutiva.fiap.infra.config.estabelecimento;

import com.provasubstitutiva.fiap.application.usecase.avaliacao.VerTodasAsAvaliacoes;
import com.provasubstitutiva.fiap.application.usecase.endereco.BuscarEnderecoPorIdEstabelecimento;
import com.provasubstitutiva.fiap.application.usecase.endereco.FiltragemBuscarEstabelecimentosPorLatitudeELongitude;
import com.provasubstitutiva.fiap.application.usecase.estabelecimento.BuscarEstabelecimentoPorId;
import com.provasubstitutiva.fiap.application.usecase.estabelecimento.EditarEstabelecimento;
import com.provasubstitutiva.fiap.application.usecase.estabelecimento.FiltragemBuscarEstabelecimentosPorNome;
import com.provasubstitutiva.fiap.application.usecase.estabelecimento.RegistrarEstabelecimento;
import com.provasubstitutiva.fiap.application.usecase.servico.BuscarServicoPorNome;
import com.provasubstitutiva.fiap.infra.gateway.estabelecimento.EstabelecimentoMapper;
import com.provasubstitutiva.fiap.infra.persistence.estabelecimento.EstabelecimentoRepository;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;

class EstabelecimentoConfigTest {

    private final EstabelecimentoConfig config = new EstabelecimentoConfig();

    @Test
    void deveInstanciarBuscarEstabelecimentoPorIdImpl() {
        var impl = config.buscarEstabelecimentoPorId(mock(BuscarEstabelecimentoPorId.class));
        assertNotNull(impl);
    }

    @Test
    void deveInstanciarEditarEstabelecimentoPorIdImpl() {
        var impl = config.editarEstabelecimentoPorId(
                mock(EditarEstabelecimento.class),
                mock(BuscarEstabelecimentoPorId.class)
        );
        assertNotNull(impl);
    }

    @Test
    void deveInstanciarFiltragemBuscarEstabelecimentosPorEstrelasImpl() {
        var impl = config.filtragemBuscarEstabelecimentosPorEstrelas(
                mock(VerTodasAsAvaliacoes.class),
                mock(BuscarEstabelecimentoPorId.class)
        );
        assertNotNull(impl);
    }

    @Test
    void deveInstanciarFiltragemBuscarEstabelecimentosPorLatitudeELongitudeImpl() {
        var impl = config.filtragemBuscarEstabelecimentosPorLatitudeELongitude(
                mock(FiltragemBuscarEstabelecimentosPorLatitudeELongitude.class),
                mock(BuscarEstabelecimentoPorId.class)
        );
        assertNotNull(impl);
    }

    @Test
    void deveInstanciarFiltragemBuscarEstabelecimentosPorNomeImpl() {
        var impl = config.filtragemBuscarEstabelecimentosPorNome(
                mock(FiltragemBuscarEstabelecimentosPorNome.class)
        );
        assertNotNull(impl);
    }

    @Test
    void deveInstanciarFiltragemBuscarEstabelecimentosPorServicoImpl() {
        var impl = config.filtragemBuscarEstabelecimentosPorServico(
                mock(BuscarServicoPorNome.class),
                mock(BuscarEstabelecimentoPorId.class)
        );
        assertNotNull(impl);
    }

    @Test
    void deveInstanciarRegistrarEstabelecimentoImpl() {
        var impl = config.registrarEstabelecimento(
                mock(RegistrarEstabelecimento.class),
                mock(BuscarEstabelecimentoPorId.class),
                mock(BuscarEnderecoPorIdEstabelecimento.class)
        );
        assertNotNull(impl);
    }

    @Test
    void deveInstanciarEstabelecimentoJPAAdapter() {
        var impl = config.estabelecimentoJPAAdapter(
                mock(EstabelecimentoRepository.class),
                new EstabelecimentoMapper()
        );
        assertNotNull(impl);
    }

    @Test
    void deveInstanciarEstabelecimentoMapper() {
        assertNotNull(config.mapper());
    }
}

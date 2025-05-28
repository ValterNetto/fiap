package com.provasubstitutiva.fiap.infra.config.avaliacao;

import com.provasubstitutiva.fiap.application.usecase.agendamento.BuscarAgendamentosPorCliente;
import com.provasubstitutiva.fiap.application.usecase.avaliacao.*;
import com.provasubstitutiva.fiap.application.usecase.avaliacao.impl.*;
import com.provasubstitutiva.fiap.application.usecase.cliente.BuscarClientePorId;
import com.provasubstitutiva.fiap.application.usecase.estabelecimento.BuscarEstabelecimentoPorId;
import com.provasubstitutiva.fiap.application.usecase.profissional.BuscarProfissionalPorId;
import com.provasubstitutiva.fiap.infra.gateway.avaliacao.AvaliacaoJPAAdapter;
import com.provasubstitutiva.fiap.infra.gateway.avaliacao.AvaliacaoMapper;
import com.provasubstitutiva.fiap.infra.persistence.avaliacao.AvaliacaoRepository;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;

class AvaliacaoConfigTest {

    private final AvaliacaoConfig config = new AvaliacaoConfig();

    @Test
    void deveInstanciarAvaliarEstabelecimentoImpl() {
        var usecase = config.avaliarEstabelecimento(
                mock(AvaliarEstabelecimento.class),
                mock(BuscarClientePorId.class),
                mock(BuscarEstabelecimentoPorId.class),
                mock(BuscarAgendamentosPorCliente.class)
        );
        assertNotNull(usecase);
    }

    @Test
    void deveInstanciarAvaliarProfissionalImpl() {
        var usecase = config.avaliarProfissional(
                mock(AvaliarProfissional.class),
                mock(BuscarClientePorId.class),
                mock(BuscarProfissionalPorId.class),
                mock(BuscarAgendamentosPorCliente.class)
        );
        assertNotNull(usecase);
    }

    @Test
    void deveInstanciarBuscarAvaliacoesPorIdClienteImpl() {
        var usecase = config.buscarAvaliacoesPorIdCliente(mock(BuscarAvaliacoesPorIdCliente.class));
        assertNotNull(usecase);
    }

    @Test
    void deveInstanciarBuscarAvaliacoesPorIdEstabelecimentoImpl() {
        var usecase = config.buscarAvaliacoesPorIdEstabalecimento(mock(BuscarAvaliacoesPorIdEstabelecimento.class));
        assertNotNull(usecase);
    }

    @Test
    void deveInstanciarEditarAvaliacaoImpl() {
        var usecase = config.editarAvaliacao(
                mock(EditarAvaliacao.class),
                mock(BuscarAvaliacaoPorId.class)
        );
        assertNotNull(usecase);
    }

    @Test
    void deveInstanciarExcluirAvaliacaoImpl() {
        var usecase = config.excluirAvaliacao(mock(ExcluirAvaliacao.class));
        assertNotNull(usecase);
    }

    @Test
    void deveInstanciarAvaliacaoJPAAdapter() {
        var usecase = config.avaliacaoJPAAdapter(
                mock(AvaliacaoRepository.class),
                new AvaliacaoMapper()
        );
        assertNotNull(usecase);
    }

    @Test
    void deveInstanciarAvaliacaoMapper() {
        var usecase = config.avaliacaoMapper();
        assertNotNull(usecase);
    }
}

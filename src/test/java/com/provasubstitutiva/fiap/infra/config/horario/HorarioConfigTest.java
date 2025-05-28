package com.provasubstitutiva.fiap.infra.config.horario;

import com.provasubstitutiva.fiap.application.usecase.estabelecimento.BuscarEstabelecimentoPorId;
import com.provasubstitutiva.fiap.application.usecase.horario.BuscarHorariosPorIdEstabelecimento;
import com.provasubstitutiva.fiap.application.usecase.horario.CadastrarHorario;
import com.provasubstitutiva.fiap.application.usecase.horario.ExcluirHorario;
import com.provasubstitutiva.fiap.infra.gateway.horario.HorarioMapper;
import com.provasubstitutiva.fiap.infra.persistence.horario.HorarioRepository;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;

class HorarioConfigTest {

    private final HorarioConfig config = new HorarioConfig();

    @Test
    void deveInstanciarBuscarHorariosPorIdEstabelecimentoImpl() {
        var impl = config.buscarHorariosPorIdEstabelecimento(
                mock(BuscarHorariosPorIdEstabelecimento.class)
        );
        assertNotNull(impl);
    }

    @Test
    void deveInstanciarCadastrarHorarioImpl() {
        var impl = config.cadastrarHorario(
                mock(CadastrarHorario.class),
                mock(BuscarEstabelecimentoPorId.class),
                mock(BuscarHorariosPorIdEstabelecimento.class)
        );
        assertNotNull(impl);
    }

    @Test
    void deveInstanciarExcluirHorarioImpl() {
        var impl = config.excluirHorario(
                mock(ExcluirHorario.class)
        );
        assertNotNull(impl);
    }

    @Test
    void deveInstanciarHorarioJPAAdapter() {
        var impl = config.horarioJPAAdapter(
                mock(HorarioRepository.class),
                new HorarioMapper()
        );
        assertNotNull(impl);
    }

    @Test
    void deveInstanciarHorarioMapper() {
        assertNotNull(config.horarioMapper());
    }
}

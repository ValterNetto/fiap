package com.provasubstitutiva.fiap.infra.config.profissional;

import com.provasubstitutiva.fiap.application.usecase.estabelecimento.BuscarEstabelecimentoPorId;
import com.provasubstitutiva.fiap.application.usecase.profissional.AdmitirProfissional;
import com.provasubstitutiva.fiap.application.usecase.profissional.BuscarProfissionalPorId;
import com.provasubstitutiva.fiap.application.usecase.profissional.EditarProfissional;
import com.provasubstitutiva.fiap.application.usecase.profissional.RegistrarProfissional;
import com.provasubstitutiva.fiap.infra.gateway.profissional.ProfissionalMapper;
import com.provasubstitutiva.fiap.infra.persistence.profissional.ProfissionalRepository;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;

class ProfissionalConfigTest {

    private final ProfissionalConfig config = new ProfissionalConfig();

    @Test
    void deveInstanciarAdmitirProfissionalImpl() {
        var bean = config.admitirProfissional(
                mock(AdmitirProfissional.class),
                mock(BuscarEstabelecimentoPorId.class),
                mock(BuscarProfissionalPorId.class)
        );
        assertNotNull(bean);
    }

    @Test
    void deveInstanciarBuscarProfissionalPorIdImpl() {
        var bean = config.buscarProfissionalPorId(mock(BuscarProfissionalPorId.class));
        assertNotNull(bean);
    }

    @Test
    void deveInstanciarDemitirProfissionalImpl() {
        var bean = config.demitirProfissional(
                mock(BuscarProfissionalPorId.class),
                mock(EditarProfissional.class)
        );
        assertNotNull(bean);
    }

    @Test
    void deveInstanciarRegistrarProfissionalImpl() {
        var bean = config.registrarProfissional(mock(RegistrarProfissional.class));
        assertNotNull(bean);
    }

    @Test
    void deveInstanciarProfissionalJPAAdapter() {
        var bean = config.profissionalJPAAdapter(
                mock(ProfissionalRepository.class),
                new ProfissionalMapper()
        );
        assertNotNull(bean);
    }

    @Test
    void deveInstanciarProfissionalMapper() {
        assertNotNull(config.profissionalMapper());
    }
}

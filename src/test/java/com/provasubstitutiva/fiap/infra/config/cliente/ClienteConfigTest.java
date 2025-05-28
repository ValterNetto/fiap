package com.provasubstitutiva.fiap.infra.config.cliente;

import com.provasubstitutiva.fiap.application.usecase.cliente.BuscarClientePorId;
import com.provasubstitutiva.fiap.application.usecase.cliente.EditarCliente;
import com.provasubstitutiva.fiap.application.usecase.cliente.RegistrarCliente;
import com.provasubstitutiva.fiap.infra.gateway.cliente.ClienteJPAAdapter;
import com.provasubstitutiva.fiap.infra.gateway.cliente.ClienteMapper;
import com.provasubstitutiva.fiap.infra.persistence.cliente.ClienteRepository;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;

class ClienteConfigTest {

    private final ClienteConfig config = new ClienteConfig();

    @Test
    void deveInstanciarBuscarClientePorIdImpl() {
        var usecase = config.buscarClientePorId(mock(BuscarClientePorId.class));
        assertNotNull(usecase);
    }

    @Test
    void deveInstanciarEditarClienteImpl() {
        var usecase = config.editarCliente(
                mock(EditarCliente.class),
                mock(BuscarClientePorId.class)
        );
        assertNotNull(usecase);
    }

    @Test
    void deveInstanciarRegistrarClienteImpl() {
        var usecase = config.registrarCliente(mock(RegistrarCliente.class));
        assertNotNull(usecase);
    }

    @Test
    void deveInstanciarClienteJPAAdapter() {
        var usecase = config.clienteJPAAdapter(
                mock(ClienteRepository.class),
                new ClienteMapper()
        );
        assertNotNull(usecase);
    }

    @Test
    void deveInstanciarClienteMapper() {
        var mapper = config.clienteMapper();
        assertNotNull(mapper);
    }
}

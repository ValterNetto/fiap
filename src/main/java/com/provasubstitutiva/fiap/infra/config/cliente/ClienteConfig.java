package com.provasubstitutiva.fiap.infra.config.cliente;

import com.provasubstitutiva.fiap.application.usecase.cliente.BuscarClientePorId;
import com.provasubstitutiva.fiap.application.usecase.cliente.EditarCliente;
import com.provasubstitutiva.fiap.application.usecase.cliente.RegistrarCliente;
import com.provasubstitutiva.fiap.application.usecase.cliente.impl.BuscarClientePorIdImpl;
import com.provasubstitutiva.fiap.application.usecase.cliente.impl.EditarClienteImpl;
import com.provasubstitutiva.fiap.application.usecase.cliente.impl.RegistrarClienteImpl;
import com.provasubstitutiva.fiap.infra.gateway.cliente.ClienteJPAAdapter;
import com.provasubstitutiva.fiap.infra.gateway.cliente.ClienteMapper;
import com.provasubstitutiva.fiap.infra.persistence.cliente.ClienteRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ClienteConfig {

    @Bean
    public BuscarClientePorIdImpl buscarClientePorId(BuscarClientePorId buscarClientePorId) {
        return new BuscarClientePorIdImpl(buscarClientePorId);
    }

    @Bean
    public EditarClienteImpl editarCliente(EditarCliente editarCliente, BuscarClientePorId buscarClientePorId) {
        return new EditarClienteImpl(editarCliente, buscarClientePorId);
    }

    @Bean
    public RegistrarClienteImpl registrarCliente(RegistrarCliente registrarCliente) {
        return new RegistrarClienteImpl(registrarCliente);
    }

    @Bean
    public ClienteJPAAdapter clienteJPAAdapter(ClienteRepository repository, ClienteMapper mapper) {
        return new ClienteJPAAdapter(repository, mapper);
    }

    @Bean
    ClienteMapper clienteMapper() {
        return new ClienteMapper();
    }
}

package com.provasubstitutiva.fiap.infra.controller.cliente;

import com.provasubstitutiva.fiap.application.usecase.cliente.impl.BuscarClientePorIdImpl;
import com.provasubstitutiva.fiap.application.usecase.cliente.impl.EditarClienteImpl;
import com.provasubstitutiva.fiap.application.usecase.cliente.impl.RegistrarClienteImpl;
import com.provasubstitutiva.fiap.domain.model.Cliente;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clientes")
@AllArgsConstructor
public class ClienteController {

    private final BuscarClientePorIdImpl buscarClientePorId;
    private final EditarClienteImpl editarCliente;
    private final RegistrarClienteImpl registrarCliente;

    @GetMapping("/{id}")
    public ClienteDTO buscarClientePorId(@PathVariable Long id) {
        Cliente cliente = buscarClientePorId.buscarClientePorId(id);
        return new ClienteDTO(
                cliente.getId(),
                cliente.getNome(),
                cliente.getEmail()
        );
    }

    @PutMapping
    public ClienteDTO editarCliente(@RequestBody ClienteDTO clienteDTO) {
        Cliente cliente = editarCliente.editar(
                new Cliente(
                        clienteDTO.id(),
                        clienteDTO.nome(),
                        clienteDTO.email()
                )
        );
        return new ClienteDTO(cliente);
    }

    @PostMapping
    public ClienteDTO registrarCliente(@RequestBody ClienteDTO clienteDTO) {
        Cliente cliente =
                registrarCliente.registrarCliente(
                        new Cliente(
                                clienteDTO.id(),
                                clienteDTO.nome(),
                                clienteDTO.email()
                        )
                );
        return new ClienteDTO(cliente);
    }
}

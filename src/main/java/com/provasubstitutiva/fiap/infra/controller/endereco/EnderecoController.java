package com.provasubstitutiva.fiap.infra.controller.endereco;

import com.provasubstitutiva.fiap.application.usecase.endereco.impl.BuscarEnderecoPorIdEstabelecimentoImpl;
import com.provasubstitutiva.fiap.application.usecase.endereco.impl.BuscarEnderecoPorIdImpl;
import com.provasubstitutiva.fiap.application.usecase.endereco.impl.EditarEnderecoImpl;
import com.provasubstitutiva.fiap.application.usecase.endereco.impl.RegistrarEnderecoImpl;
import com.provasubstitutiva.fiap.domain.model.Endereco;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/enderecos")
@AllArgsConstructor
public class EnderecoController {

    private final BuscarEnderecoPorIdEstabelecimentoImpl buscarEnderecoPorIdEstabelecimento;
    private final BuscarEnderecoPorIdImpl buscarEnderecoPorId;
    private final EditarEnderecoImpl editarEndereco;
    private final RegistrarEnderecoImpl registrarEndereco;

    @GetMapping("/estabelecimento/{id}")
    public EnderecoDTO buscarEnderecosPorIdEstabelecimento(@PathVariable Long id) {
        return new EnderecoDTO(buscarEnderecoPorIdEstabelecimento.buscarPorIdEstabelecimento(id));
    }

    @GetMapping("/{id}")
    public EnderecoDTO buscarEnderecosPorId(@PathVariable Long id) {
        return new EnderecoDTO(buscarEnderecoPorId.buscarEnderecoPorId(id));
    }

    @PutMapping
    public EnderecoDTO editarEndereco(@RequestBody EnderecoDTO enderecoDTO) {
        return new EnderecoDTO(editarEndereco.editarEndereco(
                new Endereco(
                        enderecoDTO.id(),
                        enderecoDTO.logradouro(),
                        enderecoDTO.cep(),
                        enderecoDTO.numero(),
                        enderecoDTO.latitude(),
                        enderecoDTO.longitude(),
                        enderecoDTO.idEstabelecimento()
                )
        ));
    }

    @PostMapping
    public EnderecoDTO registrarEndereco(@RequestBody EnderecoDTO enderecoDTO) {
        return new EnderecoDTO(registrarEndereco.registrarEndereco(
                new Endereco(
                        enderecoDTO.id(),
                        enderecoDTO.logradouro(),
                        enderecoDTO.cep(),
                        enderecoDTO.numero(),
                        enderecoDTO.latitude(),
                        enderecoDTO.longitude(),
                        enderecoDTO.idEstabelecimento()
                )
        ));
    }
}

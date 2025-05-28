package com.provasubstitutiva.fiap.infra.controller.servico;

import com.provasubstitutiva.fiap.application.usecase.servico.impl.BuscarPorIdEstabelecimentoImpl;
import com.provasubstitutiva.fiap.application.usecase.servico.impl.ExcluirServicoImpl;
import com.provasubstitutiva.fiap.application.usecase.servico.impl.RegistrarServicoImpl;
import com.provasubstitutiva.fiap.domain.model.Servico;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/servicos")
@AllArgsConstructor
public class ServicoController {

    private final BuscarPorIdEstabelecimentoImpl buscarPorIdEstabelecimento;
    private final ExcluirServicoImpl excluirServico;
    private final RegistrarServicoImpl registrarServico;

    @GetMapping("/estabelecimento/{id}")
    public List<ServicoDTO> buscarPorEtsbalecimento(@PathVariable Long id) {
        return buscarPorIdEstabelecimento.buscarPorIdEstabelecimento(id)
                .stream()
                .map(ServicoDTO::new)
                .toList();
    }

    @DeleteMapping("/{id}")
    public void excluirServico(@PathVariable Long id) {
        excluirServico.cancelar(id);
    }

    @PostMapping
    public ServicoDTO registrar(ServicoDTO servicoDTO) {
        return new ServicoDTO(
                registrarServico.registrarServico(
                        new Servico(
                                servicoDTO.id(),
                                servicoDTO.nome(),
                                servicoDTO.valor(),
                                servicoDTO.idEstabelecimento()
                        )
                )
        );
    }
}

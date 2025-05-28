package com.provasubstitutiva.fiap.infra.controller.avaliacao;

import com.provasubstitutiva.fiap.application.usecase.avaliacao.impl.*;
import com.provasubstitutiva.fiap.domain.model.Avaliacao;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/avaliacoes")
@AllArgsConstructor
public class AvaliacaoController {

    private final AvaliarEstabelecimentoImpl avaliarEstabelecimento;
    private final AvaliarProfissionalImpl avaliarProfissional;
    private final BuscarAvaliacoesPorIdClienteImpl buscarAvaliacoesPorIdCliente;
    private final BuscarAvaliacoesPorIdEstabalecimentoImpl buscarAvaliacoesPorIdEstabalecimento;
    private final EditarAvaliacaoImpl editarAvaliacao;
    private final ExcluirAvaliacaoImpl excluirAvaliacao;

    @PostMapping("/estabelecimento")
    public AvaliacaoDTO avaliarEstabelecimento(AvaliacaoDTO avaliacaoDTO) {
        return new AvaliacaoDTO(
                avaliarEstabelecimento.fazerAvaliacao(
                        new Avaliacao(
                                avaliacaoDTO.id(),
                                avaliacaoDTO.idCliente(),
                                avaliacaoDTO.estrelas(),
                                avaliacaoDTO.comentario(),
                                avaliacaoDTO.idEstabelecimento(),
                                avaliacaoDTO.idProfissional()
                        )
                )
        );
    }

    @PostMapping("/profissional")
    public AvaliacaoDTO avaliarProfissional(AvaliacaoDTO avaliacaoDTO) {
        return new AvaliacaoDTO(
                avaliarProfissional.avaliarProfissional(
                        new Avaliacao(
                                avaliacaoDTO.id(),
                                avaliacaoDTO.idCliente(),
                                avaliacaoDTO.estrelas(),
                                avaliacaoDTO.comentario(),
                                avaliacaoDTO.idEstabelecimento(),
                                avaliacaoDTO.idProfissional()
                        )
                )
        );
    }

    @GetMapping("/cliente/{id}")
    public List<AvaliacaoDTO> buscarPorCliente(@PathVariable Long id) {
        return buscarAvaliacoesPorIdCliente.buscarAvaliacaoPorIdCliente(id)
                .stream()
                .map(AvaliacaoDTO::new)
                .toList();
    }

    @GetMapping("/estabelecimento/{id}")
    public List<AvaliacaoDTO> buscarPorEstabelecimento(@PathVariable Long id) {
        return buscarAvaliacoesPorIdEstabalecimento.buscarporIdEstabelecimento(id)
                .stream()
                .map(AvaliacaoDTO::new)
                .toList();
    }

    @PutMapping("/{id}")
    public AvaliacaoDTO editarAvaliacao(@RequestBody AvaliacaoDTO avaliacaoDTO) {
        return new AvaliacaoDTO(
                editarAvaliacao.editar(
                        new Avaliacao(
                                avaliacaoDTO.id(),
                                avaliacaoDTO.idCliente(),
                                avaliacaoDTO.estrelas(),
                                avaliacaoDTO.comentario(),
                                avaliacaoDTO.idEstabelecimento(),
                                avaliacaoDTO.idProfissional()
                        )
                )
        );
    }

    @DeleteMapping("/{id}")
    public void excluirAvaliacao(@PathVariable Long id) {
        excluirAvaliacao.excluirAvaliacao(id);
    }
}

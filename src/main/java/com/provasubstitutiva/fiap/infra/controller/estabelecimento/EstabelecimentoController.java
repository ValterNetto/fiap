package com.provasubstitutiva.fiap.infra.controller.estabelecimento;

import com.provasubstitutiva.fiap.application.usecase.estabelecimento.impl.*;
import com.provasubstitutiva.fiap.domain.model.Estabelecimento;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/estabelecimentos")
@AllArgsConstructor
public class EstabelecimentoController {

    private final BuscarEstabelecimentoPorIdImpl buscarEstabelecimentoPorId;
    private final EditarEstabelecimentoPorIdImpl editarEstabelecimentoPorId;
    private final FiltragemBuscarEstabelecimentosPorEstrelasImpl filtragemBuscarEstabelecimentosPorEstrelas;
    private final FiltragemBuscarEstabelecimentosPorLatitudeELongitudeImpl filtragemBuscarEstabelecimentosPorLatitudeELongitude;
    private final FiltragemBuscarEstabelecimentosPorNomeImpl filtragemBuscarEstabelecimentosPorNome;
    private final FiltragemBuscarEstabelecimentosPorServicoImpl filtragemBuscarEstabelecimentosPorServico;
    private final RegistrarEstabelecimentoImpl registrarEstabelecimento;

    @GetMapping("/{id}")
    public EstabelecimentoDTO buscarPorId(@PathVariable Long id) {
        return new EstabelecimentoDTO(
                buscarEstabelecimentoPorId.buscarEstabelecimentoPorId(id)
        );
    }

    @PutMapping
    public EstabelecimentoDTO editarEstabelecimento(@RequestBody EstabelecimentoDTO estabelecimentoDTO) {
        return new EstabelecimentoDTO(
                editarEstabelecimentoPorId.editarEstabelecimento(
                        new Estabelecimento(
                                estabelecimentoDTO.id(),
                                estabelecimentoDTO.nome(),
                                estabelecimentoDTO.idEndereco(),
                                estabelecimentoDTO.email()
                        )
                )
        );
    }

    @GetMapping("/filtro/estrelas")
    public List<EstabelecimentoDTO> filtragemPorEstrelas(@RequestParam int estrelas) {
        return filtragemBuscarEstabelecimentosPorEstrelas
                .listaEstabelecimentosPorEstrelas(estrelas)
                .stream()
                .map(EstabelecimentoDTO::new)
                .toList();
    }

    @GetMapping("/filtro/geolocalizacao")
    public List<EstabelecimentoDTO> filtragemPorEstrelas(@RequestParam double latitude,
                                                         @RequestParam double longitude,
                                                         @RequestParam int metros) {
        return filtragemBuscarEstabelecimentosPorLatitudeELongitude
                .buscarEstabelecimentoPorLatitudeELongitude(
                        latitude,
                        longitude,
                        metros
                )
                .stream()
                .map(EstabelecimentoDTO::new)
                .toList();
    }

    @GetMapping("/filtro/nomes")
    public List<EstabelecimentoDTO> filtragemPorNome(@RequestParam String nome) {
        return filtragemBuscarEstabelecimentosPorNome
                .buscarPorNome(nome)
                .stream()
                .map(EstabelecimentoDTO::new)
                .toList();
    }

    @GetMapping("/filtro/servicos")
    public List<EstabelecimentoDTO> filtragemPorServicos(@RequestParam String nomeServico) {
        return filtragemBuscarEstabelecimentosPorServico
                .buscarEstabelecimentosPorServico(nomeServico)
                .stream()
                .map(EstabelecimentoDTO::new)
                .toList();
    }

    @PostMapping
    public EstabelecimentoDTO registrarEstabelecimento(@RequestBody EstabelecimentoDTO estabelecimentoDTO) {
        return new EstabelecimentoDTO(
                registrarEstabelecimento.registrarEstabelecimento(
                        new Estabelecimento(
                                estabelecimentoDTO.id(),
                                estabelecimentoDTO.nome(),
                                estabelecimentoDTO.idEndereco(),
                                estabelecimentoDTO.email()
                        )
                )
        );
    }
}
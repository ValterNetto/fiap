package com.provasubstitutiva.fiap.infra.controller.foto;

import com.provasubstitutiva.fiap.application.usecase.foto.impl.AdicionarFotoImpl;
import com.provasubstitutiva.fiap.application.usecase.foto.impl.BuscarFotosPorIdEstabelecimentoImpl;
import com.provasubstitutiva.fiap.application.usecase.foto.impl.ExcluirFotoImpl;
import com.provasubstitutiva.fiap.domain.model.Foto;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fotos")
@AllArgsConstructor
public class FotoController {

    private final AdicionarFotoImpl adicionarFoto;
    private final BuscarFotosPorIdEstabelecimentoImpl buscarFotosPorIdEstabelecimento;
    private final ExcluirFotoImpl excluirFoto;

    @PostMapping
    public FotoDTO adicionarFoto(@RequestBody FotoDTO fotoDTO) {
        return new FotoDTO(
                adicionarFoto.adicionarFoto(
                        new Foto(
                                fotoDTO.id(),
                                fotoDTO.nome(),
                                fotoDTO.foto(),
                                fotoDTO.idEstabelecimento()
                        )
                )
        );
    }

    @GetMapping
    public List<FotoDTO> buscarFotos(@RequestParam Long idEstabelecimento) {
        return buscarFotosPorIdEstabelecimento.buscarFotoPorIdEstabelecimento(idEstabelecimento)
                .stream()
                .map(FotoDTO::new)
                .toList();
    }

    @DeleteMapping("/{id}")
    public void excluirFoto(@PathVariable Long id){
        excluirFoto.excluir(id);
    }
}

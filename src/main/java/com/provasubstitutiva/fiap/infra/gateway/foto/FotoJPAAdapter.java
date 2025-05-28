package com.provasubstitutiva.fiap.infra.gateway.foto;

import com.provasubstitutiva.fiap.application.usecase.foto.AdicionarFoto;
import com.provasubstitutiva.fiap.application.usecase.foto.BuscarFotosPorIdEstabelecimento;
import com.provasubstitutiva.fiap.application.usecase.foto.ExcluirFoto;
import com.provasubstitutiva.fiap.domain.model.Foto;
import com.provasubstitutiva.fiap.infra.persistence.foto.FotoRepository;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class FotoJPAAdapter implements
        AdicionarFoto,
        BuscarFotosPorIdEstabelecimento,
        ExcluirFoto {

    private final FotoRepository repository;
    private final FotoMapper mapper;

    @Override
    public Foto adicionarFoto(Foto foto) {
        return mapper.toDomain(repository.save(mapper.toEntity(foto)));
    }

    @Override
    public List<Foto> buscarFotoPorIdEstabelecimento(Long idEstabelecimento) {
        return repository.findByIdEstabelecimento(idEstabelecimento).stream().map(mapper::toDomain).toList();
    }

    @Override
    public void excluirFoto(Long id) {
        repository.deleteById(id);
    }
}

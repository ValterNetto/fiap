package com.provasubstitutiva.fiap.infra.gateway.endereco;

import com.provasubstitutiva.fiap.application.usecase.endereco.*;
import com.provasubstitutiva.fiap.domain.model.Endereco;
import com.provasubstitutiva.fiap.infra.persistence.endereco.EnderecoRepository;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class EnderecoJPAAdapter implements
        BuscarEnderecoPorId,
        BuscarEnderecoPorIdEstabelecimento,
        EditarEndereco,
        FiltragemBuscarEstabelecimentosPorLatitudeELongitude,
        RegistrarEndereco {

    private final EnderecoRepository repository;
    private final EnderecoMapper mapper;

    @Override
    public Endereco buscarEnderecoPorId(Long id) {
        return repository.findById(id).map(mapper::toDomain).orElse(null);
    }

    @Override
    public Endereco buscarPorIdEstabelecimento(Long id) {
        return repository.findByIdEstabelecimento(id).map(mapper::toDomain).orElse(null);
    }

    @Override
    public Endereco editarEndereco(Endereco endereco) {
        return mapper.toDomain(repository.save(mapper.toEntity(endereco)));
    }

    @Override
    public List<Long> buscarPorLatitudeELongitude(double latMin, double longMin, double latMax, double longMax) {
        return repository.findIdEstabelecimentoByLatLongInRange(latMin, latMax, longMin, longMax);
    }

    @Override
    public Endereco registrarEndereco(Endereco endereco) {
        return mapper.toDomain(repository.save(mapper.toEntity(endereco)));
    }
}

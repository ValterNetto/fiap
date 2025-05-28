package com.provasubstitutiva.fiap.infra.gateway.estabelecimento;

import com.provasubstitutiva.fiap.application.usecase.estabelecimento.BuscarEstabelecimentoPorId;
import com.provasubstitutiva.fiap.application.usecase.estabelecimento.EditarEstabelecimento;
import com.provasubstitutiva.fiap.application.usecase.estabelecimento.FiltragemBuscarEstabelecimentosPorNome;
import com.provasubstitutiva.fiap.application.usecase.estabelecimento.RegistrarEstabelecimento;
import com.provasubstitutiva.fiap.domain.model.Estabelecimento;
import com.provasubstitutiva.fiap.infra.persistence.estabelecimento.EstabelecimentoRepository;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class EstabelecimentoJPAAdapter implements
        BuscarEstabelecimentoPorId,
        EditarEstabelecimento,
        FiltragemBuscarEstabelecimentosPorNome,
        RegistrarEstabelecimento {

    private final EstabelecimentoRepository repository;
    private final EstabelecimentoMapper mapper;

    @Override
    public Estabelecimento buscarEstabelecimentoPorId(Long id) {
        return repository.findById(id).map(mapper::toDomain).orElse(null);
    }

    @Override
    public Estabelecimento editarEstabelecimento(Estabelecimento estabelecimento) {
        return mapper.toDomain(repository.save(mapper.toEntity(estabelecimento)));
    }

    @Override
    public List<Estabelecimento> buscarPorNome(String nome) {
        return repository.findAllByNome(nome).stream().map(mapper::toDomain).toList();
    }

    @Override
    public Estabelecimento registrarEstabelecimento(Estabelecimento estabelecimento) {
        return mapper.toDomain(repository.save(mapper.toEntity(estabelecimento)));
    }
}

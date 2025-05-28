package com.provasubstitutiva.fiap.infra.gateway.avaliacao;

import com.provasubstitutiva.fiap.application.usecase.avaliacao.*;
import com.provasubstitutiva.fiap.domain.model.Avaliacao;
import com.provasubstitutiva.fiap.infra.persistence.avaliacao.AvaliacaoRepository;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class AvaliacaoJPAAdapter implements
        AvaliarEstabelecimento,
        AvaliarProfissional,
        BuscarAvaliacaoPorId,
        BuscarAvaliacoesPorIdCliente,
        BuscarAvaliacoesPorIdEstabelecimento,
        EditarAvaliacao,
        ExcluirAvaliacao,
        VerTodasAsAvaliacoes {

    private final AvaliacaoRepository repository;
    private final AvaliacaoMapper mapper;

    @Override
    public Avaliacao fazerAvaliacao(Avaliacao avaliacao) {
        return mapper.toDomain(repository.save(mapper.toEntity(avaliacao)));
    }

    @Override
    public Avaliacao avaliarProfissional(Avaliacao avaliacao) {
        return mapper.toDomain(repository.save(mapper.toEntity(avaliacao)));
    }

    @Override
    public Avaliacao buscarAvaliacaoPorId(Long id) {
        return repository.findById(id).map(mapper::toDomain).orElse(null);
    }

    @Override
    public List<Avaliacao> buscarAvaliacoesPorIdCliente(Long idCliente) {
        return repository.findByIdCliente(idCliente)
                .stream()
                .map(mapper::toDomain)
                .toList();
    }

    @Override
    public List<Avaliacao> buscarPorIdEstabelecimento(Long idEstabelecimento) {
        return repository.findByIdEstabelecimento(idEstabelecimento)
                .stream()
                .map(mapper::toDomain)
                .toList();
    }

    @Override
    public Avaliacao editarAvaliacao(Avaliacao avaliacao) {
        return mapper.toDomain(repository.save(mapper.toEntity(avaliacao)));
    }

    @Override
    public void excluir(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<Avaliacao> verTodasAsAvaliacoes() {
        return repository.findAll()
                .stream()
                .map(mapper::toDomain)
                .toList();
    }
}

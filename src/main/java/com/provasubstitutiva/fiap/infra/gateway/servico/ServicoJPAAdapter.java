package com.provasubstitutiva.fiap.infra.gateway.servico;

import com.provasubstitutiva.fiap.application.usecase.servico.*;
import com.provasubstitutiva.fiap.domain.model.Servico;
import com.provasubstitutiva.fiap.infra.persistence.servico.ServicoRepository;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class ServicoJPAAdapter implements
        BuscarPorIdEstabelecimento,
        BuscarServicoPorId,
        BuscarServicoPorNome,
        ExcluirServico,
        RegistrarServico {

    private final ServicoRepository repository;
    private final ServicoMapper mapper;

    @Override
    public List<Servico> buscarPorIdEstabelecimento(Long id) {
        return repository.findByIdEstabelecimento(id)
                .stream()
                .map(mapper::toDomain)
                .toList();
    }

    @Override
    public Servico buscarServicoPorId(Long id) {
        return repository.findById(id).map(mapper::toDomain).orElse(null);
    }

    @Override
    public List<Servico> buscarServicoPorNome(String nome) {
        return repository.findByNome(nome)
                .stream()
                .map(mapper::toDomain)
                .toList();
    }

    @Override
    public void cancelarServico(Long idServico) {
        repository.deleteById(idServico);
    }

    @Override
    public Servico registrarServico(Servico servico) {
        return mapper.toDomain(repository.save(mapper.toEntity(servico)));
    }
}

package com.provasubstitutiva.fiap.infra.persistence.servico;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ServicoRepository extends JpaRepository<ServicoEntity, Long> {
    List<ServicoEntity> findByIdEstabelecimento(Long idEstabelecimento);
    List<ServicoEntity> findByNome(String nome);
}

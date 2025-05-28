package com.provasubstitutiva.fiap.infra.persistence.avaliacao;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AvaliacaoRepository extends JpaRepository<AvaliacaoEntity, Long> {
    List<AvaliacaoEntity> findByIdCliente(Long idCliente);
    List<AvaliacaoEntity> findByIdEstabelecimento(Long idCliente);
}

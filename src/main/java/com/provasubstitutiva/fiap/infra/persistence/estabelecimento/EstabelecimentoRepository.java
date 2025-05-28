package com.provasubstitutiva.fiap.infra.persistence.estabelecimento;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EstabelecimentoRepository extends JpaRepository<EstabelecimentoEntity, Long> {
    List<EstabelecimentoEntity> findAllByNome(String nome);
}

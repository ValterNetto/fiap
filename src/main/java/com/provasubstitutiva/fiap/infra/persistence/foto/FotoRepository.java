package com.provasubstitutiva.fiap.infra.persistence.foto;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FotoRepository extends JpaRepository<FotoEntity, Long> {
    List<FotoEntity> findByIdEstabelecimento(Long idEstabelecimento);
}

package com.provasubstitutiva.fiap.infra.persistence.endereco;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface EnderecoRepository extends JpaRepository<EnderecoEntity, Long> {
    Optional<EnderecoEntity> findByIdEstabelecimento(Long idEstabelecimento);

    @Query("""
                SELECT e.idEstabelecimento 
                FROM EnderecoEntity e 
                WHERE e.latitude BETWEEN :latMin AND :latMax 
                  AND e.longitude BETWEEN :lngMin AND :lngMax
            """)
    List<Long> findIdEstabelecimentoByLatLongInRange(
            @Param("latMin") double latMin,
            @Param("latMax") double latMax,
            @Param("lngMin") double lngMin,
            @Param("lngMax") double lngMax
    );
}

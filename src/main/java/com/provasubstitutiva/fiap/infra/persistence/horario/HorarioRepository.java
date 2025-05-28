package com.provasubstitutiva.fiap.infra.persistence.horario;

import com.provasubstitutiva.fiap.domain.model.constant.DiasDaSemanaEnum;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface HorarioRepository extends JpaRepository<HorarioEntity, Long> {
    Optional<HorarioEntity> findByIdEstabelecimentoAndDiaDaSemana(Long idEstabelecimento, DiasDaSemanaEnum diaDaSemana);
    List<HorarioEntity> findByidEstabelecimento(Long idEstabelecimento);
}

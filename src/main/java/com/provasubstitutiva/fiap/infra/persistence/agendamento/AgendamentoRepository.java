package com.provasubstitutiva.fiap.infra.persistence.agendamento;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface AgendamentoRepository extends JpaRepository<AgendamentoEntity, Long> {
    List<AgendamentoEntity> findByIdCliente(Long idCliente);

    List<AgendamentoEntity> findByIdProfissionalAndData(Long idProfissional, LocalDate data);
}

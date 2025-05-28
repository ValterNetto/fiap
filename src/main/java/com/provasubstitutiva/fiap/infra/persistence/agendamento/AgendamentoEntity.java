package com.provasubstitutiva.fiap.infra.persistence.agendamento;

import com.provasubstitutiva.fiap.domain.model.constant.StatusEnum;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AgendamentoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long idProfissional;
    private Long idEstabelecimento;
    private Long idCliente;
    private Long idServico;
    private StatusEnum status;
    private LocalDate data;
    private LocalTime horaInicio;
    private LocalTime horaTermino;
}

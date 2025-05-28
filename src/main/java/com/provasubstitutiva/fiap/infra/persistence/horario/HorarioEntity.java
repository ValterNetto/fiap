package com.provasubstitutiva.fiap.infra.persistence.horario;

import com.provasubstitutiva.fiap.domain.model.constant.DiasDaSemanaEnum;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HorarioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private DiasDaSemanaEnum diaDaSemana;
    private LocalTime inicio;
    private LocalTime fim;
    private Long idEstabelecimento;
}

package com.provasubstitutiva.fiap.domain.model.constant;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DiasDaSemanaEnumTest {

    @Test
    void deveRetornarNomeCorretoDoDiaDaSemana() {
        assertEquals("Segunda", DiasDaSemanaEnum.MONDAY.getDiaDaSemana());
        assertEquals("Terça", DiasDaSemanaEnum.TUESDAY.getDiaDaSemana());
        assertEquals("Quarta", DiasDaSemanaEnum.WEDNESDAY.getDiaDaSemana());
        assertEquals("Quinta", DiasDaSemanaEnum.THURSDAY.getDiaDaSemana());
        assertEquals("Sexta", DiasDaSemanaEnum.FRIDAY.getDiaDaSemana());
        assertEquals("Sábado", DiasDaSemanaEnum.SATURDAY.getDiaDaSemana());
        assertEquals("Domingo", DiasDaSemanaEnum.SUNDAY.getDiaDaSemana());
    }

    @Test
    void todosOsEnumsDevemTerDescricaoNaoNula() {
        for (DiasDaSemanaEnum dia : DiasDaSemanaEnum.values()) {
            assertNotNull(dia.getDiaDaSemana(), "Descrição do dia não pode ser nula");
        }
    }
}

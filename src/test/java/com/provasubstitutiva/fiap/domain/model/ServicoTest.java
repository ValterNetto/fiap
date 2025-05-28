package com.provasubstitutiva.fiap.domain.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ServicoTest {

    @Test
    void deveCriarServicoComTodosOsCampos() {
        Servico servico = new Servico(1L, "Corte Masculino", 50, 10L);

        assertEquals(1L, servico.getId());
        assertEquals("Corte Masculino", servico.getNome());
        assertEquals(50, servico.getValor());
        assertEquals(10L, servico.getIdEstabelecimento());
    }

    @Test
    void devePermitirSettersEAcessarComGetters() {
        Servico servico = new Servico();
        servico.setId(2L);
        servico.setNome("Corte Feminino");
        servico.setValor(80);
        servico.setIdEstabelecimento(20L);

        assertEquals(2L, servico.getId());
        assertEquals("Corte Feminino", servico.getNome());
        assertEquals(80, servico.getValor());
        assertEquals(20L, servico.getIdEstabelecimento());
    }
}

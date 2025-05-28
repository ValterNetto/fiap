package com.provasubstitutiva.fiap.infra.gateway.endereco;

import com.provasubstitutiva.fiap.domain.model.Endereco;
import com.provasubstitutiva.fiap.infra.persistence.endereco.EnderecoEntity;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EnderecoMapperTest {

    private final EnderecoMapper mapper = new EnderecoMapper();

    @Test
    void testToDomain() {
        EnderecoEntity entity = new EnderecoEntity(
                1L,
                "Rua das Flores",
                "12345-678",
                "100",
                -23.5,
                -46.6,
                10L
        );

        Endereco domain = mapper.toDomain(entity);

        assertEquals(entity.getId(), domain.getId());
        assertEquals(entity.getLogradouro(), domain.getLogradouro());
        assertEquals(entity.getCep(), domain.getCep());
        assertEquals(entity.getNumero(), domain.getNumero());
        assertEquals(entity.getLatitude(), domain.getLatitude());
        assertEquals(entity.getLongitude(), domain.getLongitude());
        assertEquals(entity.getIdEstabelecimento(), domain.getIdEstabelecimento());
    }

    @Test
    void testToEntity() {
        Endereco domain = new Endereco(
                2L,
                "Avenida Brasil",
                "98765-432",
                "200",
                -22.9,
                -43.2,
                20L
        );

        EnderecoEntity entity = mapper.toEntity(domain);

        assertEquals(domain.getId(), entity.getId());
        assertEquals(domain.getLogradouro(), entity.getLogradouro());
        assertEquals(domain.getCep(), entity.getCep());
        assertEquals(domain.getNumero(), entity.getNumero());
        assertEquals(domain.getLatitude(), entity.getLatitude());
        assertEquals(domain.getLongitude(), entity.getLongitude());
        assertEquals(domain.getIdEstabelecimento(), entity.getIdEstabelecimento());
    }
}

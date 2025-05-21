package com.provasubstitutiva.fiap.application.usecase.estabelecimento.impl;

import com.provasubstitutiva.fiap.application.usecase.avaliacao.impl.VerTodasAsAvaliacoes;
import com.provasubstitutiva.fiap.application.usecase.estabelecimento.BuscarEstabelecimentoPorId;
import com.provasubstitutiva.fiap.domain.model.Avaliacao;
import com.provasubstitutiva.fiap.domain.model.Estabelecimento;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.stream.Collectors;

@AllArgsConstructor
public class FiltragemBuscarEstabelecimentosPorEstrelasImpl {

    private final VerTodasAsAvaliacoes verTodasAsAvaliacoes;
    private final BuscarEstabelecimentoPorId buscarEstabelecimentoPorId;


    public List<Estabelecimento> listaEstabelecimentosPorEstrelas(int estrelas) {
        List<Avaliacao> avaliacoes = verTodasAsAvaliacoes.verTodasAsAvaliacoes();
        Map<Long, Double> medias = avaliacoes
                .stream()
                .collect(
                        Collectors.groupingBy(
                                Avaliacao::getIdEstabelecimento,
                                Collectors.averagingDouble(Avaliacao::getEstrelas)
                        ));

        double max = (estrelas == 5) ? 5.0001 : estrelas + 1.0;

        return medias.entrySet().stream()
                .filter(entry -> entry.getValue() >= estrelas && entry.getValue() < max)
                .map(entry -> {
                    try {
                        return buscarEstabelecimentoPorId.buscarEstabelecimentoPorId(entry.getKey());
                    } catch (NoSuchElementException e) {
                        return null;
                    }
                })
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }
}

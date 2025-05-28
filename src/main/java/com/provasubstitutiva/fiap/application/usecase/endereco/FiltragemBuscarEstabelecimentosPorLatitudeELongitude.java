package com.provasubstitutiva.fiap.application.usecase.endereco;

import com.provasubstitutiva.fiap.domain.model.Estabelecimento;

import java.util.List;

public interface FiltragemBuscarEstabelecimentosPorLatitudeELongitude {
    List<Long> buscarPorLatitudeELongitude(
            double minLatitude,
            double minLongitude,
            double maxLatitude,
            double maxLongitude);
}

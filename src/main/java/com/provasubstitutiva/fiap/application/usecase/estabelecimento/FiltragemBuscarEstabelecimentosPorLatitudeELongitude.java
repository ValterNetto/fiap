package com.provasubstitutiva.fiap.application.usecase.estabelecimento;

import com.provasubstitutiva.fiap.domain.model.Estabelecimento;

import java.util.List;

public interface FiltragemBuscarEstabelecimentosPorLatitudeELongitude {
    List<Estabelecimento> buscarPorLatitudeELongitude(double latitude,
                                                      double longitude,
                                                      int metros);
}

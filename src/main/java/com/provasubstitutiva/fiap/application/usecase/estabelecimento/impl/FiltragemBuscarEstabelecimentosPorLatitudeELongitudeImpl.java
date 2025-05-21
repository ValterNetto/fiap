package com.provasubstitutiva.fiap.application.usecase.estabelecimento.impl;

import com.provasubstitutiva.fiap.application.usecase.estabelecimento.FiltragemBuscarEstabelecimentosPorLatitudeELongitude;
import com.provasubstitutiva.fiap.domain.model.Estabelecimento;

import java.util.List;

public class FiltragemBuscarEstabelecimentosPorLatitudeELongitudeImpl {

    private final FiltragemBuscarEstabelecimentosPorLatitudeELongitude filtragemBuscarEstabelecimentosPorLatitudeELongitude;

    public FiltragemBuscarEstabelecimentosPorLatitudeELongitudeImpl(FiltragemBuscarEstabelecimentosPorLatitudeELongitude filtragemBuscarEstabelecimentosPorLatitudeELongitude) {
        this.filtragemBuscarEstabelecimentosPorLatitudeELongitude = filtragemBuscarEstabelecimentosPorLatitudeELongitude;
    }

    public List<Estabelecimento> buscarEstabelecimentoPorLatitudeELongitude(double latitude, double longitude, int metros) {
        return filtragemBuscarEstabelecimentosPorLatitudeELongitude
                .buscarPorLatitudeELongitude(latitude, longitude, metros);
    }
}
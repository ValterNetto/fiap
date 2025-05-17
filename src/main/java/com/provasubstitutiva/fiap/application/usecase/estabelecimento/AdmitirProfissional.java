package com.provasubstitutiva.fiap.application.usecase.estabelecimento;

import com.provasubstitutiva.fiap.domain.model.Profissional;

public interface AdmitirProfissional {
    Profissional admitirProfissional(Long idEstabelecimento, Long idProfissional);
}

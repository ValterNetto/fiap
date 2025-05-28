package com.provasubstitutiva.fiap.infra.gateway.notificacao;

import com.provasubstitutiva.fiap.application.usecase.notificacao.EnviarEmailNotificandoAgendamento;

public class EnvioDeEmailAdapter implements
        EnviarEmailNotificandoAgendamento {

    @Override
    public void enviarEmailNotificandoOAgendamento(String emailCliente, String emailProfissional) {
        //Lógica para realizar o agendamento no Outlook;
    }
}
